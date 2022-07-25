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
object CoerceTestGenerator extends App with AbstractGenerator {

  def types = CastTestGenerator.types

  val configSpace = List(Opt(types.length), Opt(types.length))

  override def considerWarnings = true

  def _firstParamType(c: Config): Int = c.vals.head

  def _secondParamType(c: Config): Int = c.vals(1)

  def genTest(c: Config): List[String] = {
    val t1 = genType(_firstParamType(c))
    val t2 = genType(_secondParamType(c))

    val t = s"              $t1 foo();\n" +
      "              void main() {\n" +
      s"                $t2 b;\n" +
      "                b = foo();\n" +
      "              }"

    val u = s"              $t1 foo();\n" +
      "              void main() {\n" +
      s"                $t2 b = foo();\n" +
      "              }"

    List(addStructs(t), addStructs(u))
  }


  def genType(t: Int) = types(t)

  generate("GeneratedCoerceTests", bruteforceConfigs)

}
