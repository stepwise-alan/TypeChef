package de.fosd.typechef.parser.test

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr.FeatureExprFactory
import de.fosd.typechef.parser.test.parsers._
import junit.framework.TestCase
import org.junit._

class RepOptTest extends TestCase with DigitListUtilities {

  import de.fosd.typechef.parser._

  case class DList(list: List[Opt[Conditional[AST]]]) extends AST {
    override def toString: String = list.map(o => o.entry.toString + " - " + o.condition).mkString("[", "\n", "]")
  }

  case class AList(list: List[AST]) extends AST

  class DigitList2Parser extends MultiFeatureParser {
    type Elem = MyToken
    type TypeContext = Any

    def parse(tokens: List[MyToken]): ParseResult[AST] = digits(new TokenReader[MyToken, TypeContext](tokens, 0, (), EofToken), FeatureExprFactory.True).expectOneResult

    def digitList: MultiParser[Conditional[AST]] =
      (t("(") ~! (digits ~ t(")"))) ^^! {
        case _ ~ (e ~ _) => e
      }

    def digits: MultiParser[AST] = repOpt(digitList | digit.map(One(_))) ^^ {
      DList
    }

    def t(text: String): MultiParser[MyToken] = token(text, x => x.t() == text)

    def digit: MultiParser[AST] =
      token("digit", x => x.t() == "1" | x.t() == "2" | x.t() == "3" | x.t() == "4" | x.t() == "5") ^^ {
        t => Lit(t.text.toInt)
      }

  }

  val parser = new DigitList2Parser()

  @Test
  def testList1(): Unit = {
    val input3 = List(t("5"), t("1", f1), t("2"), t("3"))
    println(parser.parse(input3))
    assert(input3.map(_.profile_consumed_replicated()).sum == 0)

    val input = List(t("5"), t("1"), t("2"), t("3"))
    println(parser.parse(input))
    assert(input.map(_.profile_consumed_replicated()).sum == 0)


    val input2 = List(t("5"), t("1", f2), t("2", f1), t("3", f2))
    println(parser.parse(input2))
    assert(input2.map(_.profile_consumed_replicated()).sum == 0)

    val input4 = List(t("5"), t("1", f2), t("2", f1), t("3", f1))
    println(parser.parse(input4))
    assert(input4.map(_.profile_consumed_replicated()).sum == 0)

    val input5 = List(t("5", f1), t("1"), t("2"), t("3"))
    println(parser.parse(input5))
    assert(input5.map(_.profile_consumed_replicated()).sum == 0)
  }

}