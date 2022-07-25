package de.fosd.typechef.typesystem.generated

import de.fosd.typechef.typesystem._
import org.junit._

class GeneratedCoerceTests extends TestHelperTS {

  @Test def test_conf0_0(): Unit = {
    correct(
      """
              char foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf0_1(): Unit = {
    correct(
      """
              char foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf0_2(): Unit = {
    correct(
      """
              char foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf0_3(): Unit = {
    correct(
      """
              char foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf0_4(): Unit = {
    correct(
      """
              char foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf0_5(): Unit = {
    correct(
      """
              char foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf0_6(): Unit = {
    correct(
      """
              char foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf0_7(): Unit = {
    correct(
      """
              char foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf0_8(): Unit = {
    correct(
      """
              char foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf0_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              char foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf0_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 int ** b = foo();
                            ^

        */
    warning(
      """
              char foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf0_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 char * b = foo();
                            ^

        */
    warning(
      """
              char foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf0_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization makes pointer from integer without a cast
                 double * b = foo();
                              ^

        */
    warning(
      """
              char foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf0_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'char'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              char foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              char foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf0_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'char'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              char foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              char foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf0_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'char'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              char foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              char foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf0_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'char'
                 b = foo();
                   ^

        */
    error(
      """
              char foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              char foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf0_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'char'
                 b = foo();
                   ^

        */
    error(
      """
              char foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              char foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf0_18(): Unit = {
    correct(
      """
              char foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf0_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              char foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf0_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              char foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf0_21(): Unit = {
    correct(
      """
              char foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              char foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf0_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              char foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf0_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes pointer from integer without a cast
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              char foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf0_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization makes pointer from integer without a cast
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              char foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf1_0(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf1_1(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf1_2(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf1_3(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf1_4(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf1_5(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf1_6(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf1_7(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf1_8(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf1_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed char foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              signed char foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf1_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed char foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 int ** b = foo();
                            ^

        */
    warning(
      """
              signed char foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf1_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed char foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 char * b = foo();
                            ^

        */
    warning(
      """
              signed char foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf1_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed char foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization makes pointer from integer without a cast
                 double * b = foo();
                              ^

        */
    warning(
      """
              signed char foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf1_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'signed char'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              signed char foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              signed char foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf1_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'signed char'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              signed char foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              signed char foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf1_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'signed char'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              signed char foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              signed char foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf1_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'signed char'
                 b = foo();
                   ^

        */
    error(
      """
              signed char foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              signed char foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf1_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'signed char'
                 b = foo();
                   ^

        */
    error(
      """
              signed char foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              signed char foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf1_18(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf1_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              signed char foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf1_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              signed char foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf1_21(): Unit = {
    correct(
      """
              signed char foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              signed char foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf1_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed char foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              signed char foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf1_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed char foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes pointer from integer without a cast
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              signed char foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf1_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed char foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization makes pointer from integer without a cast
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              signed char foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf2_0(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf2_1(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf2_2(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf2_3(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf2_4(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf2_5(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf2_6(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf2_7(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf2_8(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf2_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf2_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 int ** b = foo();
                            ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf2_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 char * b = foo();
                            ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf2_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization makes pointer from integer without a cast
                 double * b = foo();
                              ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf2_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'unsigned char'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              unsigned char foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              unsigned char foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf2_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'unsigned char'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              unsigned char foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              unsigned char foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf2_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'unsigned char'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              unsigned char foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              unsigned char foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf2_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'unsigned char'
                 b = foo();
                   ^

        */
    error(
      """
              unsigned char foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              unsigned char foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf2_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'unsigned char'
                 b = foo();
                   ^

        */
    error(
      """
              unsigned char foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              unsigned char foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf2_18(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf2_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              unsigned char foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf2_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              unsigned char foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf2_21(): Unit = {
    correct(
      """
              unsigned char foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned char foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf2_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf2_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes pointer from integer without a cast
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf2_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization makes pointer from integer without a cast
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              unsigned char foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf3_0(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf3_1(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf3_2(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf3_3(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf3_4(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf3_5(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf3_6(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf3_7(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf3_8(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf3_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf3_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 int ** b = foo();
                            ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf3_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 char * b = foo();
                            ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf3_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization makes pointer from integer without a cast
                 double * b = foo();
                              ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf3_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'unsigned int'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              unsigned int foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              unsigned int foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf3_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'unsigned int'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              unsigned int foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              unsigned int foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf3_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'unsigned int'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              unsigned int foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              unsigned int foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf3_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'unsigned int'
                 b = foo();
                   ^

        */
    error(
      """
              unsigned int foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              unsigned int foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf3_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'unsigned int'
                 b = foo();
                   ^

        */
    error(
      """
              unsigned int foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              unsigned int foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf3_18(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf3_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              unsigned int foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf3_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              unsigned int foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf3_21(): Unit = {
    correct(
      """
              unsigned int foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              unsigned int foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf3_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf3_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes pointer from integer without a cast
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf3_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization makes pointer from integer without a cast
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              unsigned int foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf4_0(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf4_1(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf4_2(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf4_3(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf4_4(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf4_5(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf4_6(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf4_7(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf4_8(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf4_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed int foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              signed int foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf4_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed int foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 int ** b = foo();
                            ^

        */
    warning(
      """
              signed int foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf4_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed int foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 char * b = foo();
                            ^

        */
    warning(
      """
              signed int foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf4_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed int foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization makes pointer from integer without a cast
                 double * b = foo();
                              ^

        */
    warning(
      """
              signed int foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf4_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              signed int foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              signed int foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf4_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              signed int foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              signed int foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf4_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              signed int foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              signed int foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf4_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              signed int foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              signed int foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf4_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              signed int foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              signed int foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf4_18(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf4_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              signed int foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf4_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              signed int foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf4_21(): Unit = {
    correct(
      """
              signed int foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              signed int foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf4_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed int foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              signed int foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf4_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed int foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes pointer from integer without a cast
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              signed int foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf4_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              signed int foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization makes pointer from integer without a cast
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              signed int foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf5_0(): Unit = {
    correct(
      """
              long foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf5_1(): Unit = {
    correct(
      """
              long foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf5_2(): Unit = {
    correct(
      """
              long foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf5_3(): Unit = {
    correct(
      """
              long foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf5_4(): Unit = {
    correct(
      """
              long foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf5_5(): Unit = {
    correct(
      """
              long foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf5_6(): Unit = {
    correct(
      """
              long foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf5_7(): Unit = {
    correct(
      """
              long foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf5_8(): Unit = {
    correct(
      """
              long foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf5_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              long foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              long foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf5_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              long foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 int ** b = foo();
                            ^

        */
    warning(
      """
              long foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf5_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              long foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 char * b = foo();
                            ^

        */
    warning(
      """
              long foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf5_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              long foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization makes pointer from integer without a cast
                 double * b = foo();
                              ^

        */
    warning(
      """
              long foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf5_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'long int'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              long foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              long foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf5_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'long int'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              long foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              long foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf5_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'long int'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              long foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              long foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf5_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'long int'
                 b = foo();
                   ^

        */
    error(
      """
              long foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              long foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf5_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'long int'
                 b = foo();
                   ^

        */
    error(
      """
              long foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              long foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf5_18(): Unit = {
    correct(
      """
              long foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf5_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              long foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf5_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              long foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf5_21(): Unit = {
    correct(
      """
              long foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              long foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf5_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              long foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              long foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf5_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              long foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes pointer from integer without a cast
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              long foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf5_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              long foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization makes pointer from integer without a cast
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              long foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf6_0(): Unit = {
    correct(
      """
              float foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf6_1(): Unit = {
    correct(
      """
              float foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf6_2(): Unit = {
    correct(
      """
              float foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf6_3(): Unit = {
    correct(
      """
              float foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf6_4(): Unit = {
    correct(
      """
              float foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf6_5(): Unit = {
    correct(
      """
              float foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf6_6(): Unit = {
    correct(
      """
              float foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf6_7(): Unit = {
    correct(
      """
              float foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf6_8(): Unit = {
    correct(
      """
              float foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf6_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'float'
                 int * b = foo();
                           ^

        */
    error(
      """
              float foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf6_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int **' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'int **' using type 'float'
                 int ** b = foo();
                            ^

        */
    error(
      """
              float foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf6_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'char *' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'char *' using type 'float'
                 char * b = foo();
                            ^

        */
    error(
      """
              float foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf6_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double *' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: error: incompatible types when initializing type 'double *' using type 'float'
                 double * b = foo();
                              ^

        */
    error(
      """
              float foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf6_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              float foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              float foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf6_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              float foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              float foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf6_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              float foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              float foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf6_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              float foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf6_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              float foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf6_18(): Unit = {
    correct(
      """
              float foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf6_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf6_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf6_21(): Unit = {
    correct(
      """
              float foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              float foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf6_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'float'
                 int * b = foo();
                           ^

        */
    error(
      """
              float foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf6_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'const int *' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'const int *' using type 'float'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              float foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf6_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'volatile int *' from type 'float'
                 b = foo();
                   ^

        */
    error(
      """
              float foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: error: incompatible types when initializing type 'volatile int *' using type 'float'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              float foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf7_0(): Unit = {
    correct(
      """
              double foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf7_1(): Unit = {
    correct(
      """
              double foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf7_2(): Unit = {
    correct(
      """
              double foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf7_3(): Unit = {
    correct(
      """
              double foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf7_4(): Unit = {
    correct(
      """
              double foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf7_5(): Unit = {
    correct(
      """
              double foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf7_6(): Unit = {
    correct(
      """
              double foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf7_7(): Unit = {
    correct(
      """
              double foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf7_8(): Unit = {
    correct(
      """
              double foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf7_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'double'
                 int * b = foo();
                           ^

        */
    error(
      """
              double foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf7_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int **' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'int **' using type 'double'
                 int ** b = foo();
                            ^

        */
    error(
      """
              double foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf7_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'char *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'char *' using type 'double'
                 char * b = foo();
                            ^

        */
    error(
      """
              double foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf7_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: error: incompatible types when initializing type 'double *' using type 'double'
                 double * b = foo();
                              ^

        */
    error(
      """
              double foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf7_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              double foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              double foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf7_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              double foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              double foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf7_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              double foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              double foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf7_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              double foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf7_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              double foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf7_18(): Unit = {
    correct(
      """
              double foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf7_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf7_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf7_21(): Unit = {
    correct(
      """
              double foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              double foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf7_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'double'
                 int * b = foo();
                           ^

        */
    error(
      """
              double foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf7_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'const int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'const int *' using type 'double'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              double foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf7_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'volatile int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              double foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: error: incompatible types when initializing type 'volatile int *' using type 'double'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              double foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf8_0(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf8_1(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf8_2(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf8_3(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf8_4(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf8_5(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf8_6(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf8_7(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf8_8(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf8_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'long double'
                 int * b = foo();
                           ^

        */
    error(
      """
              long double foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf8_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int **' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'int **' using type 'long double'
                 int ** b = foo();
                            ^

        */
    error(
      """
              long double foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf8_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'char *' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'char *' using type 'long double'
                 char * b = foo();
                            ^

        */
    error(
      """
              long double foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf8_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double *' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: error: incompatible types when initializing type 'double *' using type 'long double'
                 double * b = foo();
                              ^

        */
    error(
      """
              long double foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf8_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              long double foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              long double foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf8_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              long double foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              long double foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf8_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              long double foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              long double foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf8_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              long double foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf8_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              long double foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf8_18(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf8_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf8_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf8_21(): Unit = {
    correct(
      """
              long double foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              long double foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf8_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'long double'
                 int * b = foo();
                           ^

        */
    error(
      """
              long double foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf8_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'const int *' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'const int *' using type 'long double'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              long double foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf8_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'volatile int *' from type 'long double'
                 b = foo();
                   ^

        */
    error(
      """
              long double foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: error: incompatible types when initializing type 'volatile int *' using type 'long double'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              long double foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf9_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 char b = foo();
                          ^

        */
    warning(
      """
              int * foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf9_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes integer from pointer without a cast
                 signed char b = foo();
                                 ^

        */
    warning(
      """
              int * foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf9_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:35: warning: initialization makes integer from pointer without a cast
                 unsigned char b = foo();
                                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf9_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 unsigned int b = foo();
                                  ^

        */
    warning(
      """
              int * foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf9_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:32: warning: initialization makes integer from pointer without a cast
                 signed int b = foo();
                                ^

        */
    warning(
      """
              int * foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf9_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 long b = foo();
                          ^

        */
    warning(
      """
              int * foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf9_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'float' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'float' using type 'int *'
                 float b = foo();
                           ^

        */
    error(
      """
              int * foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf9_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'double' using type 'int *'
                 double b = foo();
                            ^

        */
    error(
      """
              int * foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf9_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long double' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'long double' using type 'int *'
                 long double b = foo();
                                 ^

        */
    error(
      """
              int * foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf9_9(): Unit = {
    correct(
      """
              int * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    correct(
      """
              int * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf9_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 int ** b = foo();
                            ^

        */
    warning(
      """
              int * foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf9_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 char * b = foo();
                            ^

        */
    warning(
      """
              int * foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf9_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization from incompatible pointer type
                 double * b = foo();
                              ^

        */
    warning(
      """
              int * foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf9_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              int * foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              int * foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf9_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              int * foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              int * foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf9_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              int * foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              int * foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf9_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              int * foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf9_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              int * foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf9_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 volatile int b = foo();
                                  ^

        */
    warning(
      """
              int * foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf9_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:31: warning: initialization makes integer from pointer without a cast
                 const int b = foo();
                               ^

        */
    warning(
      """
              int * foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf9_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'double' using type 'int *'
                 const double b = foo();
                                  ^

        */
    error(
      """
              int * foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf9_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:37: error: incompatible types when initializing type 'double' using type 'int *'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              int * foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf9_22(): Unit = {
    correct(
      """
              int * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    correct(
      """
              int * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf9_23(): Unit = {
    correct(
      """
              int * foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    correct(
      """
              int * foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf9_24(): Unit = {
    correct(
      """
              int * foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    correct(
      """
              int * foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf10_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 char b = foo();
                          ^

        */
    warning(
      """
              int ** foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf10_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes integer from pointer without a cast
                 signed char b = foo();
                                 ^

        */
    warning(
      """
              int ** foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf10_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:35: warning: initialization makes integer from pointer without a cast
                 unsigned char b = foo();
                                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf10_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 unsigned int b = foo();
                                  ^

        */
    warning(
      """
              int ** foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf10_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:32: warning: initialization makes integer from pointer without a cast
                 signed int b = foo();
                                ^

        */
    warning(
      """
              int ** foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf10_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 long b = foo();
                          ^

        */
    warning(
      """
              int ** foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf10_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'float' from type 'int **'
                 b = foo();
                   ^

        */
    error(
      """
              int ** foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'float' using type 'int **'
                 float b = foo();
                           ^

        */
    error(
      """
              int ** foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf10_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'int **'
                 b = foo();
                   ^

        */
    error(
      """
              int ** foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'double' using type 'int **'
                 double b = foo();
                            ^

        */
    error(
      """
              int ** foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf10_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long double' from type 'int **'
                 b = foo();
                   ^

        */
    error(
      """
              int ** foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'long double' using type 'int **'
                 long double b = foo();
                                 ^

        */
    error(
      """
              int ** foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf10_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization from incompatible pointer type
                 int * b = foo();
                           ^

        */
    warning(
      """
              int ** foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf10_10(): Unit = {
    correct(
      """
              int ** foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    correct(
      """
              int ** foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf10_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 char * b = foo();
                            ^

        */
    warning(
      """
              int ** foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf10_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization from incompatible pointer type
                 double * b = foo();
                              ^

        */
    warning(
      """
              int ** foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf10_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'int **'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              int ** foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              int ** foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf10_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'int **'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              int ** foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              int ** foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf10_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'int **'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              int ** foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              int ** foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf10_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int **'
                 b = foo();
                   ^

        */
    error(
      """
              int ** foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              int ** foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf10_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int **'
                 b = foo();
                   ^

        */
    error(
      """
              int ** foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              int ** foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf10_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 volatile int b = foo();
                                  ^

        */
    warning(
      """
              int ** foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf10_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              int ** foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:31: warning: initialization makes integer from pointer without a cast
                 const int b = foo();
                               ^

        */
    warning(
      """
              int ** foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf10_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              int ** foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'double' using type 'int **'
                 const double b = foo();
                                  ^

        */
    error(
      """
              int ** foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf10_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'int **'
                 b = foo();
                   ^

        */
    error(
      """
              int ** foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:37: error: incompatible types when initializing type 'double' using type 'int **'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              int ** foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf10_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization from incompatible pointer type
                 int * b = foo();
                           ^

        */
    warning(
      """
              int ** foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf10_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization from incompatible pointer type
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              int ** foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf10_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int ** foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization from incompatible pointer type
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              int ** foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf11_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 char b = foo();
                          ^

        */
    warning(
      """
              char * foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf11_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes integer from pointer without a cast
                 signed char b = foo();
                                 ^

        */
    warning(
      """
              char * foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf11_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:35: warning: initialization makes integer from pointer without a cast
                 unsigned char b = foo();
                                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf11_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 unsigned int b = foo();
                                  ^

        */
    warning(
      """
              char * foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf11_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:32: warning: initialization makes integer from pointer without a cast
                 signed int b = foo();
                                ^

        */
    warning(
      """
              char * foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf11_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 long b = foo();
                          ^

        */
    warning(
      """
              char * foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf11_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'float' from type 'char *'
                 b = foo();
                   ^

        */
    error(
      """
              char * foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'float' using type 'char *'
                 float b = foo();
                           ^

        */
    error(
      """
              char * foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf11_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'char *'
                 b = foo();
                   ^

        */
    error(
      """
              char * foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'double' using type 'char *'
                 double b = foo();
                            ^

        */
    error(
      """
              char * foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf11_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long double' from type 'char *'
                 b = foo();
                   ^

        */
    error(
      """
              char * foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'long double' using type 'char *'
                 long double b = foo();
                                 ^

        */
    error(
      """
              char * foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf11_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization from incompatible pointer type
                 int * b = foo();
                           ^

        */
    warning(
      """
              char * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf11_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 int ** b = foo();
                            ^

        */
    warning(
      """
              char * foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf11_11(): Unit = {
    correct(
      """
              char * foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    correct(
      """
              char * foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf11_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization from incompatible pointer type
                 double * b = foo();
                              ^

        */
    warning(
      """
              char * foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf11_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'char *'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              char * foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              char * foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf11_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'char *'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              char * foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              char * foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf11_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'char *'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              char * foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              char * foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf11_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'char *'
                 b = foo();
                   ^

        */
    error(
      """
              char * foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              char * foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf11_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'char *'
                 b = foo();
                   ^

        */
    error(
      """
              char * foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              char * foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf11_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 volatile int b = foo();
                                  ^

        */
    warning(
      """
              char * foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf11_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              char * foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:31: warning: initialization makes integer from pointer without a cast
                 const int b = foo();
                               ^

        */
    warning(
      """
              char * foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf11_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              char * foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'double' using type 'char *'
                 const double b = foo();
                                  ^

        */
    error(
      """
              char * foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf11_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'char *'
                 b = foo();
                   ^

        */
    error(
      """
              char * foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:37: error: incompatible types when initializing type 'double' using type 'char *'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              char * foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf11_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization from incompatible pointer type
                 int * b = foo();
                           ^

        */
    warning(
      """
              char * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf11_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization from incompatible pointer type
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              char * foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf11_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              char * foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization from incompatible pointer type
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              char * foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf12_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 char b = foo();
                          ^

        */
    warning(
      """
              double * foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf12_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes integer from pointer without a cast
                 signed char b = foo();
                                 ^

        */
    warning(
      """
              double * foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf12_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:35: warning: initialization makes integer from pointer without a cast
                 unsigned char b = foo();
                                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf12_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 unsigned int b = foo();
                                  ^

        */
    warning(
      """
              double * foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf12_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:32: warning: initialization makes integer from pointer without a cast
                 signed int b = foo();
                                ^

        */
    warning(
      """
              double * foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf12_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 long b = foo();
                          ^

        */
    warning(
      """
              double * foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf12_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'float' from type 'double *'
                 b = foo();
                   ^

        */
    error(
      """
              double * foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'float' using type 'double *'
                 float b = foo();
                           ^

        */
    error(
      """
              double * foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf12_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'double *'
                 b = foo();
                   ^

        */
    error(
      """
              double * foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'double' using type 'double *'
                 double b = foo();
                            ^

        */
    error(
      """
              double * foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf12_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long double' from type 'double *'
                 b = foo();
                   ^

        */
    error(
      """
              double * foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'long double' using type 'double *'
                 long double b = foo();
                                 ^

        */
    error(
      """
              double * foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf12_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization from incompatible pointer type
                 int * b = foo();
                           ^

        */
    warning(
      """
              double * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf12_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 int ** b = foo();
                            ^

        */
    warning(
      """
              double * foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf12_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 char * b = foo();
                            ^

        */
    warning(
      """
              double * foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf12_12(): Unit = {
    correct(
      """
              double * foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    correct(
      """
              double * foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf12_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'double *'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              double * foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              double * foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf12_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'double *'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              double * foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              double * foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf12_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'double *'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              double * foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              double * foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf12_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'double *'
                 b = foo();
                   ^

        */
    error(
      """
              double * foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              double * foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf12_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'double *'
                 b = foo();
                   ^

        */
    error(
      """
              double * foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              double * foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf12_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 volatile int b = foo();
                                  ^

        */
    warning(
      """
              double * foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf12_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              double * foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:31: warning: initialization makes integer from pointer without a cast
                 const int b = foo();
                               ^

        */
    warning(
      """
              double * foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf12_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              double * foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'double' using type 'double *'
                 const double b = foo();
                                  ^

        */
    error(
      """
              double * foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf12_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'double *'
                 b = foo();
                   ^

        */
    error(
      """
              double * foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:37: error: incompatible types when initializing type 'double' using type 'double *'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              double * foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf12_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization from incompatible pointer type
                 int * b = foo();
                           ^

        */
    warning(
      """
              double * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf12_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization from incompatible pointer type
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              double * foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf12_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              double * foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization from incompatible pointer type
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              double * foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf13_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'char' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:26: error: incompatible types when initializing type 'char' using type 'struct S'
                 char b = foo();
                          ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf13_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'signed char' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:33: error: incompatible types when initializing type 'signed char' using type 'struct S'
                 signed char b = foo();
                                 ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf13_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'unsigned char' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:35: error: incompatible types when initializing type 'unsigned char' using type 'struct S'
                 unsigned char b = foo();
                                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf13_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'unsigned int' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:34: error: incompatible types when initializing type 'unsigned int' using type 'struct S'
                 unsigned int b = foo();
                                  ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf13_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:32: error: incompatible types when initializing type 'int' using type 'struct S'
                 signed int b = foo();
                                ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf13_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'long int' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:26: error: incompatible types when initializing type 'long int' using type 'struct S'
                 long b = foo();
                          ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf13_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'float' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:27: error: incompatible types when initializing type 'float' using type 'struct S'
                 float b = foo();
                           ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf13_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'double' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:28: error: incompatible types when initializing type 'double' using type 'struct S'
                 double b = foo();
                            ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf13_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'long double' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:33: error: incompatible types when initializing type 'long double' using type 'struct S'
                 long double b = foo();
                                 ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf13_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int *' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:27: error: incompatible types when initializing type 'int *' using type 'struct S'
                 int * b = foo();
                           ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf13_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int **' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:28: error: incompatible types when initializing type 'int **' using type 'struct S'
                 int ** b = foo();
                            ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf13_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'char *' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:28: error: incompatible types when initializing type 'char *' using type 'struct S'
                 char * b = foo();
                            ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf13_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'double *' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:30: error: incompatible types when initializing type 'double *' using type 'struct S'
                 double * b = foo();
                              ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf13_13(): Unit = {
    correct(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    correct(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf13_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:8:19: error: incompatible types when assigning to type 'struct T' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:7:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf13_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:8:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:7:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf13_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf13_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf13_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:34: error: incompatible types when initializing type 'int' using type 'struct S'
                 volatile int b = foo();
                                  ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf13_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:31: error: incompatible types when initializing type 'int' using type 'struct S'
                 const int b = foo();
                               ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf13_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:34: error: incompatible types when initializing type 'double' using type 'struct S'
                 const double b = foo();
                                  ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf13_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'double' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:37: error: incompatible types when initializing type 'double' using type 'struct S'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf13_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int *' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:27: error: incompatible types when initializing type 'int *' using type 'struct S'
                 int * b = foo();
                           ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf13_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'const int *' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:33: error: incompatible types when initializing type 'const int *' using type 'struct S'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf13_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'volatile int *' from type 'struct S'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:36: error: incompatible types when initializing type 'volatile int *' using type 'struct S'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              struct S { int x; int y; };

              struct S foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf14_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'char' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:26: error: incompatible types when initializing type 'char' using type 'struct T'
                 char b = foo();
                          ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf14_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'signed char' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:33: error: incompatible types when initializing type 'signed char' using type 'struct T'
                 signed char b = foo();
                                 ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf14_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'unsigned char' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:35: error: incompatible types when initializing type 'unsigned char' using type 'struct T'
                 unsigned char b = foo();
                                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf14_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'unsigned int' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:34: error: incompatible types when initializing type 'unsigned int' using type 'struct T'
                 unsigned int b = foo();
                                  ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf14_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:32: error: incompatible types when initializing type 'int' using type 'struct T'
                 signed int b = foo();
                                ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf14_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'long int' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:26: error: incompatible types when initializing type 'long int' using type 'struct T'
                 long b = foo();
                          ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf14_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'float' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:27: error: incompatible types when initializing type 'float' using type 'struct T'
                 float b = foo();
                           ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf14_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'double' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:28: error: incompatible types when initializing type 'double' using type 'struct T'
                 double b = foo();
                            ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf14_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'long double' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:33: error: incompatible types when initializing type 'long double' using type 'struct T'
                 long double b = foo();
                                 ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf14_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int *' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:27: error: incompatible types when initializing type 'int *' using type 'struct T'
                 int * b = foo();
                           ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf14_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int **' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:28: error: incompatible types when initializing type 'int **' using type 'struct T'
                 int ** b = foo();
                            ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf14_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'char *' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:28: error: incompatible types when initializing type 'char *' using type 'struct T'
                 char * b = foo();
                            ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf14_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'double *' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:30: error: incompatible types when initializing type 'double *' using type 'struct T'
                 double * b = foo();
                              ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf14_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:8:19: error: incompatible types when assigning to type 'struct S' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct S { int x; int y; };

              struct T foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:7:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct S { int x; int y; };

              struct T foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf14_14(): Unit = {
    correct(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    correct(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf14_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:8:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:7:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf14_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf14_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf14_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:34: error: incompatible types when initializing type 'int' using type 'struct T'
                 volatile int b = foo();
                                  ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf14_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:31: error: incompatible types when initializing type 'int' using type 'struct T'
                 const int b = foo();
                               ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf14_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:34: error: incompatible types when initializing type 'double' using type 'struct T'
                 const double b = foo();
                                  ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf14_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'double' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:37: error: incompatible types when initializing type 'double' using type 'struct T'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf14_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int *' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:27: error: incompatible types when initializing type 'int *' using type 'struct T'
                 int * b = foo();
                           ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf14_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'const int *' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:33: error: incompatible types when initializing type 'const int *' using type 'struct T'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf14_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'volatile int *' from type 'struct T'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:36: error: incompatible types when initializing type 'volatile int *' using type 'struct T'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct T foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf15_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'char' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:26: error: incompatible types when initializing type 'char' using type 'struct_anonymous'
                 char b = foo();
                          ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf15_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'signed char' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:33: error: incompatible types when initializing type 'signed char' using type 'struct_anonymous'
                 signed char b = foo();
                                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf15_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'unsigned char' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:35: error: incompatible types when initializing type 'unsigned char' using type 'struct_anonymous'
                 unsigned char b = foo();
                                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf15_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'unsigned int' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:34: error: incompatible types when initializing type 'unsigned int' using type 'struct_anonymous'
                 unsigned int b = foo();
                                  ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf15_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:32: error: incompatible types when initializing type 'int' using type 'struct_anonymous'
                 signed int b = foo();
                                ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf15_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'long int' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:26: error: incompatible types when initializing type 'long int' using type 'struct_anonymous'
                 long b = foo();
                          ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf15_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'float' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:27: error: incompatible types when initializing type 'float' using type 'struct_anonymous'
                 float b = foo();
                           ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf15_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'double' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:28: error: incompatible types when initializing type 'double' using type 'struct_anonymous'
                 double b = foo();
                            ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf15_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'long double' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:33: error: incompatible types when initializing type 'long double' using type 'struct_anonymous'
                 long double b = foo();
                                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf15_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int *' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:27: error: incompatible types when initializing type 'int *' using type 'struct_anonymous'
                 int * b = foo();
                           ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf15_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int **' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:28: error: incompatible types when initializing type 'int **' using type 'struct_anonymous'
                 int ** b = foo();
                            ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf15_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'char *' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:28: error: incompatible types when initializing type 'char *' using type 'struct_anonymous'
                 char * b = foo();
                            ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf15_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'double *' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:30: error: incompatible types when initializing type 'double *' using type 'struct_anonymous'
                 double * b = foo();
                              ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf15_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:8:19: error: incompatible types when assigning to type 'struct S' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct S { int x; int y; };

              struct_anonymous foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:7:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct S { int x; int y; };

              struct_anonymous foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf15_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:8:19: error: incompatible types when assigning to type 'struct T' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct T { int x; int y; int z; };

              struct_anonymous foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:7:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct T { int x; int y; int z; };

              struct_anonymous foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf15_15(): Unit = {
    correct(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    correct(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf15_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf15_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf15_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:34: error: incompatible types when initializing type 'int' using type 'struct_anonymous'
                 volatile int b = foo();
                                  ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf15_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:31: error: incompatible types when initializing type 'int' using type 'struct_anonymous'
                 const int b = foo();
                               ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf15_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:34: error: incompatible types when initializing type 'double' using type 'struct_anonymous'
                 const double b = foo();
                                  ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf15_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'double' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:37: error: incompatible types when initializing type 'double' using type 'struct_anonymous'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf15_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'int *' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:27: error: incompatible types when initializing type 'int *' using type 'struct_anonymous'
                 int * b = foo();
                           ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf15_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'const int *' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:33: error: incompatible types when initializing type 'const int *' using type 'struct_anonymous'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf15_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'volatile int *' from type 'struct_anonymous'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:36: error: incompatible types when initializing type 'volatile int *' using type 'struct_anonymous'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct_anonymous foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf16_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'char' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: error: incompatible types when initializing type 'char' using type 'struct <anonymous>'
                 char b = foo();
                          ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf16_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'signed char' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'signed char' using type 'struct <anonymous>'
                 signed char b = foo();
                                 ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf16_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'unsigned char' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:35: error: incompatible types when initializing type 'unsigned char' using type 'struct <anonymous>'
                 unsigned char b = foo();
                                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf16_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'unsigned int' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'unsigned int' using type 'struct <anonymous>'
                 unsigned int b = foo();
                                  ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf16_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:32: error: incompatible types when initializing type 'int' using type 'struct <anonymous>'
                 signed int b = foo();
                                ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf16_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long int' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: error: incompatible types when initializing type 'long int' using type 'struct <anonymous>'
                 long b = foo();
                          ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf16_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'float' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'float' using type 'struct <anonymous>'
                 float b = foo();
                           ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf16_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'double' using type 'struct <anonymous>'
                 double b = foo();
                            ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf16_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long double' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'long double' using type 'struct <anonymous>'
                 long double b = foo();
                                 ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf16_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'struct <anonymous>'
                 int * b = foo();
                           ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf16_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int **' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'int **' using type 'struct <anonymous>'
                 int ** b = foo();
                            ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf16_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'char *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'char *' using type 'struct <anonymous>'
                 char * b = foo();
                            ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf16_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: error: incompatible types when initializing type 'double *' using type 'struct <anonymous>'
                 double * b = foo();
                              ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf16_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct { int a; } foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              struct { int a; } foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf16_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct { int a; } foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct { int a; } foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf16_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct { int a; } foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct { int a; } foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf16_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf16_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf16_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'int' using type 'struct <anonymous>'
                 volatile int b = foo();
                                  ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf16_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:31: error: incompatible types when initializing type 'int' using type 'struct <anonymous>'
                 const int b = foo();
                               ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf16_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'double' using type 'struct <anonymous>'
                 const double b = foo();
                                  ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf16_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:37: error: incompatible types when initializing type 'double' using type 'struct <anonymous>'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf16_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'struct <anonymous>'
                 int * b = foo();
                           ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf16_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'const int *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'const int *' using type 'struct <anonymous>'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf16_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'volatile int *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: error: incompatible types when initializing type 'volatile int *' using type 'struct <anonymous>'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              struct { int a; } foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf17_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'char' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: error: incompatible types when initializing type 'char' using type 'struct <anonymous>'
                 char b = foo();
                          ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf17_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'signed char' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'signed char' using type 'struct <anonymous>'
                 signed char b = foo();
                                 ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf17_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'unsigned char' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:35: error: incompatible types when initializing type 'unsigned char' using type 'struct <anonymous>'
                 unsigned char b = foo();
                                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf17_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'unsigned int' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'unsigned int' using type 'struct <anonymous>'
                 unsigned int b = foo();
                                  ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf17_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:32: error: incompatible types when initializing type 'int' using type 'struct <anonymous>'
                 signed int b = foo();
                                ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf17_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long int' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: error: incompatible types when initializing type 'long int' using type 'struct <anonymous>'
                 long b = foo();
                          ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf17_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'float' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'float' using type 'struct <anonymous>'
                 float b = foo();
                           ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf17_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'double' using type 'struct <anonymous>'
                 double b = foo();
                            ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf17_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long double' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'long double' using type 'struct <anonymous>'
                 long double b = foo();
                                 ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf17_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'struct <anonymous>'
                 int * b = foo();
                           ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf17_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int **' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'int **' using type 'struct <anonymous>'
                 int ** b = foo();
                            ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf17_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'char *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'char *' using type 'struct <anonymous>'
                 char * b = foo();
                            ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf17_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: error: incompatible types when initializing type 'double *' using type 'struct <anonymous>'
                 double * b = foo();
                              ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf17_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              struct { float b; } foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              struct { float b; } foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf17_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct { float b; } foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              struct { float b; } foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf17_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct { float b; } foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              struct { float b; } foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf17_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf17_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf17_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'int' using type 'struct <anonymous>'
                 volatile int b = foo();
                                  ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf17_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:31: error: incompatible types when initializing type 'int' using type 'struct <anonymous>'
                 const int b = foo();
                               ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf17_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'double' using type 'struct <anonymous>'
                 const double b = foo();
                                  ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf17_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:37: error: incompatible types when initializing type 'double' using type 'struct <anonymous>'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf17_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'struct <anonymous>'
                 int * b = foo();
                           ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf17_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'const int *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'const int *' using type 'struct <anonymous>'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf17_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'volatile int *' from type 'struct <anonymous>'
                 b = foo();
                   ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: error: incompatible types when initializing type 'volatile int *' using type 'struct <anonymous>'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              struct { float b; } foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf18_0(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf18_1(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf18_2(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf18_3(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf18_4(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf18_5(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf18_6(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf18_7(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf18_8(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf18_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf18_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 int ** b = foo();
                            ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf18_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 char * b = foo();
                            ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf18_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization makes pointer from integer without a cast
                 double * b = foo();
                              ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf18_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              volatile int foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              volatile int foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf18_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              volatile int foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              volatile int foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf18_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              volatile int foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              volatile int foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf18_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              volatile int foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf18_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              volatile int foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf18_18(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf18_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf18_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf18_21(): Unit = {
    correct(
      """
              volatile int foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf18_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf18_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes pointer from integer without a cast
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf18_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization makes pointer from integer without a cast
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              volatile int foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf19_0(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf19_1(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf19_2(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf19_3(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf19_4(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf19_5(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf19_6(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf19_7(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf19_8(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf19_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              const int foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf19_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 int ** b = foo();
                            ^

        */
    warning(
      """
              const int foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf19_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization makes pointer from integer without a cast
                 char * b = foo();
                            ^

        */
    warning(
      """
              const int foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf19_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization makes pointer from integer without a cast
                 double * b = foo();
                              ^

        */
    warning(
      """
              const int foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf19_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              const int foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              const int foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf19_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              const int foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              const int foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf19_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              const int foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              const int foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf19_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              const int foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              const int foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf19_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int'
                 b = foo();
                   ^

        */
    error(
      """
              const int foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              const int foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf19_18(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf19_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              const int foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf19_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              const int foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf19_21(): Unit = {
    correct(
      """
              const int foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              const int foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf19_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization makes pointer from integer without a cast
                 int * b = foo();
                           ^

        */
    warning(
      """
              const int foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf19_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes pointer from integer without a cast
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              const int foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf19_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes pointer from integer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization makes pointer from integer without a cast
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              const int foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf20_0(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf20_1(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf20_2(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf20_3(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf20_4(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf20_5(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf20_6(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf20_7(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf20_8(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf20_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'double'
                 int * b = foo();
                           ^

        */
    error(
      """
              const double foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf20_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int **' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'int **' using type 'double'
                 int ** b = foo();
                            ^

        */
    error(
      """
              const double foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf20_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'char *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'char *' using type 'double'
                 char * b = foo();
                            ^

        */
    error(
      """
              const double foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf20_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: error: incompatible types when initializing type 'double *' using type 'double'
                 double * b = foo();
                              ^

        */
    error(
      """
              const double foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf20_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              const double foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              const double foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf20_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              const double foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              const double foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf20_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              const double foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              const double foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf20_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              const double foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf20_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              const double foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf20_18(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf20_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf20_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf20_21(): Unit = {
    correct(
      """
              const double foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              const double foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf20_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'double'
                 int * b = foo();
                           ^

        */
    error(
      """
              const double foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf20_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'const int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'const int *' using type 'double'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              const double foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf20_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'volatile int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              const double foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: error: incompatible types when initializing type 'volatile int *' using type 'double'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              const double foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf21_0(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf21_1(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf21_2(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf21_3(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf21_4(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf21_5(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf21_6(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf21_7(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf21_8(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf21_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'double'
                 int * b = foo();
                           ^

        */
    error(
      """
              volatile double foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf21_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int **' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'int **' using type 'double'
                 int ** b = foo();
                            ^

        */
    error(
      """
              volatile double foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf21_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'char *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'char *' using type 'double'
                 char * b = foo();
                            ^

        */
    error(
      """
              volatile double foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf21_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: error: incompatible types when initializing type 'double *' using type 'double'
                 double * b = foo();
                              ^

        */
    error(
      """
              volatile double foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf21_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              volatile double foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              volatile double foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf21_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              volatile double foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              volatile double foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf21_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              volatile double foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              volatile double foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf21_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              volatile double foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf21_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              volatile double foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf21_18(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf21_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf21_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf21_21(): Unit = {
    correct(
      """
              volatile double foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    correct(
      """
              volatile double foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf21_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'int *' using type 'double'
                 int * b = foo();
                           ^

        */
    error(
      """
              volatile double foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf21_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'const int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'const int *' using type 'double'
                 const int * b = foo();
                                 ^

        */
    error(
      """
              volatile double foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf21_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'volatile int *' from type 'double'
                 b = foo();
                   ^

        */
    error(
      """
              volatile double foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: error: incompatible types when initializing type 'volatile int *' using type 'double'
                 volatile int * b = foo();
                                    ^

        */
    error(
      """
              volatile double foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf22_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 char b = foo();
                          ^

        */
    warning(
      """
              int * foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf22_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes integer from pointer without a cast
                 signed char b = foo();
                                 ^

        */
    warning(
      """
              int * foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf22_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:35: warning: initialization makes integer from pointer without a cast
                 unsigned char b = foo();
                                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf22_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 unsigned int b = foo();
                                  ^

        */
    warning(
      """
              int * foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf22_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:32: warning: initialization makes integer from pointer without a cast
                 signed int b = foo();
                                ^

        */
    warning(
      """
              int * foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf22_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 long b = foo();
                          ^

        */
    warning(
      """
              int * foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf22_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'float' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'float' using type 'int *'
                 float b = foo();
                           ^

        */
    error(
      """
              int * foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf22_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'double' using type 'int *'
                 double b = foo();
                            ^

        */
    error(
      """
              int * foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf22_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long double' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'long double' using type 'int *'
                 long double b = foo();
                                 ^

        */
    error(
      """
              int * foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf22_9(): Unit = {
    correct(
      """
              int * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    correct(
      """
              int * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf22_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 int ** b = foo();
                            ^

        */
    warning(
      """
              int * foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf22_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 char * b = foo();
                            ^

        */
    warning(
      """
              int * foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf22_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization from incompatible pointer type
                 double * b = foo();
                              ^

        */
    warning(
      """
              int * foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf22_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              int * foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              int * foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf22_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              int * foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              int * foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf22_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              int * foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              int * foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf22_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              int * foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf22_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              int * foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf22_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              int * foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 volatile int b = foo();
                                  ^

        */
    warning(
      """
              int * foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf22_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:31: warning: initialization makes integer from pointer without a cast
                 const int b = foo();
                               ^

        */
    warning(
      """
              int * foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf22_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'double' using type 'int *'
                 const double b = foo();
                                  ^

        */
    error(
      """
              int * foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf22_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'int *'
                 b = foo();
                   ^

        */
    error(
      """
              int * foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:37: error: incompatible types when initializing type 'double' using type 'int *'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              int * foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf22_22(): Unit = {
    correct(
      """
              int * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    correct(
      """
              int * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf22_23(): Unit = {
    correct(
      """
              int * foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    correct(
      """
              int * foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf22_24(): Unit = {
    correct(
      """
              int * foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    correct(
      """
              int * foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf23_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 char b = foo();
                          ^

        */
    warning(
      """
              const int * foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf23_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes integer from pointer without a cast
                 signed char b = foo();
                                 ^

        */
    warning(
      """
              const int * foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf23_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:35: warning: initialization makes integer from pointer without a cast
                 unsigned char b = foo();
                                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf23_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 unsigned int b = foo();
                                  ^

        */
    warning(
      """
              const int * foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf23_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:32: warning: initialization makes integer from pointer without a cast
                 signed int b = foo();
                                ^

        */
    warning(
      """
              const int * foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf23_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 long b = foo();
                          ^

        */
    warning(
      """
              const int * foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf23_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'float' from type 'const int *'
                 b = foo();
                   ^

        */
    error(
      """
              const int * foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'float' using type 'const int *'
                 float b = foo();
                           ^

        */
    error(
      """
              const int * foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf23_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'const int *'
                 b = foo();
                   ^

        */
    error(
      """
              const int * foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'double' using type 'const int *'
                 double b = foo();
                            ^

        */
    error(
      """
              const int * foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf23_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long double' from type 'const int *'
                 b = foo();
                   ^

        */
    error(
      """
              const int * foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'long double' using type 'const int *'
                 long double b = foo();
                                 ^

        */
    error(
      """
              const int * foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf23_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment discards 'const' qualifier from pointer target type
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization discards 'const' qualifier from pointer target type
                 int * b = foo();
                           ^

        */
    warning(
      """
              const int * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf23_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 int ** b = foo();
                            ^

        */
    warning(
      """
              const int * foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf23_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 char * b = foo();
                            ^

        */
    warning(
      """
              const int * foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf23_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization from incompatible pointer type
                 double * b = foo();
                              ^

        */
    warning(
      """
              const int * foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf23_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'const int *'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              const int * foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              const int * foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf23_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'const int *'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              const int * foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              const int * foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf23_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'const int *'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              const int * foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              const int * foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf23_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'const int *'
                 b = foo();
                   ^

        */
    error(
      """
              const int * foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              const int * foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf23_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'const int *'
                 b = foo();
                   ^

        */
    error(
      """
              const int * foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              const int * foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf23_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 volatile int b = foo();
                                  ^

        */
    warning(
      """
              const int * foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf23_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              const int * foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:31: warning: initialization makes integer from pointer without a cast
                 const int b = foo();
                               ^

        */
    warning(
      """
              const int * foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf23_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              const int * foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'double' using type 'const int *'
                 const double b = foo();
                                  ^

        */
    error(
      """
              const int * foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf23_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'const int *'
                 b = foo();
                   ^

        */
    error(
      """
              const int * foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:37: error: incompatible types when initializing type 'double' using type 'const int *'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              const int * foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf23_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment discards 'const' qualifier from pointer target type
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization discards 'const' qualifier from pointer target type
                 int * b = foo();
                           ^

        */
    warning(
      """
              const int * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf23_23(): Unit = {
    correct(
      """
              const int * foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    correct(
      """
              const int * foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf23_24(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment discards 'const' qualifier from pointer target type
                 b = foo();
                   ^

        */
    warning(
      """
              const int * foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:36: warning: initialization discards 'const' qualifier from pointer target type
                 volatile int * b = foo();
                                    ^

        */
    warning(
      """
              const int * foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


  @Test def test_conf24_0(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 char b = foo();
                          ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                char b = foo();
              }
                """)
  }


  @Test def test_conf24_1(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                signed char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization makes integer from pointer without a cast
                 signed char b = foo();
                                 ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                signed char b = foo();
              }
                """)
  }


  @Test def test_conf24_2(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                unsigned char b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:35: warning: initialization makes integer from pointer without a cast
                 unsigned char b = foo();
                                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                unsigned char b = foo();
              }
                """)
  }


  @Test def test_conf24_3(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                unsigned int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 unsigned int b = foo();
                                  ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                unsigned int b = foo();
              }
                """)
  }


  @Test def test_conf24_4(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                signed int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:32: warning: initialization makes integer from pointer without a cast
                 signed int b = foo();
                                ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                signed int b = foo();
              }
                """)
  }


  @Test def test_conf24_5(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                long b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:26: warning: initialization makes integer from pointer without a cast
                 long b = foo();
                          ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                long b = foo();
              }
                """)
  }


  @Test def test_conf24_6(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'float' from type 'volatile int *'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                float b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: error: incompatible types when initializing type 'float' using type 'volatile int *'
                 float b = foo();
                           ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                float b = foo();
              }
                """)
  }


  @Test def test_conf24_7(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'volatile int *'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: error: incompatible types when initializing type 'double' using type 'volatile int *'
                 double b = foo();
                            ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                double b = foo();
              }
                """)
  }


  @Test def test_conf24_8(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'long double' from type 'volatile int *'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                long double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: error: incompatible types when initializing type 'long double' using type 'volatile int *'
                 long double b = foo();
                                 ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                long double b = foo();
              }
                """)
  }


  @Test def test_conf24_9(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment discards 'volatile' qualifier from pointer target type
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization discards 'volatile' qualifier from pointer target type
                 int * b = foo();
                           ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf24_10(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                int ** b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 int ** b = foo();
                            ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                int ** b = foo();
              }
                """)
  }


  @Test def test_conf24_11(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                char * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:28: warning: initialization from incompatible pointer type
                 char * b = foo();
                            ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                char * b = foo();
              }
                """)
  }


  @Test def test_conf24_12(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment from incompatible pointer type
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                double * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:30: warning: initialization from incompatible pointer type
                 double * b = foo();
                              ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                double * b = foo();
              }
                """)
  }


  @Test def test_conf24_13(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct S' from type 'volatile int *'
                 b = foo();
                   ^

        */
    error(
      """
              struct S { int x; int y; };

              volatile int * foo();
              void main() {
                struct S b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct S b = foo();
                        ^

        */
    error(
      """
              struct S { int x; int y; };

              volatile int * foo();
              void main() {
                struct S b = foo();
              }
                """)
  }


  @Test def test_conf24_14(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct T' from type 'volatile int *'
                 b = foo();
                   ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              volatile int * foo();
              void main() {
                struct T b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:24: error: invalid initializer
                 struct T b = foo();
                        ^

        */
    error(
      """
              struct T { int x; int y; int z; };

              volatile int * foo();
              void main() {
                struct T b = foo();
              }
                """)
  }


  @Test def test_conf24_15(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:6:19: error: incompatible types when assigning to type 'struct_anonymous' from type 'volatile int *'
                 b = foo();
                   ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              volatile int * foo();
              void main() {
                struct_anonymous b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:5:17: error: invalid initializer
                 struct_anonymous b = foo();
                 ^

        */
    error(
      """
              typedef struct { int x; } struct_anonymous;

              volatile int * foo();
              void main() {
                struct_anonymous b = foo();
              }
                """)
  }


  @Test def test_conf24_16(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'volatile int *'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                struct { int a; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { int a; } b = foo();
                        ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                struct { int a; } b = foo();
              }
                """)
  }


  @Test def test_conf24_17(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'struct <anonymous>' from type 'volatile int *'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                struct { float b; } b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:24: error: invalid initializer
                 struct { float b; } b = foo();
                        ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                struct { float b; } b = foo();
              }
                """)
  }


  @Test def test_conf24_18(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment makes integer from pointer without a cast
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                volatile int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: warning: initialization makes integer from pointer without a cast
                 volatile int b = foo();
                                  ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                volatile int b = foo();
              }
                """)
  }


  @Test def test_conf24_19(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                const int b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:31: warning: initialization makes integer from pointer without a cast
                 const int b = foo();
                               ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                const int b = foo();
              }
                """)
  }


  @Test def test_conf24_20(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: assignment of read-only variable 'b'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                const double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:34: error: incompatible types when initializing type 'double' using type 'volatile int *'
                 const double b = foo();
                                  ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                const double b = foo();
              }
                """)
  }


  @Test def test_conf24_21(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: error: incompatible types when assigning to type 'double' from type 'volatile int *'
                 b = foo();
                   ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                volatile double b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:37: error: incompatible types when initializing type 'double' using type 'volatile int *'
                 volatile double b = foo();
                                     ^

        */
    error(
      """
              volatile int * foo();
              void main() {
                volatile double b = foo();
              }
                """)
  }


  @Test def test_conf24_22(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment discards 'volatile' qualifier from pointer target type
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:27: warning: initialization discards 'volatile' qualifier from pointer target type
                 int * b = foo();
                           ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                int * b = foo();
              }
                """)
  }


  @Test def test_conf24_23(): Unit = {
    /* gcc reports:
test.c: In function 'main':
test.c:4:19: warning: assignment discards 'volatile' qualifier from pointer target type
                 b = foo();
                   ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                const int * b;
                b = foo();
              }
                """)
    /* gcc reports:
test.c: In function 'main':
test.c:3:33: warning: initialization discards 'volatile' qualifier from pointer target type
                 const int * b = foo();
                                 ^

        */
    warning(
      """
              volatile int * foo();
              void main() {
                const int * b = foo();
              }
                """)
  }


  @Test def test_conf24_24(): Unit = {
    correct(
      """
              volatile int * foo();
              void main() {
                volatile int * b;
                b = foo();
              }
                """)
    correct(
      """
              volatile int * foo();
              void main() {
                volatile int * b = foo();
              }
                """)
  }


}