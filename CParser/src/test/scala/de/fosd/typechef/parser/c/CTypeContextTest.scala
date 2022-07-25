package de.fosd.typechef.parser.c

import de.fosd.typechef.featureexpr.FeatureExprFactory._
import de.fosd.typechef.featureexpr.SingleFeatureExpr
import org.junit.Test

class CTypeContextTest {

  val fa: SingleFeatureExpr = createDefinedExternal("fa")
  val fb: SingleFeatureExpr = createDefinedExternal("fb")

  @Test
  def testContext(): Unit = {
    var c = CTypeContext(Map())
    c = c.addType("a", True)

    println(c)
    assert(c.knowsType("a", True))
    assert(c.knowsType("a", fa))

    c = c.addType("b", fb)

    println(c)
    assert(c.knowsType("b", fb))
    //        assert(!c.knowsType("b", True))

    c = c.addType("b", fb.not())
    println(c)
    assert(c.knowsType("b", True))

    var d = CTypeContext(Map())
    d = d.addType("c", fa)
    d = d.addType("a", True)
    c = c.addType("c", fb)

    val j = c join d
    println(j)
    assert(j.knowsType("c", fa or fb))
    assert(j.knowsType("b", True))
    assert(j.knowsType("a", True))

  }


}