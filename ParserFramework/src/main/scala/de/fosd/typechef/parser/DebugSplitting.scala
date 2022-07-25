package de.fosd.typechef.parser

object DebugSplitting {
  val DEBUG_SPLITTING = false

  def apply(msg: String): Unit = if (DEBUG_SPLITTING) println(msg)
}