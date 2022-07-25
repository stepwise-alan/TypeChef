package de.fosd.typechef.parser.c

import de.fosd.typechef.conditional._
import de.fosd.typechef.featureexpr._
import de.fosd.typechef.parser._
import de.fosd.typechef.parser.c.PrettyPrinter._
import org.junit.Assert._
import org.junit.{Ignore, Test}

import java.util.Collections

class PrettyPrinterTest extends TestHelper {
  val p = new CParser()

  @Test def testPP(): Unit = {

    //        val sp=new StringPrinter()
    //
    //        val ast=new TranslationUnit(List())
    //
    //        println(PrettyPrinter.print(sp,ast))
    val f = FeatureExprFactory.True
    val doc = prettyPrint(EnumSpecifier(Some(Id("e")), Some(List(Opt(f, Enumerator(Id("test"), None)), Opt(f, Enumerator(Id("test2"), None))))))

    println(layout(doc))
  }

  @Test def testEnum(): Unit = parsePrintParse("enum e {  test,  test2}", p.enumSpecifier)

  @Test def testString(): Unit = parsePrintParse(""" "test" "b" """, p.stringConst)

  @Test def testConstant(): Unit = {
    def parseConstant(const: String): Unit = {
      parsePrintParse(const, p.numConst)
    }

    def parseString(const: String): Unit = {
      parsePrintParse(const, p.stringConst)
    }

    parseConstant("1")
    parseConstant("0xF")
    parseConstant("0X1A")
    parseConstant("0X1Al")
    parseConstant("0X1Au")
    parseConstant("0X1AU")
    parseConstant("0X1AL")
    parseConstant("01")
    parseConstant("1222223")
    parseConstant("1L")
    parseConstant("1U")
    parseConstant("1u")
    parseConstant("1l")
    parseConstant("1E32")
    parseConstant("1e32")
    parseConstant("1E+32")
    parseConstant("1E-32")
    parseConstant("1.1")
    parseConstant(".1")
    parseConstant("3.0f")
    parseConstant("3.0fi")
    parseConstant("3L")
    parseConstant("3U")
    parseConstant("3l")
    parseConstant("3I")
    parseConstant("3i")
    parseConstant("3j")
    parseConstant("3J")
    parseConstant(".1E2l")
    parseConstant("'a'")
    parseConstant("L'a'")
    parseString("L\"a\"")
    //        assertParseResult(Alt(fa, Constant("1"), Constant("2")), """|#ifdef a
    //        					|1
    //        					|#else
    //        					|2
    //        					|#endif""", List(p.primaryExpr, p.numConst))
  }

  @Test def testEnumerator(): Unit = {
    parsePrintParse("enum e", p.enumSpecifier)
    parsePrintParse("enum e { a }", p.enumSpecifier)
    parsePrintParse("enum e { a, }", p.enumSpecifier)
    parsePrintParse("enum { a }", p.enumSpecifier)
    parsePrintParse("enum e { a=1, b=3 }", p.enumSpecifier)
  }

  @Test def testParameterDecl(): Unit = {
    parsePrintParse("void", p.parameterDeclaration)
    parsePrintParse("extern void", p.parameterDeclaration)
    parsePrintParse("extern void", p.parameterDeclaration)
    parsePrintParse("void *", p.parameterDeclaration)
    parsePrintParse("void *[]", p.parameterDeclaration)
    parsePrintParse("void *[a]", p.parameterDeclaration)
    parsePrintParse("void *(*[])", p.parameterDeclaration)
    parsePrintParse("void *()", p.parameterDeclaration)
    parsePrintParse("void *(void, int)", p.parameterDeclaration)
    parsePrintParse("void ****(void, int)", p.parameterDeclaration)
    parsePrintParse("void ****a", p.parameterDeclaration)
  }

  @Test def testOptAndChoice(): Unit = {
    val c = Choice(FeatureExprFactory.createDefinedExternal("CONFIG_FEATURE_UDHCP_RFC3397"), One(CaseStatement(Id("OPTION_DNS_STRING"))), One(LabelStatement(Id("test"), None)))
    ppConditional(c, List())
  }

