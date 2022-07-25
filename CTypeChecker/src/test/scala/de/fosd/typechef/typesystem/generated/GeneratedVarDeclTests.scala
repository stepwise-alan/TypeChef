package de.fosd.typechef.typesystem.generated

import de.fosd.typechef.typesystem._
import org.junit._

/** generated tests! do not modify! */
class GeneratedVarDeclTests extends TestHelperTS {

  @Test def test_conf0(): Unit = {
    correct(
      """
              char x;
                """)
    correct(
      """
              void foo() { char x; }
                """)
    correct(
      """
              void foo(char x) {} 
                """)
    correct(
      """
              void foo(char x); 
                """)
    correct(
      """
              struct x { char x; };
                """)
  }


  @Test def test_conf1(): Unit = {
    correct(
      """
              signed char x;
                """)
    correct(
      """
              void foo() { signed char x; }
                """)
    correct(
      """
              void foo(signed char x) {} 
                """)
    correct(
      """
              void foo(signed char x); 
                """)
    correct(
      """
              struct x { signed char x; };
                """)
  }


  @Test def test_conf2(): Unit = {
    correct(
      """
              unsigned char x;
                """)
    correct(
      """
              void foo() { unsigned char x; }
                """)
    correct(
      """
              void foo(unsigned char x) {} 
                """)
    correct(
      """
              void foo(unsigned char x); 
                """)
    correct(
      """
              struct x { unsigned char x; };
                """)
  }


  @Test def test_conf3(): Unit = {
    correct(
      """
              unsigned int x;
                """)
    correct(
      """
              void foo() { unsigned int x; }
                """)
    correct(
      """
              void foo(unsigned int x) {} 
                """)
    correct(
      """
              void foo(unsigned int x); 
                """)
    correct(
      """
              struct x { unsigned int x; };
                """)
  }


  @Test def test_conf4(): Unit = {
    correct(
      """
              signed int x;
                """)
    correct(
      """
              void foo() { signed int x; }
                """)
    correct(
      """
              void foo(signed int x) {} 
                """)
    correct(
      """
              void foo(signed int x); 
                """)
    correct(
      """
              struct x { signed int x; };
                """)
  }


  @Test def test_conf5(): Unit = {
    correct(
      """
              long x;
                """)
    correct(
      """
              void foo() { long x; }
                """)
    correct(
      """
              void foo(long x) {} 
                """)
    correct(
      """
              void foo(long x); 
                """)
    correct(
      """
              struct x { long x; };
                """)
  }


  @Test def test_conf6(): Unit = {
    correct(
      """
              double x;
                """)
    correct(
      """
              void foo() { double x; }
                """)
    correct(
      """
              void foo(double x) {} 
                """)
    correct(
      """
              void foo(double x); 
                """)
    correct(
      """
              struct x { double x; };
                """)
  }


  @Test def test_conf7(): Unit = {
    correct(
      """
              int * x;
                """)
    correct(
      """
              void foo() { int * x; }
                """)
    correct(
      """
              void foo(int * x) {} 
                """)
    correct(
      """
              void foo(int * x); 
                """)
    correct(
      """
              struct x { int * x; };
                """)
  }


  @Test def test_conf8(): Unit = {
    correct(
      """
              char * x;
                """)
    correct(
      """
              void foo() { char * x; }
                """)
    correct(
      """
              void foo(char * x) {} 
                """)
    correct(
      """
              void foo(char * x); 
                """)
    correct(
      """
              struct x { char * x; };
                """)
  }


  @Test def test_conf9(): Unit = {
    correct(
      """
              signed char * x;
                """)
    correct(
      """
              void foo() { signed char * x; }
                """)
    correct(
      """
              void foo(signed char * x) {} 
                """)
    correct(
      """
              void foo(signed char * x); 
                """)
    correct(
      """
              struct x { signed char * x; };
                """)
  }


  @Test def test_conf10(): Unit = {
    correct(
      """
              unsigned char * x;
                """)
    correct(
      """
              void foo() { unsigned char * x; }
                """)
    correct(
      """
              void foo(unsigned char * x) {} 
                """)
    correct(
      """
              void foo(unsigned char * x); 
                """)
    correct(
      """
              struct x { unsigned char * x; };
                """)
  }


  @Test def test_conf11(): Unit = {
    correct(
      """
              char ** x;
                """)
    correct(
      """
              void foo() { char ** x; }
                """)
    correct(
      """
              void foo(char ** x) {} 
                """)
    correct(
      """
              void foo(char ** x); 
                """)
    correct(
      """
              struct x { char ** x; };
                """)
  }


  @Test def test_conf12(): Unit = {
    correct(
      """
              unsigned char ** x;
                """)
    correct(
      """
              void foo() { unsigned char ** x; }
                """)
    correct(
      """
              void foo(unsigned char ** x) {} 
                """)
    correct(
      """
              void foo(unsigned char ** x); 
                """)
    correct(
      """
              struct x { unsigned char ** x; };
                """)
  }


  @Test def test_conf13(): Unit = {
    correct(
      """
              signed char ** x;
                """)
    correct(
      """
              void foo() { signed char ** x; }
                """)
    correct(
      """
              void foo(signed char ** x) {} 
                """)
    correct(
      """
              void foo(signed char ** x); 
                """)
    correct(
      """
              struct x { signed char ** x; };
                """)
  }


