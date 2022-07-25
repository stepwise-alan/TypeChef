package de.fosd.typechef.typesystem

import de.fosd.typechef.conditional.Conditional
import de.fosd.typechef.featureexpr.FeatureExpr
import de.fosd.typechef.parser.c.{AST, Expr, FunctionDef}

import java.util


trait CTypeCache extends CTypeSystemInterface {
  private val cacheExpr: util.IdentityHashMap[Expr, Conditional[CType]] = new util.IdentityHashMap()
  private val cacheFun: util.IdentityHashMap[FunctionDef, Conditional[CType]] = new util.IdentityHashMap()

  override protected def typedExpr(expr: Expr, ctype: Conditional[CType], featureExpr: FeatureExpr, env: Env): Unit = {
    cacheExpr.put(expr, ctype)
    super.typedExpr(expr, ctype, featureExpr, env)
  }

  override protected def typedFunction(fun: FunctionDef, ctype: Conditional[CType], featureExpr: FeatureExpr): Unit = {
    cacheFun.put(fun, ctype)
    super.typedFunction(fun, ctype, featureExpr)
  }

  def lookupExprType(expr: Expr): Conditional[CType] = cacheExpr.get(expr)

  def lookupFunType(fun: FunctionDef): Conditional[CType] = cacheFun.get(fun)

}


trait CEnvCache extends CTypeSystemInterface {
  private var cache: Map[AST, Env] = Map()

  override protected def addEnv(ast: AST, env: Env): Unit = {
    cache = cache + (ast -> env)
    super.addEnv(ast, env)
  }

  def lookupEnv(ast: AST): Env = cache(ast)
}