  @Test def testStatements(): Unit = {
    parsePrintParseCond("a;", p.statement)
    parsePrintParse("{}", p.compoundStatement)
    parsePrintParseCond("{}", p.statement)
    parsePrintParseCond("a(x->i);", p.statement)
    parsePrintParseCond("while (x) a;", p.statement)
    parsePrintParseCond(";", p.statement)
    parsePrintParseCond("if (a) b; ", p.statement)
    parsePrintParseCond("if (a) {b;c;} ", p.statement)
    parsePrintParseCond("if (a) b; else c;", p.statement)
    parsePrintParseCond("if (a) if (b) if (c) d; ", p.statement)
    parsePrintParseCond("{a;b;}", p.statement)
    //parsePrintParseCond("case a: x;", p.statement)
    parsePrintParseCond("break;", p.statement)
    parsePrintParseCond("a:", p.statement)
    parsePrintParseCond("goto x;", p.statement)
    //        assertParseResult(AltStatement(fa, IfStatement(a, ExprStatement(b), List(), None), ExprStatement(b)),
    //            """|#ifdef a
    //        					|if (a)
    //        					|#endif
    //    			  			|b;""", p.statement)
    //        assertParseResult(IfStatement(a, AltStatement(fa, ExprStatement(b), ExprStatement(c)), List(), None),
    //            """|if (a)
    //    			  			|#ifdef a
    //        					|b;
    //        					|#else
    //    			  			|c;
    //        					|#endif""", p.statement)
    //        assertParseAnyResult(CompoundStatement(List(
    //            Opt(fa, IfStatement(a, ExprStatement(b), List(), None)),
    //            Opt(fa, ExprStatement(c)),
    //            Opt(fa.not(), IfStatement(a, ExprStatement(c), List(), None)))),
    //            """|{
    //        		|if (a)
    //    			  			|#ifdef a
    //        					|b;
    //        					|#endif
    //    			  			|c;}""", p.statement)
    //
    //        assertParseAnyResult(CompoundStatement(List(o(ExprStatement(a)), Opt(fa, ExprStatement(b)), o(ExprStatement(c)))),
    //            """|{
    //        		|a;
    //    			  			|#ifdef a
    //        					|b;
    //        					|#endif
    //    			  			|c;}""", p.statement)
  }


  @Test def testStructOrUnion(): Unit = {
    parsePrintParse("struct a", p.structOrUnionSpecifier)
    parsePrintParse("union a", p.structOrUnionSpecifier)
    parsePrintParse("x ", p.structDeclarator)
    parsePrintParse("struct { void x; }", p.structOrUnionSpecifier)
    parsePrintParse("struct { void x,y; }", p.structOrUnionSpecifier)
    parsePrintParse("struct a{ void x; int x:3+2,z:3;}", p.structOrUnionSpecifier)
    parsePrintParse("struct {  }", p.structOrUnionSpecifier)
  }

  @Ignore("not working right now, investigate TODO")
  @Test def testAsmExpr(): Unit = {
    parsePrintParse("asm ( 3+3);", p.asm_expr)
    parsePrintParse("asm volatile ( 3+3);", p.asm_expr)
  }

  @Test def testFunctionDef(): Unit = {

    parsePrintParse("void foo(){}", p.functionDef)
    parsePrintParse("void foo(){a;}", p.functionDef)
    parsePrintParse("void foo(int a) { a; }", p.functionDef)
    //           parsePrintParse("""|void
    //                           |#ifdef X
    //                           |foo
    //                           |#else
    //                           |bar
    //                           |#endif
    //                           |(){}
    //                           |void x(){}""", p.translationUnit)
    parsePrintParse("main(){}", p.functionDef)
    parsePrintParse("main(){int T=100, a=(T)+1;}", p.functionDef)
    parsePrintParse(
      """
        main() {
          int a;
          #ifdef A
          if (a) {
            int b;
          }
          #endif
          int c;
        }
                         """, p.functionDef)
  }

  @Test def testTypedefName(): Unit = {
    parsePrintParse("int a;", p.translationUnit)
    parsePrintParse("typedef int foo; foo a;", p.translationUnit)
    parsePrintParse("__builtin_type a;", p.translationUnit)
    parsePrintParse("(notATypeName)", p.expr)
    parsePrintParse("(__builtin_type)", p.expr)
    parsePrintParse("3+(__builtin_type)", p.expr)
  }

