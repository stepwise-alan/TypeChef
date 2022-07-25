/*
 * TypeChef Variability-Aware Lexer.
 * Copyright 2010-2011, Christian Kaestner, Paolo Giarrusso
 * Licensed under GPL 3.0
 *
 * built on top of
 *
 * Anarres C Preprocessor
 * Copyright (c) 2007-2008, Shevek
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package de.fosd.typechef.lexer

import de.fosd.typechef.featureexpr.{FeatureExpr, FeatureExprFactory, FeatureExprTree, FeatureModel}
import de.fosd.typechef.lexer.macrotable.MacroExpansion

import java.{lang => jLang, util => jUtil}
import scala.annotation.unused
import scala.collection.mutable
import scala.jdk.CollectionConverters._

/**
 * A macro argument.
 *
 * This encapsulates a raw and preprocessed token stream.
 */
object MacroArg {
  def omittedVariadicArgument: Argument = OmittedVariadicArgument

  def create(toks: jUtil.List[Token]): NormArgument = NormArgument(toks.asScala.toSeq)

  //Untested.
  def fromSources(sources: jLang.Iterable[de.fosd.typechef.lexer.Source]): NormArgument =
    NormArgument(sources.asScala.toSeq.flatMap(_.asScala))
}

object MacroExpander {
  //TODO: finish and test, only compiled.
  def expandAlternatives(pp: Preprocessor, macroName: String,
                         macroExpansions: Array[MacroExpansion[MacroData]], args: List[Argument],
                         origInvokeTok: Token, origArgTokens: List[Token], commonCondition: FeatureExpr, inline: Boolean,
                         featureModel: FeatureModel): FeatureExprTree[Seq[Source]] = {
    val alternativesExhaustive: Boolean = commonCondition.isTautology(featureModel)
    val fallbackAlternative =
      if (alternativesExhaustive)
        Seq[Source]()
      else //if (inline)
        Seq[Source]() //XXX: Should be the unexpanded code, or 0, depending on inline. Ask it to the caller!

    macroExpansions.map(expansion => FeatureExprFactory.default.createValue[Seq[Source]](
      pp.macro_expandAlternative(macroName, expansion, args.asJava, origInvokeTok, origArgTokens.asJava, inline).asScala.toSeq)).zip(
      macroExpansions.map(_.getFeature)).foldRight[FeatureExprTree[Seq[Source]]](FeatureExprFactory.default.createValue(fallbackAlternative)) {
      case ((expanded, feature), tree) => FeatureExprFactory.default.createIf(feature, expanded, tree)
    }
  }
}

sealed abstract class Argument(omitted: Boolean) {
  def isOmittedArg: Boolean = omitted

  def tokens: Seq[Token]

  def jTokens: jUtil.List[Token] = tokens.asJava

  def expandedTokens: Seq[Token]

  def expansion: jUtil.Iterator[Token] = expandedTokens.iterator.asJava

  private[lexer] def expand(p: Preprocessor, inlineCppExpression: Boolean, macroName: String): Unit = {}

  override def toString: String = {
    val buf: mutable.StringBuilder = new mutable.StringBuilder
    buf.append("Argument(")
    buf.append("raw=[ ")
    for (tok <- tokens)
      buf.append(tok.getText)
    buf.append(" ];expansion=[ ")
    if (expandedTokens.isEmpty) buf.append("null")
    else {
      for (tok <- expandedTokens)
        buf.append(tok.getText)
    }
    buf.append(" ])")
    buf.toString
  }
}

case object OmittedVariadicArgument extends Argument(true) {
  def expandedTokens: Seq[Token] = Seq()

  def tokens: Seq[Token] = Seq()
}

case class NormArgument(tokens: Seq[Token]) extends Argument(false) {
  private var expanded: Seq[Token] = Seq()

  @unused
  private var omittedArg: Boolean = false

  override private[lexer] def expand(p: Preprocessor, inlineCppExpression: Boolean, macroName: String): Unit = {
    if (expanded.isEmpty)
      this.expanded = p.macro_expandArgument(tokens.asJava, inlineCppExpression).asScala.toSeq
  }

  def expandedTokens: Seq[Token] = expanded
}
