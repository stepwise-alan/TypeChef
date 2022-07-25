package de.fosd.typechef.parser.test

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr._
import de.fosd.typechef.parser._
import de.fosd.typechef.parser.test.parsers._
import junit.framework._
import org.junit.Assert._
import org.junit.Test

class DigitListParserTest extends TestCase {

  val f1 = FeatureExprFactory.createDefinedExternal("a")
  val f2 = FeatureExprFactory.createDefinedExternal("b")

  def t(text: String): MyToken = t(text, FeatureExprFactory.True)

  def t(text: String, feature: FeatureExpr): MyToken = new MyToken(text, feature)

  def assertParseResult(expected: AST, actual: parser.ParseResult[Conditional[AST]]): Unit = {
    assertParseResult(One(expected), actual)
  }

  def assertParseResult(expected: Conditional[AST], actual: parser.ParseResult[Conditional[AST]]): Unit = {
    System.out.println(actual)
    actual match {
      case parser.Success(ast, unparsed) =>
        assertTrue("parser did not reach end of token stream: " + unparsed, unparsed.atEnd)
        assertEquals("incorrect parse result", expected, ast)
      case noSuccess: parser.NoSuccess =>
        fail(noSuccess.msg + " at " + noSuccess.nextInput + " " + noSuccess.innerErrors)
    }
  }

  val parser = new DigitListParser()

  @Test
  def testParseSimpleList(): Unit = {
    {
      val input = List(t("("), t("1"), t(")"))
      val expected = DigitList(List(Lit(1)))
      assertParseResult(expected, parser.parse(input))
    }
    {
      val input = List(t("("), t("1"), t("2"), t(")"))
      val expected = DigitList(List(Lit(1), Lit(2)))
      assertParseResult(expected, parser.parse(input))
    }
  }

  def testParseOptSimpleList1(): Unit = {

    val input = List(t("("), t("1", f1), t("2", f1.not()), t(")"))
    val expected = Choice(f1, One(DigitList(List(Lit(1)))), One(DigitList(List(Lit(2)))))
    // DigitList(List(Alt(f1,Lit(1),Lit(2))))
    assertParseResult(expected, parser.parse(input))
  }

  def testParseOptSimpleList2(): Unit = {
    val input = List(t("("), t("1", f1), t("1"), t("2"), t(")"))
    val expected = Choice(f1, One(DigitList(List(Lit(1), Lit(1), Lit(2)))), One(DigitList(List(Lit(1), Lit(2)))))
    // DigitList(List(Alt(f1,Lit(1),Nil),Lit(1),Lit(2))
    assertParseResult(expected, parser.parse(input))
  }

  def testParseOptSimpleList3(): Unit = {
    val input = List(t("("), t("1"), t("2"), t("3", f1), t(")"))
    val expected = Choice(f1, One(DigitList(List(Lit(1), Lit(2), Lit(3)))), One(DigitList(List(Lit(1), Lit(2)))))
    // DigitList(List(Lit(1),Lit(2),Alt(f1,Lit(3),Nil))
    assertParseResult(expected, parser.parse(input))
  }

  def testParseOptSimpleList4(): Unit = {
    val input = List(t("1"), t("3", f1))
    val expected = Choice(f1, One(DigitList(List(Lit(1), Lit(3)))), One(DigitList(List(Lit(1)))))
    //        DigitList(List(Lit(1),Lit(2),Alt(f1,Lit(3),Nil))
    val v = parser.digits(new TokenReader[MyToken, Any](input, 0, null, EofToken), FeatureExprFactory.True).expectOneResult
    println(v)
    assertParseResult(expected, v)
  }

}
