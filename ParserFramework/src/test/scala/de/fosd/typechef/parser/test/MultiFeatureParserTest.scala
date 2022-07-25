package de.fosd.typechef.parser.test

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr._
import de.fosd.typechef.parser._
import de.fosd.typechef.parser.test.parsers._
import junit.framework._
import org.junit.Assert._
import org.junit.Test

class MultiFeatureParserTest extends TestCase {

  val f1 = FeatureExprFactory.createDefinedExternal("a")
  val f2 = FeatureExprFactory.createDefinedExternal("b")

  def t(text: String): MyToken = t(text, FeatureExprFactory.True)

  def t(text: String, feature: FeatureExpr): MyToken = new MyToken(text, feature)

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

  val parser = new MultiExpressionParser()

  @Test
  def testParseLit(): Unit = {
    val input = List(t("1"))
    val expected = Lit(1)
    assertParseResult(expected, parser.parse(input))
  }

  private implicit def astToConditional(a: AST): Conditional[AST] = One(a)

  def testParseSimple(): Unit = {
    //"(3+5)*(4+2+1)"
    val input = List(t("("), t("1"), t("+"), t("5"), t(")"), t("*"), t("("), t("4"), t("+"), t("2"), t("+"), t("1"), t(")"))
    val expected = Mul(Plus(Lit(1), Lit(5)), Plus(Lit(4), Plus(Lit(2), Lit(1))))
    assertParseResult(expected, parser.parse(input))
  }

  def testMultiParseSimple(): Unit = {
    val input = List(t("1"), t("+"), t("5"))
    val expected = Plus(Lit(1), Lit(5))
    assertParseResult(expected, parser.parse(input))
  }

  def testMultiParseSimpleMinus(): Unit = {
    val input = List(t("1"), t("-"), t("5"))
    val expected = Minus(Lit(1), Lit(5))
    assertParseResult(expected, parser.parse(input))
  }

  def testMultiParseSimplePlusMinus(): Unit = {
    val input = List(t("1"), t("+"), t("-"), t("5"))
    val result = parser.parse(input)
    result match {
      case parser.Success(_, unparsed) =>
        if (unparsed.atEnd)
          fail("expected parse error did not occur")
      case _ =>
    }
  }

  def testMultiParseAlternative(): Unit = {
    val input = List(t("1", f2), t("2", f2.not()), t("+"), t("5"))
    val expected = Plus(Choice(f2, Lit(1), Lit(2)), Lit(5))
    assertParseResult(expected, parser.parse(input))
  }

  def testMultiParseAlternativePlusMinusB(): Unit = {
    val input = List(t("1"), t("+", f1), t("-", f1.not()), t("4", f2), t("5", f2.not()))
    val expected = Choice(f1, Plus(Lit(1), Choice(f2, Lit(4), Lit(5))), Minus(Lit(1), Choice(f2, Lit(4), Lit(5))))
    assertParseResult(expected, parser.parse(input))
  }

  def testMultiParseAlternativePlusMinus(): Unit = {
    val input = List(t("1", f2), t("2", f2.not()), t("+", f1), t("-", f1.not()), t("5"))
    val expected = Choice(f1, Plus(Choice(f2, Lit(1), Lit(2)), Lit(5)), Minus(Choice(f2, Lit(1), Lit(2)), Lit(5)))
    assertParseResult(expected, parser.parse(input))
  }

  def testMultiParseAlternativeTwoPlus(): Unit = {
    val input = List(t("1", f2), t("2", f2.not()), t("+", f1), t("+", f1.not()), t("5"))
    val expected = Plus(Choice(f2, Lit(1), Lit(2)), Lit(5))
    assertParseResult(expected, parser.parse(input))
  }

