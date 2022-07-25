package de.fosd.typechef.parser.test.parsers

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr.FeatureExprFactory
import de.fosd.typechef.parser._

class MultiExpressionParser extends MultiFeatureParser {
  type Elem = MyToken
  type TypeContext = Any

  def parse(tokens: List[MyToken]): ParseResult[Conditional[AST]] = expr(new TokenReader[MyToken, TypeContext](tokens, 0, (), EofToken), FeatureExprFactory.True).expectOneResult

  def expr: MultiParser[Conditional[AST]] = {
    val r = term ~ opt((t("+") | t("-")) ~ expr) ^^! {
      case ~(f, Some(~(op, e))) if op.text == "+" => One(Plus(f, e))
      case ~(f, Some(~(op, e))) if op.text == "-" => One(Minus(f, e))
      case ~(f, None) => f
      case _ => throw new Exception("unsupported match")
    }
    r.map(ConditionalLib.combine)
  }


  def term: MultiParser[Conditional[AST]] =
    (fact ~ ((t("*") ~! expr) ?) ^^! {
      case ~(f, Some(~(_, e))) => One(Mul(f, e))
      case ~(f, None) => f
    }).map(ConditionalLib.combine)

  def fact: MultiParser[Conditional[AST]] =
    (digits ^^! {
      t => Lit(t.text.toInt)
    }
      | ((lookahead(t("(")) ~! (t("(") ~ expr ~ t(")"))) ^^! {
      case _ ~ (_ ~ e ~ _) => e
    }).map(ConditionalLib.combine)
      | failc("digit or '(' expected"))


  def t(text: String): MultiParser[MyToken] = token(text, x => x.t() == text)

  def digits: MultiParser[MyToken] = token("digit", x => x.t() == "1" | x.t() == "2" | x.t() == "3" | x.t() == "4" | x.t() == "5")

}