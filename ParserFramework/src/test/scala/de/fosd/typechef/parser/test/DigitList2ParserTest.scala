package de.fosd.typechef.parser.test

import de.fosd.typechef.conditional._
import de.fosd.typechef.parser.test.parsers._
import junit.framework._
import org.junit.Assert._
import org.junit.Test

class DigitList2ParserTest extends TestCase with DigitListUtilities {
  val newParser: DigitList2Parser = new DigitList2Parser() {
    type OptResult[T] = Opt[T]

    def myRepOpt[T](p: => MultiParser[T], productionName: String): MultiParser[List[OptResult[T]]] =
      repOpt(p)

    def digits: MultiParser[AST] =
      myRepOpt(digitList | (digit ^^ {
        One(_)
      }), "digitList") ^^ {
        //List(Opt(AST)) -> DigitList[List[Opt[Lit]]
        DigitList2
      }
  }


  def testError1(): Unit = {
    val input = List(t("("), t("3", f1), t(")", f1.not()), t(")"))
    val actual = newParser.parse(input)
    System.out.println(actual)
    actual match {
      case newParser.Success(_, _) =>
        fail("should not parse " + input + " but result was " + actual)
      case _: newParser.NoSuccess =>

    }
  }

  implicit def makeConditional(x: AST): Conditional[AST] = One(x)

  @Test
  def testParseSimpleList(): Unit = {
    {
      val input = List(t("("), t(")"))
      val expected = DigitList2(List())
      assertParseResult(expected, newParser.parse(input))
    }
    {
      val input = List(t("("), t("1"), t(")"))
      val expected = DigitList2(List(o(Lit(1))))
      assertParseResult(expected, newParser.parse(input))
    }
    {
      val input = List(t("("), t("1"), t("2"), t(")"))
      val expected = DigitList2(List(o(Lit(1)), o(Lit(2))))
      assertParseResult(expected, newParser.parse(input))
    }
  }

  @Test
  def testParseOptSimpleList1(): Unit = {
    val input = List(t("("), t("1", f1), t("2", f1.not()), t(")"))
    val expected = DigitList2(List(Opt(f1, Lit(1)), Opt(f1.not(), Lit(2))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testParseOptSimpleListFirst(): Unit = {
    val input = List(t("("), t("1", f1), t("1"), t("2"), t(")"))
    val expected = DigitList2(List(Opt(f1, Lit(1)), o(Lit(1)), o(Lit(2))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testParseOptSimpleListLast(): Unit = {
    val input = List(t("("), t("1"), t("2"), t("3", f1), t(")"))
    val expected = DigitList2(List(o(Lit(1)), o(Lit(2)), Opt(f1, Lit(3))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testParseOptSimpleListMid(): Unit = {
    val input = List(t("("), t("1"), t("2", f1), t("3"), t(")"))
    val expected = DigitList2(List(o(Lit(1)), Opt(f1, Lit(2)), o(Lit(3))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testParseOptSimpleListCompl1(): Unit = {
    val input = List(t("("), t("1"), t("2", f1), t("3", f2), t(")"))
    val expected = DigitList2(List(o(Lit(1)), Opt(f1, Lit(2)), Opt(f2, Lit(3))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testParseOptSimpleListCompl2(): Unit = {
    val input = List(t("("), t("1", f2), t("2", f1), t("3", f2), t(")"))
    val expected = DigitList2(List(Opt(f2, Lit(1)), Opt(f1, Lit(2)), Opt(f2, Lit(3))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testParseOptSimpleListCompl3(): Unit = {
    val input = List(t("("), t("1", f2), t("2", f1), t("3", f2.not()), t(")"))
    val expected = DigitList2(List(Opt(f2, Lit(1)), Opt(f1, Lit(2)), Opt(f2.not(), Lit(3))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testParseOptSimpleListCompl4(): Unit = {
    val input = List(t("("), t("1", f2), t("2", f2.not()), t("3", f2.not()), t(")"))
    val expected = DigitList2(List(Opt(f2, Lit(1)), Opt(f2.not(), Lit(2)), Opt(f2.not(), Lit(3))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testParseInterleaved1(): Unit = {
    val input = List(t("("), t("("), t("1"), t("2"), t(")"), t("3"), t(")"))
    val expected = DigitList2(List(o(DigitList2(List(o(Lit(1)), o(Lit(2))))), o(Lit(3))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testParseInterleaved2(): Unit = {
    val input = List(t("("), t("(", f1), t("1"), t("2"), t(")", f1), t("3"), t(")"))
    val expected = DigitList2(List(Opt(f1, DigitList2(List(Opt(True, Lit(1)), Opt(True, Lit(2))))), Opt(f1.not(), Lit(1)), Opt(f1.not(), Lit(2)), o(Lit(3))))
    assertParseResult(expected, newParser.parse(input))
  }

  def testNoBacktrace(): Unit = {
    val input = List(t("1"), t("("))
    // val expected = Lit(1)
    val actual = newParser.parse(input)
    println(actual)
    actual match {
      case newParser.Success(ast, unparsed) => fail("expected error, found " + ast + " - " + unparsed)
      case _: newParser.NoSuccess =>
    }
  }

  def assertParseResult(expected: Conditional[AST], actual: newParser.ParseResult[Conditional[AST]]): Unit = {
    System.out.println(actual)
    actual match {
      case newParser.Success(ast, unparsed) =>
        assertTrue("parser did not reach end of token stream: " + unparsed, unparsed.atEnd)
        assertEquals("incorrect parse result", One(outer(expected)), ast)
      case noSuccess: newParser.NoSuccess =>
        fail(noSuccess.msg + " at " + noSuccess.nextInput + " " + noSuccess.innerErrors)
    }
  }
}
