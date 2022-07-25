package de.fosd.typechef.parser.c


import de.fosd.typechef.featureexpr._
import de.fosd.typechef.parser._
import org.junit.Assert._

import java.io._
import java.util.Collections

object ParserBenchmark extends App with TestHelper {

  val p = new CParser()

  def parseFile(fileName: String) = {
    var inputStream = getClass.getResourceAsStream("/" + fileName)
    if (inputStream == null && new File(fileName).exists)
      inputStream = new FileInputStream(new File(fileName))
    assertNotNull("file not found " + fileName, inputStream)
    val in = lexStream(inputStream, fileName, Collections.singletonList("testfiles/cgram/"), null)
    println(in.tokens.size)
    val result = p.phrase(p.translationUnit)(in, FeatureExprFactory.True)
    (result: @unchecked) match {
      case p.Success(_, unparsed) =>
        assertTrue("parser did not reach end of token stream: " + unparsed, unparsed.atEnd)
      //succeed
      case p.NoSuccess(msg, unparsed, inner) =>
        println(msg + " at " + unparsed + " " + inner)
    }
    in
  }

  var start = System.currentTimeMillis
  //    var in = parseFile("cgram/test30.c")
  var in = parseFile("D:\\work\\TypeChef\\CParser\\src\\test\\resources\\cgram/test30.c")
  println("test30: " + ProfilingTokenHelper.totalConsumed(in) + ", backtracked " + ProfilingTokenHelper.totalBacktracked(in) + ", repeated " + ProfilingTokenHelper.totalRepeated(in) + " in " + (System.currentTimeMillis - start) + " ms")
  reportUnparsedTokens(in)

  start = System.currentTimeMillis
  in = parseFile("D:\\work\\TypeChef\\CParser\\src\\test\\resources\\other/grep.pi")
  println("grep: " + ProfilingTokenHelper.totalConsumed(in) + ", backtracked " + ProfilingTokenHelper.totalBacktracked(in) + ", repeated " + ProfilingTokenHelper.totalRepeated(in) + " in " + (System.currentTimeMillis - start) + " ms")


  def reportUnparsedTokens(in: TokenReader[CToken, CTypeContext]): Unit = {
    for (t <- in.tokens)
      if (t.profile_consumed == 0)
        println("not consumed: " + t)
  }

}