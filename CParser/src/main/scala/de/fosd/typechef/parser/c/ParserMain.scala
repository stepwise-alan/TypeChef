package de.fosd.typechef.parser.c

import de.fosd.typechef.conditional.{Choice, Opt}
import de.fosd.typechef.error.Position
import de.fosd.typechef.featureexpr.FeatureExprFactory.True
import de.fosd.typechef.featureexpr._
import de.fosd.typechef.parser._
import org.bitbucket.inkytonik.kiama.rewriting.Rewriter._

import java.io.{File, FileWriter}
import scala.annotation.unused

object MyUtil {
  implicit def runnable(f: () => Unit): Runnable =
    new Runnable() {
      override def run(): Unit = f()
    }
}
//
//object ParserMain {
//    import scala.collection.JavaConversions._
//
//    def main(args: Array[String]) = {
//        val parserMain = new ParserMain(new CParser(null))
//
//        for (filename <- args) {
//            println("**************************************************************************")
//            println("** Processing file: " + filename)
//            println("**************************************************************************")
////            val currentDir = new File(filename).getParent()
////            parserMain.parserMain(filename, Collections.singletonList(currentDir))
//
//            val currentDir = new File(filename).getParent()
//            val lexer = (() => CLexer.prepareTokens(new LexerFrontend().parseFile(filename, Collections.singletonList(currentDir), null)))
//            parserMain.parserMain(lexer, new CTypeContext(), DefaultParserOptions)
//
//            println("**************************************************************************")
//            println("** End of processing for: " + filename)
//            println("**************************************************************************")
//        }
//    }
//}


class ParserMain(p: CParser) {

  //    /**
  //     * debug and testing function only; do not use for serious processing since it ignores all lexer options
  //     */
  //    def parserMain(filePath: String, systemIncludePath: java.util.List[String], parserOptions: ParserOptions = DefaultParserOptions): TranslationUnit = {
  //        val lexer = (() => CLexer.lexFile(filePath, systemIncludePath, p.featureModel))
  //        parserMain(lexer, new CTypeContext(), parserOptions)
  //    }

  def parserMain(tokenstream: TokenReader[CToken, CTypeContext], parserOptions: ParserOptions, fullFeatureModel: FeatureModel): TranslationUnit = {
    parserMain(() => tokenstream, CTypeContext(), parserOptions, fullFeatureModel)
  }


  def parserMain(lexer: () => TokenReader[CToken, CTypeContext], initialContext: CTypeContext, parserOptions: ParserOptions, fullFeatureModel: FeatureModel): TranslationUnit = {
    assert(parserOptions != null)
    val ctx = True
    val in: p.Input = lexer().setContext(initialContext)

    val parserStartTime = System.currentTimeMillis
    val result2: p.MultiParseResult[TranslationUnit] = p.phrase(p.translationUnit)(in, ctx)
    val result = result2.prune(fullFeatureModel)
    val endTime = System.currentTimeMillis

    //ensure that "did not reach end errors are handled as part of the phrase combinator
    result.mapr({
      case x@p.Success(_, rest) => assert(rest.atEnd, "phrase() should have ensured reaching the end of the tokenstream in a success case"); x
      case x => x
    })

    //print parsing results to sysout and the the error file (if configured)
    if (parserOptions.printParserResult)
      println(printParseResult(result, ctx))
    renderParseResult(result, ctx, parserOptions.renderParserError)

    //print statistics if configured
    if (parserOptions.printParserStatistics) {
      val distinctFeatures = getDistinctFeatures(in.tokens) //expensive to calculate with bdds (at least the current implementation)
      print("Parsing statistics: \n" +
        "  Duration parsing: " + (endTime - parserStartTime) + " ms\n" +
        "  Tokens: " + in.tokens.size + "\n")
      if (in.first.isInstanceOf[ProfilingToken])
        print(
          "  Tokens Consumed: " + ProfilingTokenHelper.totalConsumed(in.asInstanceOf[TokenReader[ProfilingToken, CTypeContext]]) + "\n" +
            "  Tokens Backtracked: " + ProfilingTokenHelper.totalBacktracked(in.asInstanceOf[TokenReader[ProfilingToken, CTypeContext]]) + "\n" +
            "  Tokens Repeated: " + ProfilingTokenHelper.totalRepeated(in.asInstanceOf[TokenReader[ProfilingToken, CTypeContext]]) + "\n")
      //                "  Repeated Distribution: " + ProfilingTokenHelper.repeatedDistribution(in) + "\n" +
      print(
        "  Conditional Tokens: " + countConditionalTokens(in.tokens) + "\n" +
          "  Distinct Features#: " + distinctFeatures.size + "\n" +
          "  Distinct Features: " + distinctFeatures.toList.sorted.mkString(";") + "\n" +
          "  Distinct Feature Expressions: " + countFeatureExpr(in.tokens) + "\n" +
          "  Choice Nodes: " + countChoiceNodes(result) + "\n\n")
    }


    //return null (if parsing failed in all branches) or a single AST combining all parse results
    val ast = mergeResultsIntoSingleAST(ctx, result)
    if (parserOptions.simplifyPresenceConditions) {
      if (FeatureExprFactory.default == FeatureExprFactory.bdd) {
        return simplifyPresenceConditions(ast, FeatureExprFactory.True)
      } else {
        print("\"-bdd\" option required to simplify AST presence conditions.\n")
      }
    }

    ast
  }

