package de.fost.typechef.parser.java15


import de.fosd.typechef.featureexpr.{FeatureExpr, FeatureExprFactory}
import de.fosd.typechef.parser._
import de.fosd.typechef.parser.java15._
import de.fosd.typechef.parser.java15.lexer._
import org.junit.Assert._
import org.junit.Test

import java.io._
import scala.annotation.unused

class ParserTest {

  @unused
  private def createLexer(str: String) = {
    val input = str.getBytes
    val a = new ByteArrayInputStream(input)
    val o = new OffsetCharStream(a)
    new Java15ParserTokenManager(o)
  }

  val p = new JavaParser()

  def assertParseable(code: String, mainProduction: (TokenReader[TokenWrapper, Null], FeatureExpr) => p.MultiParseResult[Any]): Unit = {
    val actual = mainProduction(JavaLexer.lex(code.stripMargin), FeatureExprFactory.True)
    System.out.println(actual)
    (actual: @unchecked) match {
      case p.Success(_, unparsed) =>
        assertTrue("parser did not reach end of token stream: " + unparsed, unparsed.atEnd)
      //succeed
      case p.NoSuccess(msg, unparsed, inner) =>
        fail(msg + " at " + unparsed + " " + inner)
    }
  }

  @Test
  def testParserSimple6(): Unit = assertParseable("this.getClass().getName()", p.phrase(p.EqualityExpression))

  @Test
  def testParserSimple5(): Unit = assertParseable("System.out.println(\"AbstractController::postCommand - Current controller is: \" + this.getClass().getName());", p.phrase(p.Statement))

  @Test
  def testParserSimple4(): Unit = assertParseable("boolean", p.phrase(p.ResultType))

  @Test
  def testParserSimple(): Unit = assertParseable("class X {}", p.phrase(p.CompilationUnit))

  @Test
  def testParserSimple2(): Unit = assertParseable("package lancs.mobilemedia.core.comms;", p.PackageDeclaration)

  @Test
  def testParserSimple3(): Unit = assertParseable("public abstract boolean sendImage(byte[] imageData);", p.phrase(p.ClassOrInterfaceBodyDeclaration))
}