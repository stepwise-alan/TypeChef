package de.fosd.typechef.parser.test

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr.FeatureExprFactory._
import de.fosd.typechef.featureexpr.{FeatureExpr, SingleFeatureExpr}
import de.fosd.typechef.parser._
import de.fosd.typechef.parser.test.parsers._
import org.junit.Assert._
import org.junit._

class JoinTest extends MultiFeatureParser {
  type Elem = MyToken
  type TypeContext = Any

  val tokenStream = new TokenReader[MyToken, TypeContext](List.fill(10)(new MyToken("_", True)), 0, (), EofToken)
  val in1: TokenReader[MyToken, Any] = tokenStream
  val in2: TokenReader[MyToken, Any] = in1.rest
  val in3: TokenReader[MyToken, Any] = in2.rest
  val fa: SingleFeatureExpr = createDefinedExternal("a")
  val fb: SingleFeatureExpr = createDefinedExternal("b")

  abstract class A

  case class L(v: Int) extends A


  //checks recursively that there is an according V with the required presence condition
  private def assertContainsL(result: MultiParseResult[Conditional[A]], f: FeatureExpr, l: L): Unit = {
    var found = false

    //check in CHOICE
    def find(feature: FeatureExpr, r: Conditional[A], expectedFeature: FeatureExpr, expectedL: L): Boolean =
      r match {
        case Choice(f, a, b) => find(feature and f, a, expectedFeature, expectedL) || find(feature and f.not(), b, expectedFeature, expectedL)
        case One(a) => (a == expectedL) && (feature equivalentTo expectedFeature)
      }

    //check in all SPLITs
    for ((feature, r) <- result.toList(True))
      r match {
        case Success(r, _) => found |= find(feature, r, f, l)
        case _ =>
      }
    assertTrue("expected " + l + " with " + f + " in " + result, found)
  }

  //checks recursively that there is an according entry with the required presence condition as direct child of a Success
  private def assertContains(result: MultiParseResult[Conditional[A]], f: FeatureExpr, entry: ParseResult[Conditional[A]]): Unit = {
    var found = false
    for ((feature, r) <- result.toList(True))
      if ((r == entry) && (feature equivalentTo f))
        found = true
    assertTrue("expected " + entry + " with " + f + " in " + result, found)
  }

  @Test def testJoinBinary(): Unit = {
    val s1 = Success[A](L(1), in1)
    val s2 = Success[A](L(2), in1)
    val s = SplittedParseResult[A](fa, s1, s2)
    val joined = s.join(True)

    println(joined)

    assertContainsL(joined, fa, L(1))
    assertContainsL(joined, fa.not(), L(2))
    assertContains(joined, True, Success(Choice(fa, One(L(1)), One(L(2))), in1))
  }

  @Test def testJoinInnerBinary(): Unit = {
    val s1 = Success[A](L(1), in1)
    val s2 = Success[A](L(2), in1)
    val s3 = Success[A](L(2), in2)
    val s = SplittedParseResult(fb, SplittedParseResult[A](fa, s1, s2), s3)
    val joined = s.join(True)

    println(joined)
    assertContainsL(joined, fb and fa, L(1))
    assertContainsL(joined, fb and fa.not(), L(2))
    assertContains(joined, fb, Success(Choice(fa, One(L(1)), One(L(2))), in1))
  }

  @Test def testNoJoinBinary(): Unit = {
    val s1 = Success[A](L(1), in1)
    val s2 = Success[A](L(2), in2)
    val s = SplittedParseResult[A](fa, s1, s2)
    val joined = s.join(True)


    assertContainsL(joined, fa, L(1))
    assertContainsL(joined, fa.not(), L(2))
    assertTrue(joined.isInstanceOf[SplittedParseResult[_]])
  }

  @Test def testJoinTree(): Unit = {
    val s1 = Success[A](L(1), in1)
    val s2 = Success[A](L(2), in1)
    val s3 = Success[A](L(3), in2)
    val s = SplittedParseResult[A](fa, SplittedParseResult(fb, s1, s3), s2)
    val joined = s.join(True)

    println(joined)

    assertContainsL(joined, fa and fb, L(1))
    assertContainsL(joined, fa and fb.not(), L(3))
    assertContainsL(joined, fa.not(), L(2))
    assertTrue(joined.isInstanceOf[SplittedParseResult[_]])
    assertContains(joined, (fa and fb) or fa.not(), Success(Choice(fa and fb, One(L(1)), One(L(2))), in1))
  }

}