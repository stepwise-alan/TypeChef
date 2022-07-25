package de.fosd.typechef.error

import de.fosd.typechef.error

/**
 * helper stuff
 */
object Severity extends Enumeration {
  type Severity = Value
  //Type-System crashes (e.g. unimplemented parts)
  val Crash: error.Severity.Value = Value("Critical")

  // severe errors during lookup of id
  val IdLookupError: error.Severity.Value = Value("Id-Lookup Error")

  // severe errors during lookup of fields
  val FieldLookupError: error.Severity.Value = Value("Field-Lookup Error")

  // severe errors during lookup of id
  val TypeLookupError: error.Severity.Value = Value("Type-Lookup Error")

  // severe errors during lookup of id
  val RedeclarationError: error.Severity.Value = Value("Redeclaration Error")

  // other severe type errors
  val OtherError: error.Severity.Value = Value("Error")

  val Warning: error.Severity.Value = Value("Warning")


  //results of static analysis; may contain large numbers of false positives
  val SecurityWarning: error.Severity.Value = Value("Security Warning")
}