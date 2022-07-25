package de.fosd.typechef.featureexpr

// this class represents the configuration of a product
// and config holds all defined features
class Configuration(val config: FeatureExpr, fm: FeatureModel = FeatureExprFactory.default.featureModelFactory.empty) {
  val sfm: FeatureModel = fm and config

  def valid(fexp: FeatureExpr): Boolean = fexp.isSatisfiable(sfm)
}

object EmptyConfiguration extends Configuration(FeatureExprFactory.True, FeatureExprFactory.default.featureModelFactory.empty)