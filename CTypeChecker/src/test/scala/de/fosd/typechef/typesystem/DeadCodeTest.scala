package de.fosd.typechef.typesystem

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr.FeatureExprFactory._
import de.fosd.typechef.parser.c._
import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DeadCodeTest extends AnyFunSuite with CTypeSystem with Matchers with TestHelper {


  def e(s: String): Expr = {
    val r = parseExpr(s)
    //        println(r)
    r
  }

  def evalExpr(s: String): Conditional[VValue] = evalExpr(One(e(s.replace("[[", "\n#ifdef A\n").replace("][", "\n#else\n").replace("]]", "\n#endif\n"))), True, EmptyEnv)

  test("get expression bounds") {
    analyzeExprBounds(One(Constant("0")), True, EmptyEnv) should be((True, False))
    analyzeExprBounds(One(Constant("1")), True, EmptyEnv) should be((False, True))
    analyzeExprBounds(One(e("1+0")), True, EmptyEnv) should be((False, True))
  }
  test("eval expression") {
    evalExpr("1") should be(One(VInt(1)))
    evalExpr("0") should be(One(VInt(0)))
    evalExpr("i") should be(One(VUnknown()))
    evalExpr("1+2") should be(One(VInt(3)))
    evalExpr("1+[[1][0]]") should be(Choice(fa.not(), One(VInt(1)), One(VInt(2))))
    //        evalExpr("1[[+1]") should be(Choice(fa.not(), One(VInt(1)), One(VInt(2))))
    evalExpr("i || 1") should be(One(VInt(1)))
    evalExpr("0 && i") should be(One(VInt(0)))
    evalExpr("!0") should be(One(VInt(1)))
  }


}