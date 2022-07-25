package de.fosd.typechef.typesystem.linker

import de.fosd.typechef.parser.c.{TestHelper, TranslationUnit}
import org.junit._

import java.io.{File, FileNotFoundException, InputStream}

class InterfaceSerializationTest extends TestHelper {

  val folder = "testfiles/"

  private def parse(filename: String): TranslationUnit = {
    val start = System.currentTimeMillis
    println("parsing " + filename)
    val inputStream: InputStream = getClass.getResourceAsStream("/" + folder + filename)
    if (inputStream == null) {
      throw new FileNotFoundException("Input file not found: " + filename)
    }
    val ast = parseFile(inputStream, filename, folder)
    val parsed = System.currentTimeMillis
    println("parsed " + filename + " (" + (parsed - start) + ")")
    ast
  }


  private def checkSerialization(i: CInterface): Unit = {
    val inf = new InterfaceWriter {}
    val f = new File("tmp.interface")
    inf.writeInterface(i, f)
    val interface2 = inf.readInterface(f)


    //
    assert(i equals interface2)
    assert(!(i eq interface2))

    f.delete()
  }

  @Test
  def testMini(): Unit = {
    val ast = parse("mini.pi")
    val interface = new CInferInterface {}.inferInterface(ast)
    //    println(interface)
    checkSerialization(interface)
  }

  @Test
  def testBoa(): Unit = {
    val ast = parse("boa.pi")
    val interface = new CInferInterface {}.inferInterface(ast)
    //    println(interface)
    checkSerialization(interface)
  }

  @Test
  def testAr(): Unit = {
    val ast = parse("ar.pi")
    val interface = new CInferInterface {}.inferInterface(ast)
    //    println(interface)
    checkSerialization(interface)
  }


  @Test
  def testDeadCodeDetection(): Unit = {
    val ast = parse("deadcode.pi")
    val interface = new CInferInterface {}.inferInterface(ast)
    //    println(interface)
    checkSerialization(interface)
  }


  //       @Test
  //    def testFork {
  //        val ast = parse("fork_.pi")
  //        val interface = new CInferInterface {}.inferInterface(ast)
  //        println(interface)
  //    }
}