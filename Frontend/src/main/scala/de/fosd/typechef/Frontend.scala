package de.fosd.typechef


import de.fosd.typechef.crewrite._
import de.fosd.typechef.options.{FrontendOptions, FrontendOptionsWithConfigFiles, OptionException}
import de.fosd.typechef.parser.TokenReader
import de.fosd.typechef.parser.c._
import de.fosd.typechef.typesystem._

import java.io._
import java.util.zip.{GZIPInputStream, GZIPOutputStream}
import scala.annotation.unused

object Frontend extends EnforceTreeHelper {


  def main(args: Array[String]): Unit = {
    // load options
    val opt = new FrontendOptionsWithConfigFiles()
    try {
      try {
        opt.parseOptions(args)
      } catch {
        case o: OptionException => if (!opt.isPrintVersion) throw o
      }

      if (opt.isPrintVersion) {
        println("TypeChef " + getVersion)
        return
      }
      if (opt.isPrintIncludes)
        opt.printInclude()
    }

    catch {
      case o: OptionException =>
        println("Invocation error: " + o.getMessage)
        println("use parameter --help for more information.")
        return
    }

    processFile(opt)
  }


  def getVersion: String = {
    var version = "development build"
    try {
      val cl = Class.forName("de.fosd.typechef.Version")
      version = "version " + cl.getDeclaredConstructor().newInstance().asInstanceOf[VersionInfo].getVersion
    } catch {
      case _: ClassNotFoundException =>
    }
    version
  }

  private class StopWatch {
    var lastStart: Long = 0
    var currentPeriod: String = "none"
    var currentPeriodId: Int = 0
    var times: Map[(Int, String), Long] = Map()

    private def genId(): Int = {
      currentPeriodId += 1
      currentPeriodId
    }

    @unused
    private def measure(checkpoint: String): Unit = {
      times = times + ((genId(), checkpoint) -> System.currentTimeMillis())
    }

    def start(period: String): Unit = {
      val now = System.currentTimeMillis()
      val lastTime = now - lastStart
      times = times + ((genId(), currentPeriod) -> lastTime)
      lastStart = now
      currentPeriod = period
    }

    @unused
    def get(period: String): Long = times.find(v => v._1._2 == period).map(_._2).getOrElse(0)

    override def toString: String = {
      var res = "timing "
      val switems = times.toList.filterNot(x => x._1._2 == "none" || x._1._2 == "done").sortBy(_._1._1)

      if (switems.nonEmpty) {
        res = res + "("
        res = res + switems.map(_._1._2).reduce(_ + ", " + _)
        res = res + ")\n"
        res = res + switems.map(_._2.toString).reduce(_ + ";" + _)
      }
      res
    }
  }


