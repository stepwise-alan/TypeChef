package de.fosd.typechef.parser.c

import de.fosd.typechef.featureexpr._
import junit.framework._
import org.bitbucket.inkytonik.kiama.rewriting.Rewriter._
import org.junit.Assert._
import org.junit.{Assert, Test}

import java.util.Collections


class CGramFilesTest extends TestCase with TestHelper {
  val p = new CParser()

  //XXX duplicate of TestErrorReportingTest.parseFile
  def parseFile(fileName: String): Unit = {
    val inputStream = getClass.getResourceAsStream("/" + fileName)
    println(inputStream.toString)
    assertNotNull("file not found " + fileName, inputStream)
    val result = p.phrase(p.translationUnit)(
      lexStream(inputStream, fileName, Collections.emptyList(), null), FeatureExprFactory.True)
    System.out.println(result)
    (result: @unchecked) match {
      case p.Success(ast, unparsed) =>
        val emptyLocation = checkPositionInformation(ast.asInstanceOf[Product])
        assertTrue("found nodes with empty location information", emptyLocation.isEmpty)
        assertTrue("parser did not reach end of token stream: " + unparsed, unparsed.atEnd)
      //succeed
      case p.NoSuccess(msg, unparsed, inner) =>
        Assert.fail(msg + " at " + unparsed + " " + inner)
    }

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

  @Test
  def test1(): Unit = {
    parseFile("cgram/test.c")
  }

  def test2(): Unit = {
    parseFile("cgram/test2.c")
  }

  def test3(): Unit = {
    parseFile("cgram/test3.c")
  }

  def test4(): Unit = {
    parseFile("cgram/test4.c")
  }

  def test5(): Unit = {
    parseFile("cgram/test5.c")
  }

  def test6(): Unit = {
    parseFile("cgram/test6.c")
  }

  def test7(): Unit = {
    parseFile("cgram/test7.c")
  }

  def ignoretest8(): Unit = {
    parseFile("cgram/test8.c")
  }

  //scoped typedef
  def test9(): Unit = {
    parseFile("cgram/test9.c")
  }

  def test10(): Unit = {
    parseFile("cgram/test10.c")
  }

  def test11(): Unit = {
    parseFile("cgram/test11.c")
  }

  def test12(): Unit = {
    parseFile("cgram/test12.c")
  }

  def test13(): Unit = {
    parseFile("cgram/test13.c")
  }

  def test14(): Unit = {
    parseFile("cgram/test14.c")
  }

  def test15(): Unit = {
    parseFile("cgram/test15.c")
  }

  def test16(): Unit = {
    parseFile("cgram/test16.c")
  }

  def test17(): Unit = {
    parseFile("cgram/test17.c")
  }

  def test18(): Unit = {
    parseFile("cgram/test18.c")
  }

  def test19(): Unit = {
    parseFile("cgram/test19.c")
  }

  def test20(): Unit = {
    parseFile("cgram/test20.c")
  }

  def test21(): Unit = {
    parseFile("cgram/test21.c")
  }

  def test22(): Unit = {
    parseFile("cgram/test22.c")
  }

  def test23(): Unit = {
    parseFile("cgram/test23.c")
  }

  def test24(): Unit = {
    parseFile("cgram/test24.c")
  }

  def test25(): Unit = {
    parseFile("cgram/test25.c")
  }

  def test26(): Unit = {
    parseFile("cgram/test26.c")
  }

  def test27(): Unit = {
    parseFile("cgram/test27.c")
  }

  def test28(): Unit = {
    parseFile("cgram/test28.c")
  }

  def test29(): Unit = {
    parseFile("cgram/test29.c")
  }

  def test30(): Unit = {
    parseFile("cgram/test30.c")
  }

  def test31(): Unit = {
    parseFile("cgram/test31.c")
  }

  def test32(): Unit = {
    parseFile("cgram/test32.c")
  }

  def test33(): Unit = {
    parseFile("cgram/test33.c")
  }

  def test34(): Unit = {
    parseFile("cgram/test34.c")
  }

  def test35(): Unit = {
    parseFile("cgram/test35.c")
  }

  def test36(): Unit = {
    parseFile("cgram/test36.c")
  }

  def test37(): Unit = {
    parseFile("cgram/test37.c")
  }

  def test38(): Unit = {
    parseFile("cgram/test38.c")
  }

  def test39(): Unit = {
    parseFile("cgram/test39.c")
  }

  def test40(): Unit = {
    parseFile("cgram/test40.c")
  }

  def test41(): Unit = {
    parseFile("cgram/test41.c")
  }

  def ignoretest42(): Unit = {
    parseFile("cgram/test42.c")
  }

  //ignore variable and typedef with same name
  def test43(): Unit = {
    parseFile("cgram/test43.c")
  }

  def test44(): Unit = {
    parseFile("cgram/test44.c")
  }

  def test45(): Unit = {
    parseFile("cgram/test45.c")
  }

  def test46(): Unit = {
    parseFile("cgram/test46.c")
  }

  def test47(): Unit = {
    parseFile("cgram/test47.c")
  }

  def test48(): Unit = {
    parseFile("cgram/test48.c")
  }

  def test49(): Unit = {
    parseFile("cgram/test49.c")
  }

  def test50(): Unit = {
    parseFile("cgram/test50.c")
  }

  def test51(): Unit = {
    parseFile("cgram/test51.c")
  }

  def test52(): Unit = {
    parseFile("cgram/test52.c")
  }

  def test53(): Unit = {
    parseFile("cgram/test53.c")
  }

  def test54(): Unit = {
    parseFile("cgram/test54.c")
  }

  def test55(): Unit = {
    parseFile("cgram/test55.c")
  }

  def test56(): Unit = {
    parseFile("cgram/test56.c")
  }

  def test57(): Unit = {
    parseFile("cgram/test57.c")
  }

  def test58(): Unit = {
    parseFile("cgram/test58.c")
  }

  def test59(): Unit = {
    parseFile("cgram/test59.c")
  }

  def test60(): Unit = {
    parseFile("cgram/test60.c")
  }

  def test61(): Unit = {
    parseFile("cgram/test61.c")
  }

  def test62(): Unit = {
    parseFile("cgram/test62.c")
  }

  def test63(): Unit = {
    parseFile("cgram/test63.c")
  }

  def test64(): Unit = {
    parseFile("cgram/test64.c")
  }

  def test65(): Unit = {
    parseFile("cgram/test65.c")
  }

  def test66(): Unit = {
    parseFile("cgram/test66.c")
  }

  def test67(): Unit = {
    parseFile("cgram/test67.c")
  }

  def test68(): Unit = {
    parseFile("cgram/test68.c")
  }

  def test69(): Unit = {
    parseFile("cgram/test69.c")
  }

  def test70(): Unit = {
    parseFile("cgram/test70.c")
  }

  def test71(): Unit = {
    parseFile("cgram/test71.c")
  }

  def test72(): Unit = {
    parseFile("cgram/test72.c")
  }

  def test73(): Unit = {
    parseFile("cgram/test73.c")
  }

  def test74(): Unit = {
    parseFile("cgram/test74.c")
  }

  def test75(): Unit = {
    parseFile("cgram/test75.c")
  }

  def test76(): Unit = {
    parseFile("cgram/test76.c")
  }

  def test77(): Unit = {
    parseFile("cgram/test77.c")
  }

  def test78(): Unit = {
    parseFile("cgram/test78.c")
  }

  def test79(): Unit = {
    parseFile("cgram/test79.c")
  }

  def test80(): Unit = {
    parseFile("cgram/test80.c")
  }

  def test81(): Unit = {
    parseFile("cgram/test81.c")
  }

  def test83(): Unit = {
    parseFile("cgram/test83.c")
  }

  def test84(): Unit = {
    parseFile("cgram/test84.c")
  }

  def test85(): Unit = {
    parseFile("cgram/test85.c")
  }

  def test86(): Unit = {
    parseFile("cgram/test86.c")
  }

  def test87(): Unit = {
    parseFile("cgram/test87.c")
  }

  def testparamstruct(): Unit = {
    parseFile("errors/parameterstruct.c")
  }
}