  @Test def testAttribute(): Unit = {
    parsePrintParse("__attribute__((a b))", p.attributeDecl)
    parsePrintParse("__attribute__(())", p.attributeDecl)
    parsePrintParse("__attribute__((a,b))", p.attributeDecl)
    parsePrintParse("__attribute__((a,(b,b)))", p.attributeDecl)
  }

  @Test def testInitializer(): Unit = {
    parsePrintParse("a", p.initializer)
    parsePrintParse(".a = 3", p.initializer)
    parsePrintParse("a: 3", p.initializer)
    parsePrintParse("[3] = 3", p.initializer)
    parsePrintParse("{}", p.initializer)
    parsePrintParse("{3}", p.initializer)
    parsePrintParse("{3,4}", p.initializer)
    parsePrintParse("{{3},4}", p.initializer)
    parsePrintParse("{.l={{.r={.w={1},.m=2}}},.c=2}", p.initializer)
    parsePrintParse("{ .lock = { { .rlock = { .raw_lock = { 1 } } } } }", p.initializer)
    parsePrintParse("{ .lock = (int) { { .rlock = { .raw_lock = { 1 } } } } }", p.initializer)
    parsePrintParse("{ .lock = { { .rlock = { .raw_lock = { 1 } } } } }", p.initializer)
    parsePrintParse("{ .entry.mask = 1 }", p.initializer) //from io_apic.c
    parsePrintParse("{ [2].y = yv2, [2].x = xv2, [0].x = xv0 }", p.initializer) //from gcc spec
    parsePrintParse("{ [' '] = 1, ['\\t'] = 1, ['\\h'] = 1,\n           ['\\f'] = 1, ['\\n'] = 1, ['\\r'] = 1 }", p.initializer) //from gcc spec
    parsePrintParse("{ [1] = v1, v2, [4] = v4 }", p.initializer) //from gcc spec
    parsePrintParse("{ y: yvalue, x: xvalue }", p.initializer) //from gcc spec
    parsePrintParse("{ .y = yvalue, .x = xvalue }", p.initializer) //from gcc spec
    parsePrintParse("{ [0 ... 9] = 1, [10 ... 99] = 2, [100] = 3 }", p.initializer) //from gcc spec
    parsePrintParse("(int) { .lock = (int) { { .rlock = { .raw_lock = { 1 } } } } }", p.castExpr)
    parsePrintParse("(int) { .lock = (int) { { .rlock = { .raw_lock = { 1 } } } } }", p.expr)
    parsePrintParseCond("sem = (int) { .lock = (int) { { .rlock = { .raw_lock = { 1 } } } } };", p.statement)
  }

  @Test def testNAryExpr(): Unit = {
    parsePrintParse("a*b", p.multExpr)
    parsePrintParse("a*b*b", p.multExpr)
  }

  @Test def testExprs(): Unit = {
    parsePrintParse("a*b+c", p.expr)
    parsePrintParse("c+a*b", p.expr)
    parsePrintParse("(a+b)*c", p.expr)
    parsePrintParse("a=b==c", p.expr)
    parsePrintParse("a/b", p.expr)
    parsePrintParse("a?b:c", p.expr)
    parsePrintParse("2+(a?b:c)", p.expr)
    parsePrintParse("2+(a?(b+2):c)", p.expr)
    parsePrintParse("(2+2)+(a?(b+2):c)", p.expr)
    parsePrintParse("a,b,c+c/d|x", p.expr)
  }

  private def parsePrintParse(code: String, production: p.MultiParser[AST]): Unit = {
    parsePrintParseCond(code, production ^^ {
      One(_)
    })
  }

  private def parsePrintParseCond(code: String, production: p.MultiParser[Conditional[AST]]): Unit = {

    //parse
    val ast = parse(code, production)

    println("AST: " + ast.get)


    //pretty print
    val doc = prettyPrint(ast.get.asInstanceOf[One[AST]].value) //temporary workaround with typecast
    val printed = layout(doc)

    println("Pretty: " + printed)

    val ast2 = parse(printed, production)
    println("new AST: " + ast2.get)

    assertEquals("AST after parsing printed result is different\n" + printed, ast.get, ast2.get)
  }

