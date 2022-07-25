package de.fosd.typechef.parser

import de.fosd.typechef.featureexpr.{FeatureExpr, FeatureModel}

import scala.collection.mutable

class FeatureSolverCache(featureModel: FeatureModel) {
  var i_hits, i_query, m_hits, m_query = 0

  private val impliesCache: mutable.WeakHashMap[FeatureExpr, mutable.WeakHashMap[FeatureExpr, Boolean]] = new mutable.WeakHashMap()
  private val mutuallyExclusiveCache: mutable.WeakHashMap[FeatureExpr, mutable.WeakHashMap[FeatureExpr, Boolean]] = new mutable.WeakHashMap()

  val LOGGING = false

  /**
   * cheap if a in CNF and b in DNF
   */
  def implies(a: FeatureExpr, b: FeatureExpr): Boolean = {
    i_query += 1
    getOrElseUpdate(impliesCache, false, a, b, {
      i_hits += 1
      if (LOGGING) println(a.toString + " => " + b.toString)

      /**
       * taut(a=>b) == contr(a && !b)
       * we use the latter one here to avoid accidental
       * negation of a, which is repeatedly used and
       * probably already available in CNF
       */
      a.and(b.not()).isContradiction(featureModel)
    })
  }

  /**
   * cheap if a and b are in CNF
   */
  def mutuallyExclusive(a: FeatureExpr, b: FeatureExpr): Boolean = {
    m_query += 1
    getOrElseUpdate(mutuallyExclusiveCache, true, a, b, {
      m_hits += 1
      if (LOGGING) println(a.toString + " x " + b.toString)
      a.and(b).isContradiction(featureModel)
    })
  }

  def getOrElseUpdate(cache: mutable.WeakHashMap[FeatureExpr, mutable.WeakHashMap[FeatureExpr, Boolean]], isCommutative: Boolean,
                      a: FeatureExpr, b: FeatureExpr, newValue: => Boolean): Boolean = {
    //find (a,b)
    val ca = cache.get(a)
    if (ca.isDefined) {
      val v = ca.get.get(b)
      if (v.isDefined)
        return v.get
    }
    //find (b,a)  if commutative
    if (isCommutative) {
      val cb = cache.get(b)
      if (cb.isDefined) {
        val v = cb.get.get(a)
        if (v.isDefined)
          return v.get
      }
    }

    //add result to cache
    val result: Boolean = newValue
    cache.getOrElseUpdate(a, new mutable.WeakHashMap[FeatureExpr, Boolean]).update(b, result)
    result
  }

  def statistics: String = "implies " + i_hits + "/" + i_query + " (" + (1.0 - (1.0 * i_hits) / i_query) + "); mex " + m_hits + "/" + m_query + " (" + (1.0 - (1.0 * m_hits) / m_query) + ")"
}


