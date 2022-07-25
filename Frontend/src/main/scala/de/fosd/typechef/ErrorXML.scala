package de.fosd.typechef

import de.fosd.typechef.error.{Position, TypeChefError}
import de.fosd.typechef.featureexpr.FeatureExpr

import java.io.File
import scala.xml._

/**
 * infrastructure to render parser and type system errors (and possibly other
 * errors in the future) in an XML files. controlled by command line parameters
 *
 */

class ErrorXML(errorFile: File) {

  var errors: List[Node] = Nil


  private def renderPosition(position: Position) = <position>
    <file>
      {position.getFile}
    </file>
    <line>
      {position.getLine}
    </line>
    <col>
      {position.getColumn}
    </col>
  </position>

  def renderParserError(feature: FeatureExpr, msg: String, pos: Position): Object = {
    if (errorFile != null)
      errors = <parsererror>
        <featurestr>
          {feature.toString}
        </featurestr> <msg>
          {msg}
        </msg>{renderPosition(pos)}
      </parsererror> :: errors
    null; //Object instead of Unit because going into Java code
  }

  def renderTypeError(typeError: TypeChefError): Unit = {
    if (errorFile != null)
      errors = <typeerror>
        <featurestr>
          {typeError.condition.toString}
        </featurestr> <severity>
          {typeError.severity}
        </severity> <severityextra>
          {typeError.severityExtra}
        </severityextra> <msg>
          {typeError.msg}
        </msg>{renderPosition(typeError.where.getPositionFrom)}{renderPosition(typeError.where.getPositionTo)}
      </typeerror> :: errors
  }

  def write(): Unit = {
    if (errorFile != null)
    /*if (errorFile.exists() && errors.isEmpty)
        errorFile.delete();
    else*/ {
      val output = <errors>
        {errors}
      </errors>
      XML.save(errorFile.getPath, output)
    }

  }


}