  private def parseFile(filename: String): Unit = {
    val ast = _parseFile(filename)
    val doc = prettyPrint(ast)
    val printed = layout(doc)

    println("Pretty: " + printed)

    val ast2 = parse(printed, p.translationUnit)

    assertEquals("AST after parsing printed result is different\n" + printed, ast, ast2.get)
  }


  private def parse[T](code: String, production: (TokenReader[CToken, CTypeContext], FeatureExpr) => p.MultiParseResult[T]): Option[T] = {
    val actual = p.parse(lex(code.stripMargin), production)
    (actual: @unchecked) match {
      case p.Success(ast, unparsed) =>
        assertTrue("parser did not reach end of token stream: " + unparsed, unparsed.atEnd)
        Some(ast.asInstanceOf[T])
      case p.NoSuccess(msg, unparsed, inner) =>
        fail(msg + " at " + unparsed + " " + inner + "\nin " + code)
        None
    }
  }

  private def _parseFile(fileName: String): TranslationUnit = {
    val inputStream = getClass.getResourceAsStream("/" + fileName)
    assertNotNull("file not found " + fileName, inputStream)
    val result = p.phrase(p.translationUnit)(lexStream(inputStream, fileName, Collections.singletonList("testfiles/cgram/"), null), FeatureExprFactory.True)

    (result: @unchecked) match {
      case p.Success(ast, unparsed) =>
        assertTrue("parser did not reach end of token stream: " + unparsed, unparsed.atEnd)
        ast.asInstanceOf[TranslationUnit]
      case p.NoSuccess(msg, unparsed, inner) =>
        fail(msg + " at " + unparsed + " " + inner + "\nin " + fileName)
        null
    }
  }


  @Test def testDeclarations(): Unit = {
    def parsePrintParseDecl(str: String): Unit = parsePrintParse(str, p.translationUnit)

    parsePrintParseDecl("int a;")
    parsePrintParseDecl("signed int a;")
    parsePrintParseDecl("unsigned int a;")
    parsePrintParseDecl("unsigned char a;")
    parsePrintParseDecl("unsigned a;")
    parsePrintParseDecl("signed a;")
    parsePrintParseDecl("double a;")
    parsePrintParseDecl("long double a;")

    //allow also uncommon but correct notations
    parsePrintParseDecl("char a;")
    parsePrintParseDecl("signed char a;")
    parsePrintParseDecl("unsigned char a;")
    parsePrintParseDecl("short a;")
    parsePrintParseDecl("short int a;")
    parsePrintParseDecl("unsigned short a;")
    parsePrintParseDecl("int a;")
    parsePrintParseDecl("unsigned int a;")
    parsePrintParseDecl("long int a;")
    parsePrintParseDecl("unsigned long int a;")
    parsePrintParseDecl("long a;")
    parsePrintParseDecl("unsigned long a;")
    parsePrintParseDecl("long long int a;")
    parsePrintParseDecl("unsigned long long int a;")
    parsePrintParseDecl("long long a;")
    parsePrintParseDecl("unsigned long long a;")
    parsePrintParseDecl("float a;")
    parsePrintParseDecl("double a;")
    parsePrintParseDecl("long double a;")

    parsePrintParseDecl("int double a;")
    parsePrintParseDecl("signed unsigned char a;")
    parsePrintParseDecl("auto a;")

    parsePrintParseDecl("double a;")
    parsePrintParseDecl("double a,b;")
    parsePrintParseDecl("double a[];")
    parsePrintParseDecl("double **a;")
    parsePrintParseDecl("double *a[];")
    parsePrintParseDecl("double a[][];")
    parsePrintParseDecl("double *a[][];")
    parsePrintParseDecl("double (*a)[];")
    parsePrintParseDecl("double *(*a[1])();")

    parsePrintParseDecl("void main();")
    parsePrintParseDecl("double (*fp)();")
    parsePrintParseDecl("double *fp();")
    parsePrintParseDecl("void main(double a);")

    parsePrintParseDecl("void main(double*, double);")
    parsePrintParseDecl("void main(double*(), double);")
    parsePrintParseDecl("void main(double(*(*)())());")

    parsePrintParseDecl("struct { double a;} foo;")
    parsePrintParseDecl("struct a foo;")
    parsePrintParseDecl("struct a { double a;} foo;")
    parsePrintParseDecl("struct a;")
  }

