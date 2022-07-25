package de.fosd.typechef.parser.c

import de.fosd.typechef.featureexpr._
import org.bitbucket.inkytonik.kiama.rewriting.Rewriter._
import org.junit.Assert._
import org.junit.{Assert, Ignore}

import java.util.Collections

class MiscFileTest extends TestHelper {
  def parseFile(fileName: String): Unit = {
    val inputStream = getClass.getResourceAsStream("/" + fileName)
    assertNotNull("file not found " + fileName, inputStream)
    val p = new CParser()
    val result = p.translationUnit(
      lexStream(inputStream, fileName, Collections.singletonList("testfiles/boa/"), null), FeatureExprFactory.True)

    def printResult(result: CParser#MultiParseResult[Any], fexpr: FeatureExpr): Unit =
      (result: @unchecked) match {
        case p.Success(ast, unparsed) =>
          val emptyLocation = checkPositionInformation(ast.asInstanceOf[Product])
          assertTrue(fexpr.toString + ": found nodes with empty location information", emptyLocation.isEmpty)
          assertTrue(fexpr.toString + ": parser did not reach end of token stream: " + unparsed, unparsed.atEnd)
        //succeed
        case p.NoSuccess(msg, unparsed, inner) =>
          println(unparsed.context)
          Assert.fail(msg + " at " + unparsed + " " + inner)
        case p.SplittedParseResult(f, a, b) =>
          printResult(a, fexpr and f)
          printResult(b, fexpr andNot f)
          Assert.fail("Unexpected split parse result")
      }

    printResult(result, FeatureExprFactory.True)

  }

  def checkPositionInformation(ast: Product): List[Product] = {
    assert(ast != null)
    var nodeswithoutposition: List[Product] = List()
    val checkpos = everywherebu(query[Product] {
      case a: AST => if (!a.hasPosition) nodeswithoutposition ::= a
    })
    checkpos(ast)
    nodeswithoutposition
  }

  //

  @Ignore("this is a nice and small example of a code fragment for which the parser creates dead nodes. there is no test currently checking for it, and since it's also not technically wrong, we are not enforcing the absence of dead nodes")
  def testDuplicateASTProblem(): Unit = {
    parseFile("other/alex.c")
  }
}