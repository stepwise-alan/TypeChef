package de.fost.typechef.parser.java15

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr._
import de.fosd.typechef.parser._
import de.fosd.typechef.parser.java15._

import java.io.{Console => _, _}
import scala.collection.mutable
import scala.math.pow

object ParseMobileMedia {

  val path = "W:\\work\\workspaces\\cide2runtime\\MobileMedia08_OO_clean\\src\\lancs\\mobilemedia"

  val dir = new File(path)

  def main(args: Array[String]): Unit = {
    checkDir(dir)

    println("Overall statistics:\n" +
      "    sumParsingTime = " + sumParsingTime +
      "\n    sumTokens =" + sumTokens +
      "\n    sumAnnotated: " + sumAnnotated +
      "\n    sumConsumed=" + sumConsumed +
      "\n    sumBacktracked =" + sumBacktracked +
      "\n    sumRepeated=" + sumRepeated +
      "\n    sumChoices=" + sumChoices +
      "\n    bruteForcePerFile=" + bruteForcePerFile)
    println("Features (" + features.size + "): " + features.mkString(", "))
    println(featuresPerFile)
  }

  def checkDir(dir: File): Unit = {
    if (dir.isFile)
      checkFile(dir)
    else
    //recurse
      dir.listFiles.foreach(checkDir)
  }

  def checkFile(file: File): Unit = {
    if (file.getName.endsWith(".java")) {
      println(file.getAbsolutePath)


      val lexerStartTime = System.currentTimeMillis
      val tokens = JavaLexer.lexFile(file.getAbsolutePath)

      val fileFeatures = findFeatures(tokens.tokens)
      val annotatedTokens = countAnnotatedTokens(tokens.tokens)

      val parserStartTime = System.currentTimeMillis
      val p = new JavaParser()
      val ast = p.phrase(p.CompilationUnit)(tokens, FeatureExprFactory.True)
      val endTime = System.currentTimeMillis

      println(ast)
      val choices = ast match {
        case p.Success(r, rest) =>
          assert(rest.atEnd)
          countChoices(r, FeatureExprFactory.True)
        case _ =>
          assert(false)
          0
      }


      println("Parsing statistics: \n" +
        "  Duration lexing: " + (parserStartTime - lexerStartTime) + " ms\n" +
        "  Duration parsing: " + (endTime - parserStartTime) + " ms\n" +
        "  Tokens: " + tokens.tokens.size + "\n" +
        "  Tokens Annotated: " + annotatedTokens + "\n" +
        "  Tokens Consumed: " + ProfilingTokenHelper.totalConsumed(tokens) + "\n" +
        "  Tokens Backtracked: " + ProfilingTokenHelper.totalBacktracked(tokens) + "\n" +
        "  Tokens Repeated: " + ProfilingTokenHelper.totalRepeated(tokens) + "\n" +
        "  Repeated Distribution: " + ProfilingTokenHelper.repeatedDistribution(tokens) + "\n" +
        "  Repeated Where: " + ProfilingTokenHelper.repeatedTokens(tokens).mkString(", ") + "\n" +
        "  Choices: " + choices)
      println("Features (" + fileFeatures.size + "): " + fileFeatures.mkString(", ") + "\n")

      sumParsingTime += (endTime - parserStartTime)
      sumTokens += tokens.tokens.size
      sumAnnotated += annotatedTokens
      sumConsumed += ProfilingTokenHelper.totalConsumed(tokens)
      sumBacktracked += ProfilingTokenHelper.totalBacktracked(tokens)
      sumRepeated += ProfilingTokenHelper.totalRepeated(tokens)
      features = features ++ fileFeatures
      featuresPerFile.put(fileFeatures.size, featuresPerFile.getOrElse(fileFeatures.size, 0) + 1)
      bruteForcePerFile = bruteForcePerFile + (pow(2, fileFeatures.size) * (sumTokens * 2 - sumAnnotated) / 2).toLong
      sumChoices += choices

      ast match {
        case p.Success(_, unparsed) =>
          if (!unparsed.atEnd) println("parser did not reach end of token stream: " + unparsed)
        case noSuccess: p.NoSuccess => println(noSuccess.msg + " at " + noSuccess.nextInput + " " + noSuccess.innerErrors)
        case p.SplittedParseResult(_, _, _) => println("split")
      }
    }
  }

  def countChoices(ast: Any, ctx: FeatureExpr): Int =
    ast match {
      case _: TokenWrapper => 0
      case a ~ b => countChoices(a, ctx) + countChoices(b, ctx)
      case l: List[_] => l.foldLeft[Int](0)(_ + countChoices(_, ctx))
      case Opt(f, r) =>
        countChoices(r, ctx and f) + (if ((ctx implies f).isTautology)
          0
        else
          1)
      case c: Choice[_] => countChoices(c.thenBranch, ctx and c.condition) + countChoices(c.elseBranch, ctx andNot c.condition) + 1
      case c: One[_] => countChoices(c.value, ctx)
      case Some(x) => countChoices(x, ctx)
      case None => 0
      case _: String => 0
      case e =>
        println(e)
        assert(false)
        0
    }


  def countAnnotatedTokens(tokens: List[TokenWrapper]): Int =
    tokens.count(_.getFeature != FeatureExprFactory.True)

  def findFeatures(tokens: List[TokenWrapper]): Set[String] = {
    var result: Set[String] = Set()

    for (t <- tokens) {
      result = result ++ findFeatures(t.getFeature)
    }

    result
  }

  def findFeatures(feature: FeatureExpr): Set[String] = feature.collectDistinctFeatures

  var sumParsingTime: Long = 0
  var sumTokens: Int = 0
  var sumConsumed: Int = 0
  var sumBacktracked: Int = 0
  var sumRepeated: Int = 0
  var sumAnnotated: Int = 0
  var sumChoices: Int = 0
  var features: Set[String] = Set()
  val featuresPerFile: mutable.Map[Int, Int] = mutable.Map()
  var bruteForcePerFile: Long = 0
}