  @Test def testVariableLists(): Unit = {
    parsePrintParse(
      """void foo(
                int a

                #ifdef B
                , int b
                #endif
                ) { }
                         """, p.functionDef)
    // TODO does not work yet, before and after AST are not equal!
    //        parsePrintParse("""void foo(
    //                #ifdef A
    //                int a
    //                #else
    //                double a
    //                #endif
    //                ) { }
    //                        """, p.functionDef)
    parsePrintParse(
      """void foo(
                int a

                #ifdef B
                , int b
                #else
                , double b
                #endif
                ) { }
                         """, p.translationUnit)
    parsePrintParse(
      """
                enum e {
                       ONE
                #ifdef A
                       , TWO
                       , THREE
                #endif
                }
                         """.stripMargin, p.enumSpecifier)
    parsePrintParse(
      """
                enum e {
                       ONE
                       , TWO
                #ifdef A
                       , THREE
                #endif
                }
                         """.stripMargin, p.enumSpecifier)
    parsePrintParse(
      """
                        int
                        #ifdef A
                        a
                        #else
                        b
                        #endif
                        ;
                         """.stripMargin, p.declaration)
  }


  @Test def test1(): Unit = {
    parseFile("cgram/test.c")
  }

  @Test def test2(): Unit = {
    parseFile("cgram/test2.c")
  }

  @Test def test3(): Unit = {
    parseFile("cgram/test3.c")
  }

  @Test def test4(): Unit = {
    parseFile("cgram/test4.c")
  }

  @Test def test5(): Unit = {
    parseFile("cgram/test5.c")
  }

  @Test def test6(): Unit = {
    parseFile("cgram/test6.c")
  }