  def processFile(opt: FrontendOptions): Unit = {
    val errorXML = new ErrorXML(opt.getErrorXMLFile)
    opt.setRenderParserError(errorXML.renderParserError)

    val stopWatch = new StopWatch()
    stopWatch.start("loadFM")

    val smallFM = opt.getSmallFeatureModel.and(opt.getLocalFeatureModel).and(opt.getFilePresenceCondition)
    opt.setSmallFeatureModel(smallFM) //otherwise the lexer does not get the updated feature model with file presence conditions
    val fullFM = opt.getFullFeatureModel.and(opt.getLocalFeatureModel).and(opt.getFilePresenceCondition)
    opt.setFullFeatureModel(fullFM) // should probably be fixed in how options are read
    if (!opt.getFilePresenceCondition.isSatisfiable(fullFM)) {
      println("file has contradictory presence condition. existing.") //otherwise this can lead to strange parser errors, because True is satisfiable, but anything else isn't
      return
    }

    var ast: TranslationUnit = null
    if (opt.reuseAST && opt.parse && new File(opt.getSerializedASTFilename).exists()) {
      println("loading AST.")
      try {
        ast = loadSerializedAST(opt.getSerializedASTFilename)
        ast = prepareAST[TranslationUnit](ast)
      } catch {
        case e: Throwable => println(e.toString); e.printStackTrace(); ast = null
      }
      if (ast == null)
        println("... failed reading AST\n")
    }

    stopWatch.start("lexing")
    //no parsing if read serialized ast
    val in = if (ast == null) {
      println("#lexing")
      lex(opt)
    } else null


    if (opt.parse) {
      println("#parsing")
      stopWatch.start("parsing")

      if (ast == null) {
        //no parsing and serialization if read serialized ast
        val parserMain = new ParserMain(new CParser(smallFM))
        ast = parserMain.parserMain(in, opt, fullFM)
        ast = prepareAST[TranslationUnit](ast)
        // checkPositionInformation(ast)

        if (ast != null && opt.serializeAST) {
          stopWatch.start("serialize")
          serializeAST(ast, opt.getSerializedASTFilename)
        }

      }

      if (ast != null) {

        // some dataflow analyses require typing information
        val ts = if (opt.typechecksa)
          new CTypeSystemFrontend(ast, fullFM, opt) with CTypeCache with CDeclUse
        else
          new CTypeSystemFrontend(ast, fullFM, opt)


        /** I did some experiments with the TypeChef FeatureModel of Linux, in case I need the routines again, they are saved here. */
        //Debug_FeatureModelExperiments.experiment(fm_ts)

        if (opt.typecheck || opt.writeInterface || opt.typechecksa) {
          //ProductGeneration.typecheckProducts(fm,fm_ts,ast,opt,
          //logMessage=("Time for lexing(ms): " + (t2-t1) + "\nTime for parsing(ms): " + (t3-t2) + "\n"))
          //ProductGeneration.estimateNumberOfVariants(ast, fm_ts)

          stopWatch.start("typechecking")
          println("#type checking")
          ts.checkAST(printResults = true)
          ts.errors.foreach(errorXML.renderTypeError)
        }
        if (opt.writeInterface) {
          stopWatch.start("interfaces")
          val interface = ts.getInferredInterface().and(opt.getFilePresenceCondition)

          stopWatch.start("writeInterfaces")
          ts.writeInterface(interface, new File(opt.getInterfaceFilename))
          if (opt.writeDebugInterface)
            ts.debugInterface(interface, new File(opt.getDebugInterfaceFilename))
        }
        if (opt.dumpcfg) {
          println("#call graph")
          stopWatch.start("dumpCFG")

          //run without feature model, because otherwise too expensive runtimes in systems such as linux
          val cf = new CInterAnalysisFrontend(ast /*, fm_ts*/)
          val writer = new CFGCSVWriter(new FileWriter(new File(opt.getCCFGFilename)))
          val dotwriter = new DotGraph(new FileWriter(new File(opt.getCCFGDotFilename)))
          cf.writeCFG(opt.getFile, new ComposedWriter(List(dotwriter, writer)))
        }

        if (opt.staticanalyses) {
          println("#static analysis")
          val sa = new CIntraAnalysisFrontend(ast, ts.asInstanceOf[CTypeSystemFrontend with CTypeCache with CDeclUse], fullFM)
          if (opt.warning_double_free) {
            stopWatch.start("doublefree")
            sa.doubleFree()
          }
          if (opt.warning_uninitialized_memory) {
            stopWatch.start("uninitializedmemory")
            sa.uninitializedMemory()
          }
          if (opt.warning_case_termination) {
            stopWatch.start("casetermination")
            sa.caseTermination()
          }
          if (opt.warning_xfree) {
            stopWatch.start("xfree")
            sa.xfree()
          }
          if (opt.warning_dangling_switch_code) {
            stopWatch.start("danglingswitchcode")
            sa.danglingSwitchCode()
          }
          if (opt.warning_cfg_in_non_void_func) {
            stopWatch.start("cfginnonvoidfunc")
            sa.cfgInNonVoidFunc()
          }
          if (opt.warning_stdlib_func_return) {
            stopWatch.start("checkstdlibfuncreturn")
            sa.stdLibFuncReturn()
          }
          if (opt.warning_dead_store) {
            stopWatch.start("deadstore")
            sa.deadStore()
          }
        }

      }

    }
    stopWatch.start("done")
    errorXML.write()
    if (opt.recordTiming)
      println(stopWatch)

  }


  def lex(opt: FrontendOptions): TokenReader[CToken, CTypeContext] = {
    val tokens = new lexer.LexerFrontend().run(opt, opt.parse)
    val in = CLexerAdapter.prepareTokens(tokens)
    in
  }

  def serializeAST(ast: AST, filename: String): Unit = {
    val fw = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(filename)))
    fw.writeObject(ast)
    fw.close()
  }

  def loadSerializedAST(filename: String): TranslationUnit = try {
    val fr = new ObjectInputStream(new GZIPInputStream(new FileInputStream(filename))) {
      override protected def resolveClass(desc: ObjectStreamClass): Class[_] = {
        /*println(desc);*/ super.resolveClass(desc)
      }
    }
    val ast = fr.readObject().asInstanceOf[TranslationUnit]
    fr.close()
    ast
  } catch {
    case e: ObjectStreamException => System.err.println("failed loading serialized AST: " + e.getMessage); null
  }
}
