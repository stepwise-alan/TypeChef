package de.fosd.typechef.parser.test.parsers

import de.fosd.typechef.error.Position
import de.fosd.typechef.featureexpr.{FeatureExpr, FeatureExprFactory}
import de.fosd.typechef.parser._

class MyToken(val text: String, val feature: FeatureExpr) extends ProfilingToken {
  def t(): String = text

  def getText: String = text

  def getFeature: FeatureExpr = feature

  def getPosition: Position = new Position {
    def getFile = "stream"

    def getLine = 1

    def getColumn = 1
  }

  override def toString: String = "\"" + text + "\"" + (if (!feature.isTautology) feature else "")

  def isInteger: Boolean = false

  def isIdentifier: Boolean = false

  def isString: Boolean = false

  def isCharacter: Boolean = false
}

object EofToken extends MyToken("EOF", FeatureExprFactory.True)
