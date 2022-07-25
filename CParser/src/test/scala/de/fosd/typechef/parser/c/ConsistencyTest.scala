package de.fosd.typechef.parser.c

import de.fosd.typechef.conditional.Opt
import de.fosd.typechef.featureexpr._
import org.junit.Assert._
import org.junit.{Assert, Test}

import java.util
import java.util.Collections

class ConsistencyTest extends TestHelper {
  def parseFile(fileName: String, featureModel: FeatureModel): Unit = {
    val inputStream = getClass.getResourceAsStream("/" + fileName)
    assertNotNull("file not found " + fileName, inputStream)
    val p = new CParser(featureModel)
    val result = p.translationUnit(
      lexStream(inputStream, fileName, Collections.singletonList("testfiles/boa/"), featureModel), FeatureExprFactory.True)

    println("parsing done.")

    (result: @unchecked) match {
      case p.Success(ast, _) =>
        checkASTAssumptions(ast.asInstanceOf[TranslationUnit], featureModel)

      //success
      case p.NoSuccess(msg, unparsed, inner) =>
        println(unparsed.context)
        Assert.fail(msg + " at " + unparsed + " " + inner)
    }

  }

  def checkASTAssumptions(ast: TranslationUnit, featureModel: FeatureModel): Unit = {
    val knownExternals = new util.IdentityHashMap[ExternalDef, FeatureExpr]()

    for (Opt(f, ext) <- ast.defs) {

      assert(f.isSatisfiable(featureModel), "unsatisfiable code in AST: " + ext.getPositionFrom.getLine + " for " + ext)

      if (f.isSatisfiable(featureModel))
        if (!knownExternals.containsKey(ext)) {
          knownExternals.put(ext, f)
        } else {
          val priorFexpr = knownExternals.get(ext)

          assert((f mex priorFexpr).isTautology(featureModel), "!" + priorFexpr + " mex " + f + " in " + ext.getPositionFrom.getLine + " for " + ext)

          knownExternals.put(ext, f or priorFexpr)
        }
    }


  }


  @Test
  def testRz1000(): Unit = {
    val oldDefault = FeatureExprFactory.dflt
    FeatureExprFactory.setDefault(FeatureExprFactory.bdd)
    try {
      //had serious problems with this file during type checking
      val fmStream = getClass.getResourceAsStream("/other/approx.fm")
      val f: FeatureExpr = new FeatureExprParser(FeatureExprFactory.dflt).parseFile(fmStream)
      //        val f: FeatureExpr = new FeatureExprParser(FeatureExprFactory.dflt).parseFile("other/approx.fm")
      val fm = FeatureExprFactory.dflt.featureModelFactory.create(f and FeatureExprFactory.createDefinedExternal("CONFIG_BLK_DEV_RZ1000") and FeatureExprFactory.createDefinedExternal("CONFIG_IDE"))
      parseFile("other/rz1000.pi", fm)
    } finally {
      FeatureExprFactory.setDefault(oldDefault)
    }
  }

}