  /**
   * Simplifies presence conditions on ast nodes in the AST.
   * AST is not changed but a new AST with changed pcs is returned. Positions are copied.
   * This method is based on Florian Garbe's method prepareASTforIfdef in de.fosd.typechef.cifdeftoif.IfdefToIf in the Hercules fork of TypeChef.
   */
  def simplifyPresenceConditions(ast: TranslationUnit, ctx: FeatureExpr = FeatureExprFactory.True): TranslationUnit = {
    val astEnv = de.fosd.typechef.parser.c.CASTEnv.createASTEnv(ast)

    def traverseASTRecursive[T <: Product](t: T, currentContext: FeatureExpr = FeatureExprFactory.True): T = {
      val r = alltd(rule[Any] {
        case l: List[_] =>
          l.flatMap(x => x match {
            case Opt(ft: FeatureExpr, entry) =>
              if (!ft.and(currentContext).isSatisfiable) {
                // current context makes ft impossible (-> ft == false and we can omit the node)
                List()
              } else {
                List(traverseASTRecursive(Opt(ft.simplify(currentContext), entry), ft.and(currentContext)))
              }
          })
        case c@Choice(ft, thenBranch, elseBranch) =>
          val ctx = astEnv.featureExpr(c)
          val newChoiceFeature = ft.simplify(ctx)
          val result = Choice(newChoiceFeature,
            traverseASTRecursive(thenBranch, ctx.and(newChoiceFeature)),
            traverseASTRecursive(elseBranch, ctx.and(newChoiceFeature.not())))
          result
      })
      r(t) match {
        case None =>
          t
        case k =>
          k.get.asInstanceOf[T]
      }
    }

    traverseASTRecursive(ast, ctx)
  }

  /**
   * merges multiple results into a single AST (possibly empty)
   *
   * in the merged result, all top-level declarations have presence conditions
   * restricted to the context where parsing was successful
   *
   * ideally, there should not be multiple successful results, because typechef should
   * have merged them before. here is a very simple merge strategy where the individual
   * top-level declarations are simply concatenated (with the mutually exclusive presence
   * conditions)
   */
  private def mergeResultsIntoSingleAST(ctx: FeatureExpr, result: p.MultiParseResult[TranslationUnit]): TranslationUnit = {

    def collectTopLevelDeclarations(ctx: FeatureExpr, result: p.MultiParseResult[TranslationUnit]): List[Opt[ExternalDef]] = {
      result match {
        case p.Success(r: TranslationUnit, _) => r.defs.map(_.and(ctx))
        case _: p.NoSuccess => List()
        case p.SplittedParseResult(f, left, right) =>
          collectTopLevelDeclarations(ctx and f, left.asInstanceOf[p.MultiParseResult[TranslationUnit]]) ++
            collectTopLevelDeclarations(ctx andNot f, right.asInstanceOf[p.MultiParseResult[TranslationUnit]])
      }
    }

    if (result.allFailed) null
    else TranslationUnit(collectTopLevelDeclarations(ctx, result))
  }


