package de.fosd.typechef.parser.c

import de.fosd.typechef.featureexpr._
import junit.framework._


class LexerTest extends TestCase with TestHelper {

  def testLexerSimple(): Unit = {
    println(lex("#ifdef X\n" + "#define foo f\n" + "#else\n"
      + "#define foo b\n" + "#endif\n" + "bar\n" + "#ifdef B\n"
      + "foo\n" + "#endif\n", FeatureExprFactory.default.featureModelFactory.create(FeatureExprFactory.createDefinedExternal("X"))))
  }

}