  @Test def test_conf14(): Unit = {
    correct(
      """
              double * x;
                """)
    correct(
      """
              void foo() { double * x; }
                """)
    correct(
      """
              void foo(double * x) {} 
                """)
    correct(
      """
              void foo(double * x); 
                """)
    correct(
      """
              struct x { double * x; };
                """)
  }


  @Test def test_conf15(): Unit = {
    correct(
      """
              struct S { int x; int y; };

              struct S x;
                """)
    correct(
      """
              struct S { int x; int y; };

              void foo() { struct S x; }
                """)
    correct(
      """
              struct S { int x; int y; };

              void foo(struct S x) {} 
                """)
    correct(
      """
              struct S { int x; int y; };

              void foo(struct S x); 
                """)
    correct(
      """
              struct S { int x; int y; };

              struct x { struct S x; };
                """)
  }


  @Ignore("cannot distinguish origin of anonymous struct type")
  @Test def test_conf16(): Unit = {
    correct(
      """
              struct { float b; } x;
                """)
    correct(
      """
              void foo() { struct { float b; } x; }
                """)
    /* gcc reports:
test.c:1:31: warning: anonymous struct declared inside parameter list
           void foo(struct { float b; } x) {}
                           ^
test.c:1:31: warning: its scope is only this definition or declaration, which is probably not what you want

    */
    warning(
      """
              void foo(struct { float b; } x) {} 
                """)
    /* gcc reports:
test.c:1:31: warning: anonymous struct declared inside parameter list
           void foo(struct { float b; } x);
                           ^
test.c:1:31: warning: its scope is only this definition or declaration, which is probably not what you want

    */
    warning(
      """
              void foo(struct { float b; } x); 
                """)
    correct(
      """
              struct x { struct { float b; } x; };
                """)
  }


  @Test def test_conf17(): Unit = {
    correct(
      """
              volatile int x;
                """)
    correct(
      """
              void foo() { volatile int x; }
                """)
    correct(
      """
              void foo(volatile int x) {} 
                """)
    correct(
      """
              void foo(volatile int x); 
                """)
    correct(
      """
              struct x { volatile int x; };
                """)
  }


  @Test def test_conf18(): Unit = {
    correct(
      """
              const int x;
                """)
    correct(
      """
              void foo() { const int x; }
                """)
    correct(
      """
              void foo(const int x) {} 
                """)
    correct(
      """
              void foo(const int x); 
                """)
    correct(
      """
              struct x { const int x; };
                """)
  }


  @Test def test_conf19(): Unit = {
    correct(
      """
              const double x;
                """)
    correct(
      """
              void foo() { const double x; }
                """)
    correct(
      """
              void foo(const double x) {} 
                """)
    correct(
      """
              void foo(const double x); 
                """)
    correct(
      """
              struct x { const double x; };
                """)
  }


  @Test def test_conf20(): Unit = {
    correct(
      """
              volatile double x;
                """)
    correct(
      """
              void foo() { volatile double x; }
                """)
    correct(
      """
              void foo(volatile double x) {} 
                """)
    correct(
      """
              void foo(volatile double x); 
                """)
    correct(
      """
              struct x { volatile double x; };
                """)
  }


  @Test def test_conf21(): Unit = {
    correct(
      """
              int * x;
                """)
    correct(
      """
              void foo() { int * x; }
                """)
    correct(
      """
              void foo(int * x) {} 
                """)
    correct(
      """
              void foo(int * x); 
                """)
    correct(
      """
              struct x { int * x; };
                """)
  }


  @Test def test_conf22(): Unit = {
    correct(
      """
              const int * x;
                """)
    correct(
      """
              void foo() { const int * x; }
                """)
    correct(
      """
              void foo(const int * x) {} 
                """)
    correct(
      """
              void foo(const int * x); 
                """)
    correct(
      """
              struct x { const int * x; };
                """)
  }


  @Test def test_conf23(): Unit = {
    correct(
      """
              volatile int * x;
                """)
    correct(
      """
              void foo() { volatile int * x; }
                """)
    correct(
      """
              void foo(volatile int * x) {} 
                """)
    correct(
      """
              void foo(volatile int * x); 
                """)
    correct(
      """
              struct x { volatile int * x; };
                """)
  }


  @Test def test_conf24(): Unit = {
    /* gcc reports:
test.c:1:20: error: storage size of 'x' isn't known
           void x;
                ^

    */
    error(
      """
              void x;
                """)
    /* gcc reports:
test.c: In function 'foo':
test.c:1:33: error: variable or field 'x' declared void
           void foo() { void x; }
                             ^

    */
    error(
      """
              void foo() { void x; }
                """)
    /* gcc reports:
test.c:1:29: error: parameter 1 ('x') has incomplete type
           void foo(void x) {}
                         ^

    */
    error(
      """
              void foo(void x) {} 
                """)
    /* gcc reports:
test.c:1:29: warning: parameter 1 ('x') has void type
           void foo(void x);
                         ^

    */
    warning(
      """
              void foo(void x); 
                """)
    /* gcc reports:
test.c:1:31: error: variable or field 'x' declared void
           struct x { void x; };
                           ^

    */
    error(
      """
              struct x { void x; };
                """)
  }


}