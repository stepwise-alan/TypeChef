package de.fosd.typechef.featureexpr

import org.sat4j.specs.{IVec, IVecInt}

import scala.annotation.unused


trait SATBasedFeatureModel {
  @unused
  val variables: Map[String, Int]
  @unused
  val clauses: IVec[IVecInt]
  @unused
  val lastVarId: Int
}
