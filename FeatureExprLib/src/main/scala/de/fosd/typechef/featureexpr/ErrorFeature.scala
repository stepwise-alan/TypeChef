package de.fosd.typechef.featureexpr

import scala.annotation.unused


/**
 * Created with IntelliJ IDEA.
 * User: kaestner
 * Date: 17.04.12
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */

class ErrorFeature(msg: String, f: FeatureExpr) extends FeatureExpr {
  def isSatisfiable(fm: FeatureModel): Boolean = error

  def getSatisfiableAssignment(featureModel: FeatureModel, interestingFeatures: Set[SingleFeatureExpr], preferDisabledFeatures: Boolean): Option[(List[SingleFeatureExpr], List[SingleFeatureExpr])] = error

  protected def calcSize: Int = error

  def collectDistinctFeatures: Set[String] = error

  def collectDistinctFeatures2: Nothing = error

  def collectDistinctFeatureObjects: Set[SingleFeatureExpr] = error

  def or(that: FeatureExpr): FeatureExpr = error

  def and(that: FeatureExpr): FeatureExpr = error

  def not(): FeatureExpr = error

  def simplify(that: FeatureExpr): FeatureExpr = error

  def unique(x: SingleFeatureExpr): FeatureExpr = error

  override def evaluate(selectedFeatures: Set[String]) = false

  private def error: Nothing = throw new FeatureArithmeticException(msg)

  override def toTextExpr: String = error

  //    override def mapDefinedExpr(f: DefinedExpr => FeatureExpr, cache: Map[FeatureExpr, FeatureExpr]) = error
  override def debug_print(x: Int): String = error

  def getConfIfSimpleAndExpr: Option[(Set[SingleFeatureExpr], Set[SingleFeatureExpr])] = error

  def getConfIfSimpleOrExpr: Option[(Set[SingleFeatureExpr], Set[SingleFeatureExpr])] = error

  @unused
  private def writeReplace(): Object = new FeatureExprSerializationProxy(this.toTextExpr)
}