  def testMultiParseAlternativeOverBrackets(): Unit = {
    //IFDEF (3+5 ELSE (3 ENDIF ) *(IFDEF 4 ELSE 1 ENDIF +2+1)
    val input = List(t("(", f1), t("3", f1), t("+", f1), t("5", f1),
      t("(", f1.not()), t("2", f1.not()),
      t(")"), t("*"), t("("),
      t("4", f2), t("1", f2.not()), t("+"), t("1"), t("+"), t("1"), t(")"))
    val expected = Mul(Choice(f1, Plus(Lit(3), Lit(5)), Lit(2)), Plus(Choice(f2, Lit(4), Lit(1)), Plus(Lit(1), Lit(1))))
    assertParseResult(expected, parser.parse(input))
  }

  def testDesignInterface(): Unit = {
    //(IFDEF 3+5) ELSE 3) ENDIF  *(IFDEF 4 ELSE 1 ENDIF +2+1)
    val input = List(t("(", f1), t("3", f1), t("+", f1), t("5", f1),
      t("(", f1.not()), t("3", f1.not()),
      t(")"), t("*"), t("("),
      t("4", f2), t("1", f2.not()), t("+"), t("2"), t("+"), t("1"), t(")"))

    val expected = Mul(Choice(f1, Plus(Lit(3), Lit(5)), Lit(3)), Plus(Choice(f2, Lit(4), Lit(1)), Plus(Lit(2), Lit(1))))
    assertParseResult(expected, parser.parse(input))
  }

  def testOptionalEnd(): Unit = {
    {
      val input = List(t("("), t("1"), t("+", f2), t("5", f2), t(")"))
      val expected = Choice(f2, Plus(Lit(1), Lit(5)), Lit(1))
      assertParseResult(expected, parser.parse(input))
    }
    {
      val input = List(t("1"), t("+", f2), t("5", f2))
      val expected = Choice(f2, Plus(Lit(1), Lit(5)), Lit(1))
      assertParseResult(expected, parser.parse(input))
    }
    {
      val input = List(t("1"), t("+", f2.not()), t("5", f2.not()))
      val expected = Choice(f2.not(), Plus(Lit(1), Lit(5)), Lit(1))
      assertParseResult(expected, parser.parse(input))
    }
  }

  /**
   * test multi-parser sequenzation
   */
  def testMultiParserSeq(): Unit = {
    val in = new TokenReader[MyToken, Any](List(t("1", f1), t("2", f1.not()), t("1", f2), t("2", f2.not())), 0, null, EofToken)
    val in2 = new TokenReader[MyToken, Any](List(t("1", f1), t("2", f1.not()), t("1", f1.not()), t("2", f1)), 0, null, EofToken)
    val p = parser
    println((p.digits ~ p.digits) (in, FeatureExprFactory.True)) // 1~1,1~2,2~1,2~2
    println((p.digits ~ p.digits) (in2, FeatureExprFactory.True)) //1~2,2~1

  }

  def testFailureVsError(): Unit = {
    //commit result after * but not after +. hence expecting better errors in the * case
    {
      val input = List(t("1"), t("+"), t("*"), t("5"))
      val result = parser.parse(input)
      println(result)
      result match {
        case parser.NoSuccess(_, _, _) => fail("should succeed but with unparsed tokens")
        case parser.Success(_, rest) => assertFalse("expected unparsed tokens, but reached end", rest.atEnd)
        case _ =>
      }
    }
    {
      val input = List(t("1"), t("*"), t("+"), t("5"))
      val result = parser.parse(input)
      println(result)
      result match {
        case parser.Success(_, _) => fail("expected error due to commit (!) after *")
        case _ =>
      }
    }
  }

  def testLookaheadWithNoBacktracking(): Unit = {
    //after ( is found no backtracking should occur
    {
      val input = List(t("1"), t("+"), t("("), t("5"))
      val result = parser.parse(input)
      println(result)
      result match {
        case parser.Success(_, _) => fail("expected error due to lookahead")
        case _ =>
      }
    }
  }

}
