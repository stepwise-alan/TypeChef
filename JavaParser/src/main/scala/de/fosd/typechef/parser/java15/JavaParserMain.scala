package de.fosd.typechef.parser.java15

object JavaParserMain {
  //        def parserMain(filePath: String, parentPath: String): AST =
  //            parserMain(filePath, parentPath, new CTypeContext())
  //
  //        def parserMain(filePath: String, parentPath: String, initialContext: CTypeContext): AST = {
  //            val logStats = MyUtil.runnable(() => {
  //                if (TokenWrapper.profiling) {
  //                    val statistics = new PrintStream(new BufferedOutputStream(new FileOutputStream(filePath + ".stat")))
  //                    LineInformation.printStatistics(statistics)
  //                    statistics.close()
  //                }
  //            })
  //
  //            Runtime.getRuntime().addShutdownHook(new Thread(logStats))
  //
  //            val result = new CParser().translationUnit(
  //                CLexer.lexFile(filePath, parentPath).setContext(initialContext), FeatureExprFactory.True)
  //
  //            println(printParseResult(result, FeatureExprFactory.True))
  //    //        checkParseResult(result, FeatureExprFactory.True)
  //
  //            //        val resultStr: String = result.toString
  //            //        println("FeatureSolverCache.statistics: " + FeatureSolverCache.statistics)
  //            //        val writer = new FileWriter(filePath + ".ast")
  //            //        writer.write(resultStr);
  //            //        writer.close
  //            //        println("done.")
  //
  //            //XXX: that's too simple, we need to typecheck also split results.
  //            // Moreover it makes the typechecker crash currently (easily workaroundable though).
  //            result match {
  //                case Success(ast, _) => ast
  //                case _ => null
  //            }
  //        }
  //
  //        def printParseResult(result: MultiParseResult[Any, TokenWrapper, CTypeContext], feature: FeatureExpr): String = {
  //            result match {
  //                case Success(ast, unparsed) => {
  //                    if (unparsed.atEnd)
  //                        (feature.toString + "\tsucceeded\n")
  //                    else
  //                        (feature.toString + "\tstopped before end (at " + unparsed.first.getPosition + ")\n")
  //                }
  //                case NoSuccess(msg, context, unparsed, inner) =>
  //                    (feature.toString + "\tfailed " + msg + "\n")
  //                case SplittedParseResult(f, left, right) => {
  //                    printParseResult(left, feature.and(f)) + "\n" +
  //                        printParseResult(right, feature.and(f.not()))
  //                }
  //            }
  //        }
  //
  //        def checkParseResult(result: MultiParseResult[Any, TokenWrapper, CTypeContext], feature: FeatureExpr) {
  //            result match {
  //                case Success(ast, unparsed) => {
  //                    if (!unparsed.atEnd)
  //                        new Exception("parser did not reach end of token stream with feature " + feature + " (" + unparsed.first.getPosition + "): " + unparsed).printStackTrace
  //                    //succeed
  //                }
  //                case NoSuccess(msg, context, unparsed, inner) =>
  //                    new Exception(msg + " at " + unparsed + " with feature " + feature + " and context " + context + " " + inner).printStackTrace
  //                case SplittedParseResult(f, left, right) => {
  //                    checkParseResult(left, feature.and(f))
  //                    checkParseResult(right, feature.and(f.not()))
  //                }
  //            }
  //        }
  //
  //        def main(args: Array[String]) = {
  //            for (filename <- args) {
  //                println("**************************************************************************")
  //                println("** Processing file: " + filename)
  //                println("**************************************************************************")
  //                val parentPath = new File(filename).getParent()
  //                parserMain(filename, parentPath, new CTypeContext())
  //                println("**************************************************************************")
  //                println("** End of processing for: " + filename)
  //                println("**************************************************************************")
  //            }
  //        }
}
