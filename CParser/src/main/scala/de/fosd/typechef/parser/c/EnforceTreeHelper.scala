package de.fosd.typechef.parser.c

import de.fosd.typechef.conditional.{One, Opt}
import de.fosd.typechef.error.WithPosition
import org.bitbucket.inkytonik.kiama.rewriting.Rewriter._

import scala.annotation.unused


/**
 * preparation and checks for downstream tools
 * which require a tree structure
 *
 * we use the product interface of the elements here works both for
 * case classes Opt and AST elements, which derive product directly
 */
trait EnforceTreeHelper {

  /**
   * unfortunately cloning loses position information, so we have to reassign it
   */
  def copyPositions(source: Product, target: Product): Unit = {
    if (source.getClass != target.getClass)
      System.err.println(s"cloned tree should match exactly the original, typewise " +
        s"(source: ${source.getClass.getName}, target: ${target.getClass.getName})")
    (source, target) match {
      case (sourcePosition: WithPosition, targetPosition: WithPosition) => targetPosition.range = sourcePosition.range
      case _ =>
    }

    if (source.productArity != target.productArity)
      System.err.println("cloned tree should match exactly the original " +
        s"(productArity, source: ${source.productArity}, target: ${source.productArity})")
    for ((c1, c2) <- source.productIterator.zip(target.productIterator)) {
      if (c1.getClass != c2.getClass)
        System.err.println("cloned tree should match exactly the original, typewise " +
          s"(source: ${c1.getClass.getName}, target: ${c2.getClass.getName})")
      c1 match {
        case product: Product if c2.isInstanceOf[Product] => copyPositions(product, c2.asInstanceOf[Product])
        case _ =>
      }
    }
  }


  // creates an AST without shared objects
  // the parser reuses parsed elements in different subtrees of the AST
  // this method makes sure we create an AST with unique elements
  def prepareAST[T <: Product](ast: T): T = {
    assert(ast != null, "ast should not be null")

    val clone = everywherebu(rule[Product] {
      //            // function to add a break expression to infinite loops: "for (;;) {}" and "for (;;) ;"
      //            // reason is: for (;;) is the only infinite loop without explicit break statement,
      //            // so if we omit CompoundStatement in succ pred determination, we need an expression
      //            // so that succ(e) -> e and pred(e) is e
      //            // we add a Constant("1") at the break
      case ForStatement(None, None, None, One(CompoundStatement(List()))) =>
        ForStatement(None, Some(Constant("1")), None, One(CompoundStatement(List())))
      case n: AST => n.clone()
    })
    val cast = clone(ast).get.asInstanceOf[T]
    copyPositions(ast, cast)
    cast
  }

  // cparser creates dead ast nodes that causes problems in the control flow analysis (grouping of ast nodes etc.)
  // the function removes dead nodes from the ast
  // see issue: https://github.com/ckaestne/TypeChef/issues/4
  @unused
  def removeDeadNodes[T <: Product](ast: T, env: ASTEnv): T = {
    assert(ast != null, "ast should not be null")

    val removedead = manytd(rule[Any] {
      case l: List[_] => l.filter({
        case x: Opt[_] => env.featureExpr(x).isSatisfiable
        case _ => true
      })
    })

    val cast = removedead(ast).get.asInstanceOf[T]
    copyPositions(ast, cast)
    cast
  }

  // function to add a break expression to infinite loops: "for (;;) {}" and "for (;;) ;"
  // reason is: for (;;) is the only infinite loop without explicit break statement,
  // so if we omit CompoundStatement in succ pred determination, we need an expression
  // so that succ(e) -> e and pred(e) is e
  // we add a Constant("1") at the break
  def rewriteInfiniteForLoops[T <: Product](ast: T): T = {
    assert(ast != null, "ast should not be null")

    val rewrite = everywherebu(rule[Product] {
      case f@ForStatement(_, None, _, _) =>
        f.copy(expr2 = Some(Constant("1")))
      case n: AST => n
    })

    val cast = rewrite(ast).get.asInstanceOf[T]
    copyPositions(ast, cast)
    cast
  }

  // filter AST nodes that do not have position information
  def getNodesWithoutPositionInformation[T <: Product](ast: T): List[AST] = {
    assert(ast != null, "ast should not be null")
    var nodeswithoutposition: List[AST] = List()

    val checkpos = everywherebu(query[Product] {
      case a: AST => if (!a.hasPosition) nodeswithoutposition ::= a
    })

    checkpos(ast)

    nodeswithoutposition
  }

  def checkPositionInformation(ast: Product): Unit = {
    val nodeswithoutposition: List[Product] = getNodesWithoutPositionInformation(ast)
    assert(nodeswithoutposition.size <= 1,
      "AST nodes with empty position information found (" + nodeswithoutposition.size + "): " +
        nodeswithoutposition.take(3).map(_.toString.take(200)).mkString("\n"))
  }

}