  @Test def test7(): Unit = {
    parseFile("cgram/test7.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test8(): Unit = {
    parseFile("cgram/test8.c")
  }

  //scoped typedef
  @Test def test9(): Unit = {
    parseFile("cgram/test9.c")
  }

  @Test def test10(): Unit = {
    parseFile("cgram/test10.c")
  }

  @Test def test11(): Unit = {
    parseFile("cgram/test11.c")
  }

  @Test def test12(): Unit = {
    parseFile("cgram/test12.c")
  }

  @Test def test13(): Unit = {
    parseFile("cgram/test13.c")
  }

  @Test def test14(): Unit = {
    parseFile("cgram/test14.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test15(): Unit = {
    parseFile("cgram/test15.c")
  }

  @Test def test16(): Unit = {
    parseFile("cgram/test16.c")
  }

  @Test def test17(): Unit = {
    parseFile("cgram/test17.c")
  }

  @Test def test18(): Unit = {
    parseFile("cgram/test18.c")
  }

  @Test def test19(): Unit = {
    parseFile("cgram/test19.c")
  }

  @Test def test20(): Unit = {
    parseFile("cgram/test20.c")
  }

  @Test def test21(): Unit = {
    parseFile("cgram/test21.c")
  }

  @Test def test22(): Unit = {
    parseFile("cgram/test22.c")
  }

  @Test def test23(): Unit = {
    parseFile("cgram/test23.c")
  }

  @Test def test24(): Unit = {
    parseFile("cgram/test24.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test25(): Unit = {
    parseFile("cgram/test25.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test26(): Unit = {
    parseFile("cgram/test26.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test27(): Unit = {
    parseFile("cgram/test27.c")
  }

  @Test def test28(): Unit = {
    parseFile("cgram/test28.c")
  }

  @Test def test29(): Unit = {
    parseFile("cgram/test29.c")
  }

  @Test def test30(): Unit = {
    parseFile("cgram/test30.c")
  }

  @Test def test31(): Unit = {
    parseFile("cgram/test31.c")
  }

  @Test def test32(): Unit = {
    parseFile("cgram/test32.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test33(): Unit = {
    parseFile("cgram/test33.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test34(): Unit = {
    parseFile("cgram/test34.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test35(): Unit = {
    parseFile("cgram/test35.c")
  }

  @Test def test36(): Unit = {
    parseFile("cgram/test36.c")
  }

  @Test def test37(): Unit = {
    parseFile("cgram/test37.c")
  }

  @Test def test38(): Unit = {
    parseFile("cgram/test38.c")
  }

  @Test def test39(): Unit = {
    parseFile("cgram/test39.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test40(): Unit = {
    parseFile("cgram/test40.c")
  }

  @Test def test41(): Unit = {
    parseFile("cgram/test41.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test42(): Unit = {
    parseFile("cgram/test42.c")
  }

  //ignore variable and typedef with same name
  @Test def test43(): Unit = {
    parseFile("cgram/test43.c")
  }

  @Test def test44(): Unit = {
    parseFile("cgram/test44.c")
  }

  @Test def test45(): Unit = {
    parseFile("cgram/test45.c")
  }

  @Test def test46(): Unit = {
    parseFile("cgram/test46.c")
  }

  @Test def test47(): Unit = {
    parseFile("cgram/test47.c")
  }

  @Test def test48(): Unit = {
    parseFile("cgram/test48.c")
  }

  @Test def test49(): Unit = {
    parseFile("cgram/test49.c")
  }

  @Test def test50(): Unit = {
    parseFile("cgram/test50.c")
  }

  @Test def test51(): Unit = {
    parseFile("cgram/test51.c")
  }

  @Test def test52(): Unit = {
    parseFile("cgram/test52.c")
  }

  @Test def test53(): Unit = {
    parseFile("cgram/test53.c")
  }

  @Test def test54(): Unit = {
    parseFile("cgram/test54.c")
  }

  @Test def test55(): Unit = {
    parseFile("cgram/test55.c")
  }

  @Test def test56(): Unit = {
    parseFile("cgram/test56.c")
  }

  @Test def test57(): Unit = {
    parseFile("cgram/test57.c")
  }

  @Test def test58(): Unit = {
    parseFile("cgram/test58.c")
  }

  @Ignore("pretty printer incomplete, #5")
  @Test def test59(): Unit = {
    parseFile("cgram/test59.c")
  }

  @Test def test60(): Unit = {
    parseFile("cgram/test60.c")
  }

  @Test def test61(): Unit = {
    parseFile("cgram/test61.c")
  }

  @Test def test62(): Unit = {
    parseFile("cgram/test62.c")
  }

  @Test def test63(): Unit = {
    parseFile("cgram/test63.c")
  }

  @Test def test64(): Unit = {
    parseFile("cgram/test64.c")
  }

  @Test def test65(): Unit = {
    parseFile("cgram/test65.c")
  }

  @Test def test66(): Unit = {
    parseFile("cgram/test66.c")
  }

  @Test def test67(): Unit = {
    parseFile("cgram/test67.c")
  }

  @Test def test68(): Unit = {
    parseFile("cgram/test68.c")
  }

  @Test def test69(): Unit = {
    parseFile("cgram/test69.c")
  }

  @Test def test70(): Unit = {
    parseFile("cgram/test70.c")
  }

  @Test def test71(): Unit = {
    parseFile("cgram/test71.c")
  }

  @Test def test72(): Unit = {
    parseFile("cgram/test72.c")
  }

  @Test def test73(): Unit = {
    parseFile("cgram/test73.c")
  }

  @Test def test74(): Unit = {
    parseFile("cgram/test74.c")
  }

  @Test def test75(): Unit = {
    parseFile("cgram/test75.c")
  }

  @Test def test76(): Unit = {
    parseFile("cgram/test76.c")
  }

  @Test def test77(): Unit = {
    parseFile("cgram/test77.c")
  }

  @Test def test78(): Unit = {
    parseFile("cgram/test78.c")
  }

  @Test def test79(): Unit = {
    parseFile("cgram/test79.c")
  }

  @Test def test80(): Unit = {
    parseFile("cgram/test80.c")
  }

  @Test def test81(): Unit = {
    parseFile("cgram/test81.c")
  }

  @Test def test83(): Unit = {
    parseFile("cgram/test83.c")
  }

  @Test def test84(): Unit = {
    parseFile("cgram/test84.c")
  }

  @Test def test85(): Unit = {
    parseFile("cgram/test85.c")
  }

  @Test def test86(): Unit = {
    parseFile("cgram/test86.c")
  }

  @Test def test87(): Unit = {
    parseFile("cgram/test87.c")
  }

  @Test def testPacked(): Unit = {
    //problem by busybox, reported by Andreas Janker
    parseFile("other/packed.pi")
  }

}