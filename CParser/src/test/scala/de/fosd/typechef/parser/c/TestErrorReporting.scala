package de.fosd.typechef.parser.c

import de.fosd.typechef.featureexpr._
import junit.framework._
import org.junit.Assert._
import org.junit.Test

import java.util.Collections

class TestErrorReporting extends TestCase with TestHelper {
  //XXX duplicate of CGramFilesTest.parseFile
  def parseFile(fileName: String): Unit = {
    val inputStream = getClass.getResourceAsStream("/" + fileName)
    assertNotNull("file not found " + fileName, inputStream)
    val p = new CParser()
    val result = p.translationUnit(
      lexStream(inputStream, fileName, Collections.singletonList("testfiles/cgram/"), null), FeatureExprFactory.True)
    System.out.println(result)
    (result: @unchecked) match {
      case p.Success(_, _) =>
        fail("should not succeed")
      //succeed
      case p.NoSuccess(_, _, _) =>
      case p.SplittedParseResult(_, _, p.NoSuccess(_, _, _)) =>
    }

  }

  //

  @Test
  def test1(): Unit = {
    parseFile("errors/test.c")
  }

}
