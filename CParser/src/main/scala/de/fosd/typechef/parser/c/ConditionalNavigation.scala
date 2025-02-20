package de.fosd.typechef.parser.c

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr.{FeatureExpr, FeatureExprFactory}
import org.bitbucket.inkytonik.kiama.rewriting.Rewriter._

trait ConditionalNavigation {
  def parentOpt(e: Product, env: ASTEnv): Opt[_] = {
    val eparent = env.parent(e)
    eparent match {
      case o: Opt[_] => o
      case c: Conditional[_] => c.toOptList.head
      case a: AST => parentOpt(a, env)
      case _ => null
    }
  }

  def prevOpt(e: Opt[_], env: ASTEnv): Opt[_] = {
    val eprev = env.previous(e)
    eprev match {
      case o: Opt[_] => o
      case _ => null
    }
  }

  def nextOpt(e: Opt[_], env: ASTEnv): Opt[_] = {
    val enext = env.next(e)
    enext match {
      case o: Opt[_] => o
      case _ => null
    }
  }

  // check recursively for any nodes that have an annotation != True
  def isVariable(e: Product): Boolean = {
    var res = false
    val variable = manytd(query[Product] {
      case Opt(f, _) => if (f != FeatureExprFactory.False && f != FeatureExprFactory.True) res = true
      case _ => res = res
    })

    variable(e)
    res
  }

  def filterAllOptElems(e: Product): List[Opt[_]] = {
    def filterAllOptElemsHelper(a: Any): List[Opt[_]] = {
      a match {
        case o@Opt(_, entry) => List(o) ++ (entry match {
          case product: Product => product.productIterator.toList.flatMap(filterAllOptElemsHelper)
          case _ => List()
        })
        case l: List[_] => l.flatMap(filterAllOptElemsHelper)
        case x: Product => x.productIterator.toList.flatMap(filterAllOptElemsHelper)
        case _ => List()
      }
    }

    filterAllOptElemsHelper(e)
  }

  def filterAllFeatureExpr(e: Product): List[FeatureExpr] = {
    def filterAllFeatureExprHelper(a: Any): List[FeatureExpr] = {
      a match {
        case Opt(feature, entry) => List(feature) ++ (entry match {
          case product: Product => product.productIterator.toList.flatMap(filterAllFeatureExprHelper)
          case _ => List()
        })
        case Choice(feature, thenBranch, elseBranch) => List(feature, feature.not()) ++
          thenBranch.asInstanceOf[Product].productIterator.toList.flatMap(filterAllFeatureExprHelper) ++
          elseBranch.asInstanceOf[Product].productIterator.toList.flatMap(filterAllFeatureExprHelper)
        case l: List[_] => l.flatMap(filterAllFeatureExprHelper)
        case x: Product => x.productIterator.toList.flatMap(filterAllFeatureExprHelper)
        case _ => List()
      }
    }

    filterAllFeatureExprHelper(e)
  }

  // return all Opt and One elements
  def filterAllVariableElems(e: Product): List[Product] = {
    var res: List[Product] = List()
    val filter = manytd(query[Product] {
      case o: Opt[_] => res ::= o
      case o: One[_] => res ::= o
    })

    filter(e)
    res
  }
}
