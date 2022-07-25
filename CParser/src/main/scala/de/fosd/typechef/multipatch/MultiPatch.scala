package de.fosd.typechef.multipatch

import scala.annotation.unused


/**
 *
 *
 * deprecated
 *
 *
 */

abstract class Command(line: Int)

case class Delete(line: Int) extends Command(line)

case class Insert(line: Int, text: String) extends Command(line)

case class Patch(version: Int, lines: List[Command])

object Patch {
  def fromFile(@unused filename: String): Patch = {
    null
  }
}

case class MultiPatch(lines: List[(Int, Int, String)]) {
  def addPatch(patch: Patch): MultiPatch = {
    val result = List.newBuilder[(Int, Int, String)]
    var lineNumber = 0
    var deleted = false

    def processPatch(patch: Patch): Unit =
      for (thingy <- patch.lines) {
        thingy match {
          case Delete(line) if line == lineNumber =>
            deleted = true
          case Insert(line, text) if line == lineNumber =>
            result += ((patch.version, Int.MaxValue, text))
          case _ =>
        }
      }

    if (lines.isEmpty)
      processPatch(patch)
    else
      for (line <- lines) {
        deleted = false
        if (patch.version < line._2) {
          processPatch(patch)
          lineNumber += 1
        }
        result += ((line._1, if (deleted) patch.version else Int.MaxValue, line._3))
      }

    MultiPatch(result.result())
  }
}
