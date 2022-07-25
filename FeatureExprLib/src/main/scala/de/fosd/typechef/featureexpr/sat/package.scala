package de.fosd.typechef.featureexpr

import scala.ref.WeakReference

package object sat {
  class NotReference[+T <: AnyRef](x: T) extends WeakReference(x) {}

  val NotRef: WeakRef.type = WeakRef
}

