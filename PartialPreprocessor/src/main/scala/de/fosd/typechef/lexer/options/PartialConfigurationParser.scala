package de.fosd.typechef.lexer.options

import de.fosd.typechef.featureexpr.FeatureExprFactory._

import scala.io.Source
import scala.util.Using

object PartialConfigurationParser {
  def load(file: String): PartialConfiguration = {
    val DEF = "#define"
    val UNDEF = "#undef"

    val directives = Using(Source.fromFile(file))(_.getLines().filter(_.startsWith("#")).toList).get

    def findMacroName(directive: String) = directive.split(' ')(1)

    val booleanDefs = directives.filter(_.startsWith(DEF)).map(findMacroName)
    val undefs = directives.filter(_.startsWith(UNDEF)).map(findMacroName)

    val featureExpr =
      (booleanDefs.map(createDefinedExternal) ++
        undefs.map(createDefinedExternal(_).not())).
        foldRight(True)(_ and _)

    new PartialConfiguration(booleanDefs.toArray, undefs.toArray, featureExpr)
  }
}

