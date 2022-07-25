package de.fosd.typechef.typesystem

import de.fosd.typechef.error.TypeChefError
import de.fosd.typechef.featureexpr.{FeatureExpr, FeatureExprFactory}
import de.fosd.typechef.parser.c.{TestHelper, TranslationUnit}


trait TestHelperTS extends TestHelper {


  protected def check(code: String, printAST: Boolean = false): Boolean = _check(code, printAST).isEmpty

  protected def _check(code: String, printAST: Boolean = false): List[TypeChefError] = {
    //        println("checking " + code);
    if (printAST)
      println("AST: " + getAST(code))
    _check(getAST(code))
  }

  protected def check(ast: TranslationUnit): Boolean = _check(ast).isEmpty

  protected def _check(ast: TranslationUnit): List[TypeChefError] = {
    assert(ast != null, "void ast")
    new CTypeSystemFrontend(ast).makeSilent().checkAST()
  }

  private def checkExpr(code: String, printAST: Boolean = false): Boolean = _checkExpr(code, printAST).isEmpty

  private def _checkExpr(code: String, printAST: Boolean = false): List[TypeChefError] =
    _check("void main() { " + code + "}", printAST)


  def correct(code: String): Unit = {
    val r = _check(code)
    assert(r.forall(_.isWarning), "False positive (expected correct code, but found error): \n" + r.mkString("\n"))
    assert(!r.exists(_.isWarning), "False positive warning (expected correct code, but found warning): \n" + r.mkString("\n"))
  }

  def error(code: String): Unit = {
    val r = _check(code)
    assert(r.exists(!_.isWarning), "False negative (expected error, but found none)")
  }

  def errorIf(code: String, expectedErrorCondition: FeatureExpr): Unit = {
    val r = _check(code)
    val foundErrorCondition = r.filter(!_.isWarning).foldRight(FeatureExprFactory.False)(_.condition or _)
    assert(foundErrorCondition equivalentTo expectedErrorCondition, s"Expected error under condition $expectedErrorCondition, but found error under condition $foundErrorCondition")
  }

  def warning(code: String): Unit = {
    val r = _check(code)
    assert(r.forall(_.isWarning), "False positive (expected warning, but found error): \n" + r.mkString("\n"))
    assert(r.nonEmpty, "Missing warning (expected warning, but found neither error nor warning)")
  }

  def correctExpr(code: String): Unit = {
    assert(checkExpr(code), "False positive (expected correct code, but found error)")
  }

  def errorExpr(code: String): Unit = {
    assert(checkExpr(code), "False negative (expected error, but found none)")
  }
}


trait TestHelperTSConditional extends TestHelper {

  private def checkExpr(code: String, enableAnalysis: Boolean, printAST: Boolean = false): Boolean =
    check("void main() { " + code + "}", enableAnalysis, printAST)

  private def check(code: String, enableAnalysis: Boolean, printAST: Boolean = false): Boolean = {
    println("checking " + code)
    if (printAST)
      println("AST: " + getAST(code))
    check(getAST(code), enableAnalysis)
  }

  protected def check(ast: TranslationUnit, enableAnalysis: Boolean): Boolean

  def correct(code: String): Unit = {
    assert(check(code, enableAnalysis = false), "Expected correct code, but found error without analysis")
    assert(check(code, enableAnalysis = true), "Expected correct code, but found error with analysis")
  }

  def error(code: String): Unit = {
    assert(check(code, enableAnalysis = false), "Expected correct code (without analysis), but found error without analysis")
    assert(!check(code, enableAnalysis = true), "Expected error (with analysis), but found no error with analysis")
  }

  def correctExpr(code: String): Unit = {
    assert(checkExpr(code, enableAnalysis = false), "Expected correct code, but found error without analysis")
    assert(checkExpr(code, enableAnalysis = true), "Expected correct code, but found error with analysis")
  }

  def errorExpr(code: String): Unit = {
    assert(checkExpr(code, enableAnalysis = false), "Expected correct code (without analysis), but found error without analysis")
    assert(!checkExpr(code, enableAnalysis = true), "Expected error (with analysis), but analysis did not find an error")
  }

}