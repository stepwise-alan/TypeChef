package de.fosd.typechef.parser.java15

import de.fosd.typechef.featureexpr.{FeatureExpr, FeatureExprFactory}
import de.fosd.typechef.parser._
import de.fosd.typechef.parser.java15.lexer.Java15ParserConstants._
import de.fosd.typechef.parser.java15.lexer._

import java.io._
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

/**
 * builds on top of a standard lexer (generated as part of CIDE
 * from a gcide grammar (internally using JavaCC))
 *
 * the main extensions are:
 * (1) we look at special tokens and recognize Antenna
 * IFDEF commands inside comments
 *
 */
object JavaLexer {

  def lexFile(fileName: String): TokenReader[TokenWrapper, Null] =
    prepareTokens(new Java15ParserTokenManager(new OffsetCharStream(new FileReader(fileName))), fileName)

  //
  //    def lexStream(stream: InputStream, filePath: String, directory: String): TokenReader[TokenWrapper, CTypeContext] =
  //        prepareTokens(new PartialPPLexer().parseStream(stream, filePath, directory))
  //
  def lex(text: String): TokenReader[TokenWrapper, Null] =
    prepareTokens(new Java15ParserTokenManager(new OffsetCharStream(new ByteArrayInputStream(text.getBytes))), "text input")

  private class PresenceConditionStack() {
    var stack: List[List[FeatureExpr]] = List()

    //add new layer
    def addIf(condition: FeatureExpr): Unit = {
      stack = List(condition) :: stack
    }

    //add innermost layer
    def addElse(condition: FeatureExpr): Unit = {
      if (stack.isEmpty)
        throw new PreprocessorException("#el[se|if] before #if")
      if (stack.head.isEmpty) throw new PreprocessorException("#el[se|if] before #if - ")
      stack = (condition :: stack.head) :: stack.tail
    }

    //pop
    def addEndif(): Unit = {
      if (stack.isEmpty) throw new PreprocessorException("#endif before #if")
      stack = stack.tail
    }

    def getPresenceCondition: FeatureExpr = //should be cached eventually
      getCondition(stack)

    private def getConditionS(s: List[FeatureExpr]) =
      s.tail.foldRight(s.head)(_.not() and _)

    private def getCondition(s: List[List[FeatureExpr]]): FeatureExpr =
      if (s.isEmpty) FeatureExprFactory.True
      else getConditionS(s.head) and getCondition(s.tail)

    def isEmpty: Boolean = stack.isEmpty
  }

  def prepareTokens(lexer: Java15ParserTokenManager, fileName: String): TokenReader[TokenWrapper, Null] = {
    var tokenStream: List[TokenWrapper] = List()
    var next = lexer.getNextToken
    //stack of lists of feature expressions (inner lists represent multiple conditions with if-else branches)
    val presenceConditionStack = new PresenceConditionStack

    def processPreprocessor(javaToken: Token): Unit = {
      if (javaToken.specialToken != null) {
        processPreprocessor(javaToken.specialToken)

        //search of #ifdef etc in comments
        if (javaToken.specialToken.kind == SINGLE_LINE_COMMENT)
          processComment(javaToken.specialToken.image.trim.substring(2))
      }
    }

    def processComment(comment: String): Unit = {
      if (comment.trim.startsWith("#")) {
        //update presence conditions for ifdef etc.
        val tokens = PreprocessorParser.lex(comment)
        if (PreprocessorParser.pifdef(tokens).successful)
          presenceConditionStack.addIf(PreprocessorParser.pifdef(tokens).get)
        else if (PreprocessorParser.pelifdef(tokens).successful)
          presenceConditionStack.addElse(PreprocessorParser.pelifdef(tokens).get)
        else if (PreprocessorParser.pelse(tokens).successful)
          presenceConditionStack.addElse(FeatureExprFactory.True)
        else if (PreprocessorParser.pendif(tokens).successful)
          presenceConditionStack.addEndif()
        else
          throw new PreprocessorException("Preprocessor directive " + comment + " not understood (possibly not implemented yet)")
      }
    }

    while (next.kind != Java15ParserConstants.EOF) {
      processPreprocessor(next)
      tokenStream = TokenWrapper.create(next, presenceConditionStack.getPresenceCondition, fileName) :: tokenStream
      next = lexer.getNextToken
    }
    processPreprocessor(next)
    if (!presenceConditionStack.isEmpty) throw new PreprocessorException("less #endif than #if")
    new TokenReader(tokenStream.reverse, 0, null, TokenWrapper.create(next, FeatureExprFactory.True, fileName))
  }

}

object PreprocessorParser extends StandardTokenParsers {
  lexical.delimiters ++= List("#", "(", ")", "&&", "||", "!")
  lexical.reserved ++= List("ifdef", "ifndef", "elifdef", "elifndef", "else", "endif", "if", "elif")

  //ifdef and ifndef
  def pifdef: PreprocessorParser.Parser[FeatureExpr] =
    phrase("#" ~> ("ifdef" ~> atomicFeature
      | "ifndef" ~> atomicFeature ^^ {
      _.not()
    }
      | "if" ~> featureExpr))

  //elifdef and elifndef
  def pelifdef: PreprocessorParser.Parser[FeatureExpr] = phrase("#" ~> ("elifdef" ~> atomicFeature
    | "elifndef" ~> atomicFeature ^^ {
    _.not()
  }
    | "elif" ~> featureExpr))

  def pelse: PreprocessorParser.Parser[String ~ String] = phrase("#" ~ "else")

  def pendif: PreprocessorParser.Parser[String ~ String] = phrase("#" ~ "endif")

  def featureExpr: Parser[FeatureExpr] =
    orExpr

  def orExpr: PreprocessorParser.Parser[FeatureExpr] = andExpr ~ opt("||" ~> featureExpr) ^^ {
    case a ~ None => a
    case a ~ Some(b) => a or b
  }

  def andExpr: PreprocessorParser.Parser[FeatureExpr] = literal ~ opt("&&" ~> featureExpr) ^^ {
    case a ~ None => a
    case a ~ Some(b) => a and b
  }

  def literal: PreprocessorParser.Parser[FeatureExpr] =
    ("(" ~> featureExpr <~ ")" |
      "!" ~> featureExpr ^^ {
        _.not()
      }
      | atomicFeature)

  def atomicFeature: PreprocessorParser.Parser[FeatureExpr] =
    "1" ^^ { _ => FeatureExprFactory.True } |
      "0" ^^ { _ => FeatureExprFactory.False } |
      ident ^^ {
        FeatureExprFactory.createDefinedExternal
      }

  def lex(s: String) =
    new lexical.Scanner(s)
}

class PreprocessorException(msg: String) extends Exception(msg)