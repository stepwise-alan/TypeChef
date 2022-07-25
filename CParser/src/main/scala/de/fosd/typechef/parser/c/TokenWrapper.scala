package de.fosd.typechef.parser.c

import de.fosd.typechef.LexerToken
import de.fosd.typechef.error.Position
import de.fosd.typechef.featureexpr._
import de.fosd.typechef.lexer._
import de.fosd.typechef.parser._


/**
 * thin wrapper around jccp tokens to make them accessible to MultiFeatureParser
 *
 * @author kaestner
 *
 */
class CToken(token: LexerToken, number: Int) extends ProfilingToken with AbstractToken {

  def getFeature: FeatureExpr = token.getFeature

  def isInteger: Boolean = token.isNumberLiteral

  def isKeywordOrIdentifier: Boolean = token.isKeywordOrIdentifier

  def getText: String = token.getText

  def isString: Boolean = token.isStringLiteral

  def isCharacter: Boolean = token.isCharacterLiteral

  override def toString: String = "\"" + token.getText + "\"" + (if (!getFeature.isTautology) getFeature else "")

  private lazy val pos = new TokenPosition(
    if (token.getSourceName == null) null else token.getSourceName,
    token.getLine,
    token.getColumn,
    number
  )

  def getPosition: Position = pos
}

class TokenPosition(file: String, line: Int, column: Int, tokenNr: Int) extends Position {
  def getFile: String = file

  def getLine: Int = line

  def getColumn: Int = column

  //    override def toString = "token no. " + tokenNr + " (line: " + getLine + ")"
}


object CToken {

  /**
   * Factory method for the creation of TokenWrappers.
   */
  def apply(token: LexerToken, number: Int): CToken = {
    new CToken(token, number)
  }

  val EOF: CToken = new CToken(new EOFToken(), -1) {
    override def getFeature: FeatureExpr = FeatureExprFactory.False
  }
}