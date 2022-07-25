package de.fosd.typechef.crewrite

import de.fosd.typechef.featureexpr.{FeatureExprFactory, FeatureModel}
import de.fosd.typechef.parser.c._
import de.fosd.typechef.typesystem.{CDeclUse, CTypeSystemFrontend, UseDeclMap}

object CheckDataflow extends IntraCFG with CFGHelper {

  def checkDataflow(tunit: TranslationUnit, fm: FeatureModel = FeatureExprFactory.default.featureModelFactory.empty): Unit = {
    val fdefs = filterAllASTElems[FunctionDef](tunit)
    val ts = new CTypeSystemFrontend(tunit, fm) with CDeclUse
    val udm = ts.getUseDeclMap
    fdefs.foreach(intraDataflowAnalysis(_, fm, udm))
  }

  private def intraDataflowAnalysis(f: FunctionDef, fm: FeatureModel, udm: UseDeclMap): Unit = {
    if (f.stmt.innerStatements.isEmpty) return

    val env = CASTEnv.createASTEnv(f)

    val ss = getAllSucc(f.stmt.innerStatements.head.entry, env)
    val lv = new Liveness(env, udm, fm)

    val nss = ss.map(_._1).filterNot(x => x.isInstanceOf[FunctionDef])
    for (s <- nss) lv.in(s)
  }

}