  def renderParseResult[T](result: p.MultiParseResult[T], feature: FeatureExpr, renderError: (FeatureExpr, String, Position) => Object): Unit =
    if (renderError != null)
      result.mapfr(feature, {
        case (_, x@p.Success(_, _)) => x
        case (f, x: p.NoSuccess) =>
          renderError(f, x.msg + " (" + x.innerErrors + ")", x.nextInput.pos); x
      })

  def printParseResult(result: p.MultiParseResult[Any], feature: FeatureExpr): String = {
    result match {
      case p.Success(_, _) =>
        feature.toString + "\tparsing succeeded\n"
      case noSuccess: p.NoSuccess =>
        feature.toString + "\tfailed: " + noSuccess.msg + " at " + noSuccess.nextInput.pos + " (" + noSuccess.innerErrors + ")\n"
      case p.SplittedParseResult(f, left, right) =>
        printParseResult(left.asInstanceOf[p.MultiParseResult[Any]], feature.and(f)) + "\n" +
          printParseResult(right.asInstanceOf[p.MultiParseResult[Any]], feature.and(f.not()))
    }
  }


  def countConditionalTokens(tokens: List[AbstractToken]): Int =
    tokens.count(_.getFeature != FeatureExprFactory.True)

  def getDistinctFeatures(tokens: List[AbstractToken]): Set[String] = {
    var features: Set[String] = Set()
    for (t <- tokens)
      features ++= t.getFeature.collectDistinctFeatures
    features
  }


  def printDistinctFeatures(tokens: List[AbstractToken], filename: String): Unit = {
    val w = new FileWriter(new File(filename))
    w.write(getDistinctFeatures(tokens).toList.sorted.mkString("\n"))
    w.close()
  }

  def countFeatureExpr(tokens: List[AbstractToken]): Int =
    tokens.foldLeft[Set[FeatureExpr]](Set())(_ + _.getFeature).size

  def countChoiceNodes(ast: p.MultiParseResult[AST]): Int = ast match {
    case p.Success(ast, _) => countChoices(ast.asInstanceOf[AST])
    case _ => -1
  }


  def countChoices(@unused ast: AST): Int = {
    // var result: Int = 0
    // ast.accept(new ASTVisitor {
    //   def visit(node: AST, ctx: FeatureExpr) {
    //     if (node.isInstanceOf[Choice[_]])
    //       result += 1
    //     for (opt <- node.getInnerOpt)
    //       if (opt.feature != FeatureExprFactory.True && opt.feature != ctx)
    //         if (!((ctx implies (opt.feature)).isTautology)) {
    //           result += 1
    //         }
    //   }
    //   def postVisit(node: AST, feature: FeatureExpr) {}
    // })
    // result
    0
  }

  /* match {
      case x: AbstractToken => 0
      case a ~ b => countChoices(a, ctx) + countChoices(b, ctx)
      case l: List[Any] => l.foldLeft[Int](0)(_ + countChoices(_, ctx))
      case Opt(f, r) =>
          countChoices(r, ctx and f) + (if ((ctx implies f).isTautology)
              0
          else
              1)
      case c: Choice => countChoices(c.left, ctx and c.feature) + countChoices(c.right, ctx andNot (c.feature)) + 1
      case Some(x) => countChoices(x, ctx)
      case None => 0
      case x: String => 0
      case e => {println(e); assert(false); 0}
  }*/
}