package de.fosd.typechef.featureexpr

import java.io.Writer

trait DefaultPrint extends FeatureExpr {
  override def print(p: Writer): Unit = p.write(toTextExpr)

}
