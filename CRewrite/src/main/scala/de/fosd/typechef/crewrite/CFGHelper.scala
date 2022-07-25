package de.fosd.typechef.crewrite

import de.fosd.typechef.conditional.Opt
import de.fosd.typechef.parser.c.{AST, ASTEnv}

trait CFGHelper extends IntraCFG {

  // determine recursively all succs check
  def getAllSucc(i: AST, env: ASTEnv): List[(AST, CFG)] = {
    var r = List[(AST, CFG)]()
    var s = List(i)
    var d = List[AST]()
    var c: AST = null

    while (s.nonEmpty) {
      c = s.head
      s = s.drop(1)

      if (!d.exists(_.eq(c))) {
        r = (c, succ(c, env)) :: r
        s = s ++ r.head._2.map(x => x.entry)
        d = d ++ List(c)
      }
    }
    r
  }

  // determine recursively all pred
  def getAllPred(i: AST, env: ASTEnv): List[(AST, CFG)] = {
    var r = List[(AST, CFG)]()
    var s = List(i)
    var d = List[AST]()
    var c: AST = null

    while (s.nonEmpty) {
      c = s.head
      s = s.drop(1)

      if (!d.exists(_.eq(c))) {
        r = (c, pred(c, env)) :: r
        s = s ++ r.head._2.map(x => x.entry)
        d = d ++ List(c)
      }
    }
    r
  }
}
