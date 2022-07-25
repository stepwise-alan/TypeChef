package de.fost.typechef.parser.java15


import de.fosd.typechef.featureexpr.FeatureExprFactory
import de.fosd.typechef.parser._
import de.fosd.typechef.parser.java15._
import de.fosd.typechef.parser.java15.lexer._
import org.junit.Assert._
import org.junit.Test

import java.io._

class LexerTest {

  private def createLexer(str: String) = {
    val input = str.getBytes
    val a = new ByteArrayInputStream(input)
    val o = new OffsetCharStream(a)
    new Java15ParserTokenManager(o)
  }

  @Test
  def testLexerBasic(): Unit = {
    val lexer = createLexer(
      """/* aa */
        	class
        	//#ifdef X
        	test {}
        	//#endif
                             	""")
    var next = lexer.getNextToken
    while (next.kind != Java15ParserConstants.EOF) {
      println(next)
      println(next.specialToken)
      next = lexer.getNextToken
    }
  }

  @Test
  def testJavaLexer(): Unit = {
    val result: TokenReader[TokenWrapper, Null] = JavaLexer.lex("class Test {}")
    assertEquals(4, result.tokens.size)
    assertTrue(result.tokens.forall(_.getFeature.isTautology))
  }

  @Test
  def testJavaLexerIfdef1(): Unit = {
    val result: TokenReader[TokenWrapper, Null] = JavaLexer.lex(
      """//#ifdef X
class Test {}
//#endif
                                                                 """)
    assertEquals(4, result.tokens.size)
    assertTrue(result.tokens.forall(_.getFeature.equivalentTo(FeatureExprFactory.createDefinedExternal("X"))))
  }

  @Test
  def testJavaLexerIfdef2(): Unit = {
    val result: TokenReader[TokenWrapper, Null] = JavaLexer.lex(
      """//#ifdef X
//docu
class Test {}
//#endif
                                                                 """)
    assertEquals(4, result.tokens.size)
    assertTrue(result.tokens.forall(_.getFeature.equivalentTo(FeatureExprFactory.createDefinedExternal("X"))))
  }

  @Test
  def unsupportedPreprocessorDirective1(): Unit = expectUnsupported(
    """//#define x 1
x""")

  @Test
  def unsupportedPreprocessorDirective2(): Unit = expectUnsupported(
    """//#if x==1" +
    		x""")

  @Test
  def errorOnIllformedNesting(): Unit = expectUnsupported(
    """//#ifdef X
    		class x {}""")

  @Test
  def errorOnIllformedNesting2(): Unit = expectUnsupported(
    """//#endif
    		class x{}""")

  @Test
  def innerParserTest(): Unit = {
    val tokens = PreprocessorParser.lex("#ifdef X")
    println(PreprocessorParser.pifdef(tokens))
    assertEquals(FeatureExprFactory.createDefinedExternal("X"), PreprocessorParser.pifdef(tokens).get)

  }

  private def expectUnsupported(code: String): Unit = {
    try {
      JavaLexer.lex(code)
      fail("succeeded without exception unexpectedly")

    } catch {
      case e: PreprocessorException => println(e) //ok
    }
  }

}