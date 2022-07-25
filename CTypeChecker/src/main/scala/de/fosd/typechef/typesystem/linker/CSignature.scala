package de.fosd.typechef.typesystem.linker

import de.fosd.typechef.error.Position
import de.fosd.typechef.featureexpr.FeatureExpr
import de.fosd.typechef.typesystem.CType


/**
 * signature with name type and condition. the position is only stored for debugging purposes and has no further
 * relevance.
 * its also not necessarily de/serialized
 *
 * extraflags can refer to special features for signatures, such as weak exports; see CFlags.scala
 *
 * TODO types should be selfcontained (i.e. not reference to structures or type names defined elsewhere,
 * but resolved to anonymous structs, etc.)
 */
case class CSignature(name: String, ctype: CType, fexpr: FeatureExpr, pos: Seq[Position], extraFlags: Set[CFlag] = Set()) {
  override def toString: String =
    name + ": " + ctype.toText + " " + extraFlags.mkString("+") + "\t\tif " + fexpr + "\t\tat " + pos.mkString(", ")

  override def hashCode: Int = name.hashCode

  override def equals(that: Any): Boolean = that match {
    case CSignature(thatName, thatCType, thatFexpr, thatPos, thatExtraFlags) => name == thatName && CType.isLinkCompatible(ctype, thatCType) && fexpr.equivalentTo(thatFexpr) && pos == thatPos && extraFlags == thatExtraFlags
    case _ => false
  }

  def and(f: FeatureExpr): CSignature = CSignature(name, ctype, fexpr and f, pos, extraFlags)


}

