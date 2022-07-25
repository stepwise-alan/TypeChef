package de.fosd.typechef.parser.test.parsers

import de.fosd.typechef.conditional._
import de.fosd.typechef.parser._


class CharDigitParser extends MultiFeatureParser {
  type Elem = MyToken
  type TypeContext = Any

  def symb: MultiParser[AST] = digit | char

  def twosymb: MultiParser[AST ~ AST] = symb ~ symb

  def ab: MultiParser[AST ~ AST] = (symb ~ char) | (symb ~ digit)

  def parenDigit: MultiParser[MyToken ~ Lit ~ MyToken] = t("(") ~ digit ~ t(")")

  def parenAb: MultiParser[MyToken ~ (AST ~ AST) ~ MyToken] = t("(") ~ ab ~ t(")")

  def digits: MultiParser[List[Opt[AST]]] = repOpt(digit)

  def t(text: String): MultiParser[MyToken] = token(text, x => x.t() == text)

  def comma: MultiParser[MyToken] = t(",")

  def digit: MultiParser[Lit] =
    token("digit", x => x.t() == "0" | x.t() == "1" | x.t() == "2" | x.t() == "3" | x.t() == "4" | x.t() == "5" | x.t() == "6" | x.t() == "7" | x.t() == "8" | x.t() == "9") ^^ {
      (x: Elem) => Lit(x.text.toInt)
    }

  def number: MultiParser[Lit] =
    token("number", s =>
      try {
        s.text.toInt
        true
      } catch {
        case _: java.lang.NumberFormatException => false
      }) ^^ {
      (x: Elem) => Lit(x.text.toInt)
    }

  def char: MultiParser[AST] =
    token("char", x => x.t() == "a" | x.t() == "b" | x.t() == "c" | x.t() == "d" | x.t() == "e") ^^ {
      (x: Elem) => Char(x.text)
    }

  def expr: MultiParser[Conditional[AST]] = (expr1 ~ opt(t("*") ~> expr) ^^! {
    case ~(f, Some(e)) => One(Mul(f, e))
    case ~(f, None) => f
  }).map(ConditionalLib.combine)

  def expr1: MultiParser[Conditional[AST]] = (expr2 ~ opt(t("+") ~> expr) ^^! {
    case ~(f, Some(e)) => One(Plus(f, e))
    case ~(f, None) => f
  }).map(ConditionalLib.combine)

  def expr2: MultiParser[Conditional[AST]] = t("(") ~> expr <~ t(")") | digit.join


  def tr(l: List[Elem]): Input = new TokenReader[Elem, TypeContext](l, 0, null, EofToken)
}