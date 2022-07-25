package de.fosd.typechef.parser.test

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr._
import de.fosd.typechef.parser.test.parsers._

trait DigitListUtilities {
  val f1: SingleFeatureExpr = FeatureExprFactory.createDefinedExternal("a")
  val f2: SingleFeatureExpr = FeatureExprFactory.createDefinedExternal("b")
  val l1: Lit = Lit(1)
  val l2: Lit = Lit(2)
  val l3: Lit = Lit(3)
  val True: FeatureExpr = FeatureExprFactory.True

  def t(text: String): MyToken = t(text, FeatureExprFactory.True)

  def t(text: String, feature: FeatureExpr): MyToken = new MyToken(text, feature)

  def outer(x: AST): DigitList2 = DigitList2(List(o(x)))

  def outer(x: Conditional[AST]): DigitList2 = DigitList2(List(Opt(FeatureExprFactory.True, x)))

  def wrapList(x: AST*): DigitList2 = DigitList2(List() ++ x.map(One(_)).map(Opt(FeatureExprFactory.True, _)))

  def wrapList(x: List[AST]): DigitList2 = wrapList(x: _*)


  def o(ast: AST): Opt[One[AST]] = Opt(FeatureExprFactory.True, One(ast))
}