package de.fosd.typechef.typesystem.generator

/**
 * there are too many cases and the declaration isn't understandable.
 *
 * instead, we generate test cases and check with gcc whether those test
 * cases should fail or not (differential testing)
 *
 * we consider a number of possible changes in a test and use a sampling
 * strategy to cover many combinations of the changes
 */
object AddExprTestGenerator extends App with AbstractGenerator {

  def types = CastTestGenerator.types

  override def considerWarnings = true

  val configSpace = List(Opt(types.length), Opt(types.length))


  def genTest(c: Config): List[String] = {
    val t1 = genType(c.vals.head)
    val t2 = genType(c.vals(1))
    val t = s"              $t1 foo();\n" +
      s"              $t2 bar();\n" +
      s"              $t2 x() {\n" +
      s"                $t1 a = foo();\n" +
      s"                $t2 b = bar();\n" +
      s"                $t2 c = a + b;\n" +
      "                return c;\n" +
      "              }"

    val u = s"              $t1 foo();\n" +
      s"              $t2 bar();\n" +
      s"              $t1 x() {\n" +
      s"                $t1 a = foo();\n" +
      s"                $t2 b = bar();\n" +
      s"                $t1 c = a + b;\n" +
      "                return c;\n" +
      "              }"

    val v = s"              $t1 foo();\n" +
      s"              $t2 x() {\n" +
      s"                $t1 a = foo();\n" +
      s"                $t1 b = foo();\n" +
      s"                $t2 c = a + b;\n" +
      "                return c;\n" +
      "              }"

    List(addStructs(t), addStructs(u), addStructs(v))
  }


  def genType(t: Int) = types(t)

  generate("GeneratedAddExprTests", bruteforceConfigs)

}
