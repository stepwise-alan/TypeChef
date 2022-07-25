package de.fosd.typechef.typesystem.generated

import de.fosd.typechef.typesystem._
import org.junit._

/** generated tests! do not modify! */
class GeneratedVarInitializerTests extends TestHelperTS {

  @Test def test_conf0_0(): Unit = {
    correct(
      """
              char x = 0;
                """)
    correct(
      """
              void foo() { char x = 0; x = 0; }
                """)
  }


  @Test def test_conf0_1(): Unit = {
    correct(
      """
              char x = 1;
                """)
    correct(
      """
              void foo() { char x = 1; x = 1; }
                """)
  }


  @Test def test_conf0_2(): Unit = {
    correct(
      """
              char x = -1;
                """)
    correct(
      """
              void foo() { char x = -1; x = -1; }
                """)
  }


  @Test def test_conf0_3(): Unit = {
    correct(
      """
              char x = 1l;
                """)
    correct(
      """
              void foo() { char x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf0_4(): Unit = {
    correct(
      """
              char x = 0xa4;
                """)
    correct(
      """
              void foo() { char x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf0_5(): Unit = {
    correct(
      """
              char x = 0.2;
                """)
    correct(
      """
              void foo() { char x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf0_6(): Unit = {
    /* gcc reports:
test.c:1:24: warning: initialization makes integer from pointer without a cast [enabled by default]
           char x = "0.2";
                    ^
test.c:1:15: error: initializer element is not computable at load time
           char x = "0.2";
           ^

    */
    error(
      """
              char x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:37: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { char x = "0.2"; x = "0.2"; }
                                 ^
test.c:1:46: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { char x = "0.2"; x = "0.2"; }
                                          ^

    */
    warning(
      """
              void foo() { char x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf0_7(): Unit = {
    /* gcc reports:
test.c:1:24: warning: initialization makes integer from pointer without a cast [enabled by default]
           char x = &"foo";
                    ^
test.c:1:15: error: initializer element is not computable at load time
           char x = &"foo";
           ^

    */
    error(
      """
              char x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:37: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { char x = &"foo"; x = &"foo"; }
                                 ^
test.c:1:47: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { char x = &"foo"; x = &"foo"; }
                                           ^

    */
    warning(
      """
              void foo() { char x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf0_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           char x = *"foo";
           ^

    */
    error(
      """
              char x = *"foo";
                """)
    correct(
      """
              void foo() { char x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf0_9(): Unit = {
    /* gcc reports:
test.c:1:24: error: lvalue required as unary ‘&’ operand
           char x = &1;
                    ^

    */
    error(
      """
              char x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:37: error: lvalue required as unary ‘&’ operand
           void foo() { char x = &1; x = &1; }
                                 ^
test.c:1:45: error: lvalue required as unary ‘&’ operand
           void foo() { char x = &1; x = &1; }
                                         ^

    */
    error(
      """
              void foo() { char x = &1; x = &1; }
                """)
  }


  @Test def test_conf1_0(): Unit = {
    correct(
      """
              signed char x = 0;
                """)
    correct(
      """
              void foo() { signed char x = 0; x = 0; }
                """)
  }


  @Test def test_conf1_1(): Unit = {
    correct(
      """
              signed char x = 1;
                """)
    correct(
      """
              void foo() { signed char x = 1; x = 1; }
                """)
  }


  @Test def test_conf1_2(): Unit = {
    correct(
      """
              signed char x = -1;
                """)
    correct(
      """
              void foo() { signed char x = -1; x = -1; }
                """)
  }


  @Test def test_conf1_3(): Unit = {
    correct(
      """
              signed char x = 1l;
                """)
    correct(
      """
              void foo() { signed char x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf1_4(): Unit = {
    correct(
      """
              signed char x = 0xa4;
                """)
    correct(
      """
              void foo() { signed char x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf1_5(): Unit = {
    correct(
      """
              signed char x = 0.2;
                """)
    correct(
      """
              void foo() { signed char x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf1_6(): Unit = {
    /* gcc reports:
test.c:1:31: warning: initialization makes integer from pointer without a cast [enabled by default]
           signed char x = "0.2";
                           ^
test.c:1:15: error: initializer element is not computable at load time
           signed char x = "0.2";
           ^

    */
    error(
      """
              signed char x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { signed char x = "0.2"; x = "0.2"; }
                                        ^
test.c:1:53: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { signed char x = "0.2"; x = "0.2"; }
                                                 ^

    */
    warning(
      """
              void foo() { signed char x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf1_7(): Unit = {
    /* gcc reports:
test.c:1:31: warning: initialization makes integer from pointer without a cast [enabled by default]
           signed char x = &"foo";
                           ^
test.c:1:15: error: initializer element is not computable at load time
           signed char x = &"foo";
           ^

    */
    error(
      """
              signed char x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { signed char x = &"foo"; x = &"foo"; }
                                        ^
test.c:1:54: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { signed char x = &"foo"; x = &"foo"; }
                                                  ^

    */
    warning(
      """
              void foo() { signed char x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf1_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           signed char x = *"foo";
           ^

    */
    error(
      """
              signed char x = *"foo";
                """)
    correct(
      """
              void foo() { signed char x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf1_9(): Unit = {
    /* gcc reports:
test.c:1:31: error: lvalue required as unary ‘&’ operand
           signed char x = &1;
                           ^

    */
    error(
      """
              signed char x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: error: lvalue required as unary ‘&’ operand
           void foo() { signed char x = &1; x = &1; }
                                        ^
test.c:1:52: error: lvalue required as unary ‘&’ operand
           void foo() { signed char x = &1; x = &1; }
                                                ^

    */
    error(
      """
              void foo() { signed char x = &1; x = &1; }
                """)
  }


  @Test def test_conf2_0(): Unit = {
    correct(
      """
              unsigned char x = 0;
                """)
    correct(
      """
              void foo() { unsigned char x = 0; x = 0; }
                """)
  }


  @Test def test_conf2_1(): Unit = {
    correct(
      """
              unsigned char x = 1;
                """)
    correct(
      """
              void foo() { unsigned char x = 1; x = 1; }
                """)
  }


  @Test def test_conf2_2(): Unit = {
    correct(
      """
              unsigned char x = -1;
                """)
    correct(
      """
              void foo() { unsigned char x = -1; x = -1; }
                """)
  }


  @Test def test_conf2_3(): Unit = {
    correct(
      """
              unsigned char x = 1l;
                """)
    correct(
      """
              void foo() { unsigned char x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf2_4(): Unit = {
    correct(
      """
              unsigned char x = 0xa4;
                """)
    correct(
      """
              void foo() { unsigned char x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf2_5(): Unit = {
    correct(
      """
              unsigned char x = 0.2;
                """)
    correct(
      """
              void foo() { unsigned char x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf2_6(): Unit = {
    /* gcc reports:
test.c:1:33: warning: initialization makes integer from pointer without a cast [enabled by default]
           unsigned char x = "0.2";
                             ^
test.c:1:15: error: initializer element is not computable at load time
           unsigned char x = "0.2";
           ^

    */
    error(
      """
              unsigned char x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { unsigned char x = "0.2"; x = "0.2"; }
                                          ^
test.c:1:55: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { unsigned char x = "0.2"; x = "0.2"; }
                                                   ^

    */
    warning(
      """
              void foo() { unsigned char x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf2_7(): Unit = {
    /* gcc reports:
test.c:1:33: warning: initialization makes integer from pointer without a cast [enabled by default]
           unsigned char x = &"foo";
                             ^
test.c:1:15: error: initializer element is not computable at load time
           unsigned char x = &"foo";
           ^

    */
    error(
      """
              unsigned char x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { unsigned char x = &"foo"; x = &"foo"; }
                                          ^
test.c:1:56: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { unsigned char x = &"foo"; x = &"foo"; }
                                                    ^

    */
    warning(
      """
              void foo() { unsigned char x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf2_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           unsigned char x = *"foo";
           ^

    */
    error(
      """
              unsigned char x = *"foo";
                """)
    correct(
      """
              void foo() { unsigned char x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf2_9(): Unit = {
    /* gcc reports:
test.c:1:33: error: lvalue required as unary ‘&’ operand
           unsigned char x = &1;
                             ^

    */
    error(
      """
              unsigned char x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: error: lvalue required as unary ‘&’ operand
           void foo() { unsigned char x = &1; x = &1; }
                                          ^
test.c:1:54: error: lvalue required as unary ‘&’ operand
           void foo() { unsigned char x = &1; x = &1; }
                                                  ^

    */
    error(
      """
              void foo() { unsigned char x = &1; x = &1; }
                """)
  }


  @Test def test_conf3_0(): Unit = {
    correct(
      """
              unsigned int x = 0;
                """)
    correct(
      """
              void foo() { unsigned int x = 0; x = 0; }
                """)
  }


  @Test def test_conf3_1(): Unit = {
    correct(
      """
              unsigned int x = 1;
                """)
    correct(
      """
              void foo() { unsigned int x = 1; x = 1; }
                """)
  }


  @Test def test_conf3_2(): Unit = {
    correct(
      """
              unsigned int x = -1;
                """)
    correct(
      """
              void foo() { unsigned int x = -1; x = -1; }
                """)
  }


  @Test def test_conf3_3(): Unit = {
    correct(
      """
              unsigned int x = 1l;
                """)
    correct(
      """
              void foo() { unsigned int x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf3_4(): Unit = {
    correct(
      """
              unsigned int x = 0xa4;
                """)
    correct(
      """
              void foo() { unsigned int x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf3_5(): Unit = {
    correct(
      """
              unsigned int x = 0.2;
                """)
    correct(
      """
              void foo() { unsigned int x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf3_6(): Unit = {
    /* gcc reports:
test.c:1:32: warning: initialization makes integer from pointer without a cast [enabled by default]
           unsigned int x = "0.2";
                            ^
test.c:1:15: error: initializer element is not computable at load time
           unsigned int x = "0.2";
           ^

    */
    error(
      """
              unsigned int x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:45: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { unsigned int x = "0.2"; x = "0.2"; }
                                         ^
test.c:1:54: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { unsigned int x = "0.2"; x = "0.2"; }
                                                  ^

    */
    warning(
      """
              void foo() { unsigned int x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf3_7(): Unit = {
    /* gcc reports:
test.c:1:32: warning: initialization makes integer from pointer without a cast [enabled by default]
           unsigned int x = &"foo";
                            ^
test.c:1:15: error: initializer element is not computable at load time
           unsigned int x = &"foo";
           ^

    */
    error(
      """
              unsigned int x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:45: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { unsigned int x = &"foo"; x = &"foo"; }
                                         ^
test.c:1:55: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { unsigned int x = &"foo"; x = &"foo"; }
                                                   ^

    */
    warning(
      """
              void foo() { unsigned int x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf3_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           unsigned int x = *"foo";
           ^

    */
    error(
      """
              unsigned int x = *"foo";
                """)
    correct(
      """
              void foo() { unsigned int x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf3_9(): Unit = {
    /* gcc reports:
test.c:1:32: error: lvalue required as unary ‘&’ operand
           unsigned int x = &1;
                            ^

    */
    error(
      """
              unsigned int x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:45: error: lvalue required as unary ‘&’ operand
           void foo() { unsigned int x = &1; x = &1; }
                                         ^
test.c:1:53: error: lvalue required as unary ‘&’ operand
           void foo() { unsigned int x = &1; x = &1; }
                                                 ^

    */
    error(
      """
              void foo() { unsigned int x = &1; x = &1; }
                """)
  }


  @Test def test_conf4_0(): Unit = {
    correct(
      """
              signed int x = 0;
                """)
    correct(
      """
              void foo() { signed int x = 0; x = 0; }
                """)
  }


  @Test def test_conf4_1(): Unit = {
    correct(
      """
              signed int x = 1;
                """)
    correct(
      """
              void foo() { signed int x = 1; x = 1; }
                """)
  }


  @Test def test_conf4_2(): Unit = {
    correct(
      """
              signed int x = -1;
                """)
    correct(
      """
              void foo() { signed int x = -1; x = -1; }
                """)
  }


  @Test def test_conf4_3(): Unit = {
    correct(
      """
              signed int x = 1l;
                """)
    correct(
      """
              void foo() { signed int x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf4_4(): Unit = {
    correct(
      """
              signed int x = 0xa4;
                """)
    correct(
      """
              void foo() { signed int x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf4_5(): Unit = {
    correct(
      """
              signed int x = 0.2;
                """)
    correct(
      """
              void foo() { signed int x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf4_6(): Unit = {
    /* gcc reports:
test.c:1:30: warning: initialization makes integer from pointer without a cast [enabled by default]
           signed int x = "0.2";
                          ^
test.c:1:15: error: initializer element is not computable at load time
           signed int x = "0.2";
           ^

    */
    error(
      """
              signed int x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:43: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { signed int x = "0.2"; x = "0.2"; }
                                       ^
test.c:1:52: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { signed int x = "0.2"; x = "0.2"; }
                                                ^

    */
    warning(
      """
              void foo() { signed int x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf4_7(): Unit = {
    /* gcc reports:
test.c:1:30: warning: initialization makes integer from pointer without a cast [enabled by default]
           signed int x = &"foo";
                          ^
test.c:1:15: error: initializer element is not computable at load time
           signed int x = &"foo";
           ^

    */
    error(
      """
              signed int x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:43: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { signed int x = &"foo"; x = &"foo"; }
                                       ^
test.c:1:53: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { signed int x = &"foo"; x = &"foo"; }
                                                 ^

    */
    warning(
      """
              void foo() { signed int x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf4_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           signed int x = *"foo";
           ^

    */
    error(
      """
              signed int x = *"foo";
                """)
    correct(
      """
              void foo() { signed int x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf4_9(): Unit = {
    /* gcc reports:
test.c:1:30: error: lvalue required as unary ‘&’ operand
           signed int x = &1;
                          ^

    */
    error(
      """
              signed int x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:43: error: lvalue required as unary ‘&’ operand
           void foo() { signed int x = &1; x = &1; }
                                       ^
test.c:1:51: error: lvalue required as unary ‘&’ operand
           void foo() { signed int x = &1; x = &1; }
                                               ^

    */
    error(
      """
              void foo() { signed int x = &1; x = &1; }
                """)
  }


  @Test def test_conf5_0(): Unit = {
    correct(
      """
              long x = 0;
                """)
    correct(
      """
              void foo() { long x = 0; x = 0; }
                """)
  }


  @Test def test_conf5_1(): Unit = {
    correct(
      """
              long x = 1;
                """)
    correct(
      """
              void foo() { long x = 1; x = 1; }
                """)
  }


  @Test def test_conf5_2(): Unit = {
    correct(
      """
              long x = -1;
                """)
    correct(
      """
              void foo() { long x = -1; x = -1; }
                """)
  }


  @Test def test_conf5_3(): Unit = {
    correct(
      """
              long x = 1l;
                """)
    correct(
      """
              void foo() { long x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf5_4(): Unit = {
    correct(
      """
              long x = 0xa4;
                """)
    correct(
      """
              void foo() { long x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf5_5(): Unit = {
    correct(
      """
              long x = 0.2;
                """)
    correct(
      """
              void foo() { long x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf5_6(): Unit = {
    /* gcc reports:
test.c:1:24: warning: initialization makes integer from pointer without a cast [enabled by default]
           long x = "0.2";
                    ^

    */
    warning(
      """
              long x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:37: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { long x = "0.2"; x = "0.2"; }
                                 ^
test.c:1:46: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { long x = "0.2"; x = "0.2"; }
                                          ^

    */
    warning(
      """
              void foo() { long x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf5_7(): Unit = {
    /* gcc reports:
test.c:1:24: warning: initialization makes integer from pointer without a cast [enabled by default]
           long x = &"foo";
                    ^

    */
    warning(
      """
              long x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:37: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { long x = &"foo"; x = &"foo"; }
                                 ^
test.c:1:47: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { long x = &"foo"; x = &"foo"; }
                                           ^

    */
    warning(
      """
              void foo() { long x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf5_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           long x = *"foo";
           ^

    */
    error(
      """
              long x = *"foo";
                """)
    correct(
      """
              void foo() { long x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf5_9(): Unit = {
    /* gcc reports:
test.c:1:24: error: lvalue required as unary ‘&’ operand
           long x = &1;
                    ^

    */
    error(
      """
              long x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:37: error: lvalue required as unary ‘&’ operand
           void foo() { long x = &1; x = &1; }
                                 ^
test.c:1:45: error: lvalue required as unary ‘&’ operand
           void foo() { long x = &1; x = &1; }
                                         ^

    */
    error(
      """
              void foo() { long x = &1; x = &1; }
                """)
  }


  @Test def test_conf6_0(): Unit = {
    correct(
      """
              double x = 0;
                """)
    correct(
      """
              void foo() { double x = 0; x = 0; }
                """)
  }


  @Test def test_conf6_1(): Unit = {
    correct(
      """
              double x = 1;
                """)
    correct(
      """
              void foo() { double x = 1; x = 1; }
                """)
  }


  @Test def test_conf6_2(): Unit = {
    correct(
      """
              double x = -1;
                """)
    correct(
      """
              void foo() { double x = -1; x = -1; }
                """)
  }


  @Test def test_conf6_3(): Unit = {
    correct(
      """
              double x = 1l;
                """)
    correct(
      """
              void foo() { double x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf6_4(): Unit = {
    correct(
      """
              double x = 0xa4;
                """)
    correct(
      """
              void foo() { double x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf6_5(): Unit = {
    correct(
      """
              double x = 0.2;
                """)
    correct(
      """
              void foo() { double x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf6_6(): Unit = {
    /* gcc reports:
test.c:1:26: error: incompatible types when initializing type ‘double’ using type ‘char *’
           double x = "0.2";
                      ^

    */
    error(
      """
              double x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: error: incompatible types when initializing type ‘double’ using type ‘char *’
           void foo() { double x = "0.2"; x = "0.2"; }
                                   ^
test.c:1:48: error: incompatible types when assigning to type ‘double’ from type ‘char *’
           void foo() { double x = "0.2"; x = "0.2"; }
                                            ^

    */
    error(
      """
              void foo() { double x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf6_7(): Unit = {
    /* gcc reports:
test.c:1:26: error: incompatible types when initializing type ‘double’ using type ‘char (*)[4]’
           double x = &"foo";
                      ^

    */
    error(
      """
              double x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: error: incompatible types when initializing type ‘double’ using type ‘char (*)[4]’
           void foo() { double x = &"foo"; x = &"foo"; }
                                   ^
test.c:1:49: error: incompatible types when assigning to type ‘double’ from type ‘char (*)[4]’
           void foo() { double x = &"foo"; x = &"foo"; }
                                             ^

    */
    error(
      """
              void foo() { double x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf6_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           double x = *"foo";
           ^

    */
    error(
      """
              double x = *"foo";
                """)
    correct(
      """
              void foo() { double x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf6_9(): Unit = {
    /* gcc reports:
test.c:1:26: error: lvalue required as unary ‘&’ operand
           double x = &1;
                      ^

    */
    error(
      """
              double x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: error: lvalue required as unary ‘&’ operand
           void foo() { double x = &1; x = &1; }
                                   ^
test.c:1:47: error: lvalue required as unary ‘&’ operand
           void foo() { double x = &1; x = &1; }
                                           ^

    */
    error(
      """
              void foo() { double x = &1; x = &1; }
                """)
  }


  @Test def test_conf7_0(): Unit = {
    correct(
      """
              int * x = 0;
                """)
    correct(
      """
              void foo() { int * x = 0; x = 0; }
                """)
  }


  @Test def test_conf7_1(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = 1;
                     ^

    */
    warning(
      """
              int * x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 1; x = 1; }
                                  ^
test.c:1:43: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 1; x = 1; }
                                       ^

    */
    warning(
      """
              void foo() { int * x = 1; x = 1; }
                """)
  }


  @Test def test_conf7_2(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = -1;
                     ^

    */
    warning(
      """
              int * x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = -1; x = -1; }
                                  ^
test.c:1:44: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = -1; x = -1; }
                                        ^

    */
    warning(
      """
              void foo() { int * x = -1; x = -1; }
                """)
  }


  @Test def test_conf7_3(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = 1l;
                     ^

    */
    warning(
      """
              int * x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 1l; x = 1l; }
                                  ^
test.c:1:44: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 1l; x = 1l; }
                                        ^

    */
    warning(
      """
              void foo() { int * x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf7_4(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = 0xa4;
                     ^

    */
    warning(
      """
              int * x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 0xa4; x = 0xa4; }
                                  ^
test.c:1:46: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 0xa4; x = 0xa4; }
                                          ^

    */
    warning(
      """
              void foo() { int * x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf7_5(): Unit = {
    /* gcc reports:
test.c:1:25: error: incompatible types when initializing type ‘int *’ using type ‘double’
           int * x = 0.2;
                     ^

    */
    error(
      """
              int * x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: error: incompatible types when initializing type ‘int *’ using type ‘double’
           void foo() { int * x = 0.2; x = 0.2; }
                                  ^
test.c:1:45: error: incompatible types when assigning to type ‘int *’ from type ‘double’
           void foo() { int * x = 0.2; x = 0.2; }
                                         ^

    */
    error(
      """
              void foo() { int * x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf7_6(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization from incompatible pointer type [enabled by default]
           int * x = "0.2";
                     ^

    */
    warning(
      """
              int * x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { int * x = "0.2"; x = "0.2"; }
                                  ^
test.c:1:47: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { int * x = "0.2"; x = "0.2"; }
                                           ^

    */
    warning(
      """
              void foo() { int * x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf7_7(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization from incompatible pointer type [enabled by default]
           int * x = &"foo";
                     ^

    */
    warning(
      """
              int * x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { int * x = &"foo"; x = &"foo"; }
                                  ^
test.c:1:48: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { int * x = &"foo"; x = &"foo"; }
                                            ^

    */
    warning(
      """
              void foo() { int * x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf7_8(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = *"foo";
                     ^
test.c:1:15: error: initializer element is not constant
           int * x = *"foo";
           ^

    */
    error(
      """
              int * x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = *"foo"; x = *"foo"; }
                                  ^
test.c:1:48: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = *"foo"; x = *"foo"; }
                                            ^

    */
    warning(
      """
              void foo() { int * x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf7_9(): Unit = {
    /* gcc reports:
test.c:1:25: error: lvalue required as unary ‘&’ operand
           int * x = &1;
                     ^

    */
    error(
      """
              int * x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: error: lvalue required as unary ‘&’ operand
           void foo() { int * x = &1; x = &1; }
                                  ^
test.c:1:46: error: lvalue required as unary ‘&’ operand
           void foo() { int * x = &1; x = &1; }
                                          ^

    */
    error(
      """
              void foo() { int * x = &1; x = &1; }
                """)
  }


  @Test def test_conf8_0(): Unit = {
    correct(
      """
              char * x = 0;
                """)
    correct(
      """
              void foo() { char * x = 0; x = 0; }
                """)
  }


  @Test def test_conf8_1(): Unit = {
    /* gcc reports:
test.c:1:26: warning: initialization makes pointer from integer without a cast [enabled by default]
           char * x = 1;
                      ^

    */
    warning(
      """
              char * x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = 1; x = 1; }
                                   ^
test.c:1:44: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = 1; x = 1; }
                                        ^

    */
    warning(
      """
              void foo() { char * x = 1; x = 1; }
                """)
  }


  @Test def test_conf8_2(): Unit = {
    /* gcc reports:
test.c:1:26: warning: initialization makes pointer from integer without a cast [enabled by default]
           char * x = -1;
                      ^

    */
    warning(
      """
              char * x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = -1; x = -1; }
                                   ^
test.c:1:45: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = -1; x = -1; }
                                         ^

    */
    warning(
      """
              void foo() { char * x = -1; x = -1; }
                """)
  }


  @Test def test_conf8_3(): Unit = {
    /* gcc reports:
test.c:1:26: warning: initialization makes pointer from integer without a cast [enabled by default]
           char * x = 1l;
                      ^

    */
    warning(
      """
              char * x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = 1l; x = 1l; }
                                   ^
test.c:1:45: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = 1l; x = 1l; }
                                         ^

    */
    warning(
      """
              void foo() { char * x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf8_4(): Unit = {
    /* gcc reports:
test.c:1:26: warning: initialization makes pointer from integer without a cast [enabled by default]
           char * x = 0xa4;
                      ^

    */
    warning(
      """
              char * x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = 0xa4; x = 0xa4; }
                                   ^
test.c:1:47: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = 0xa4; x = 0xa4; }
                                           ^

    */
    warning(
      """
              void foo() { char * x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf8_5(): Unit = {
    /* gcc reports:
test.c:1:26: error: incompatible types when initializing type ‘char *’ using type ‘double’
           char * x = 0.2;
                      ^

    */
    error(
      """
              char * x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: error: incompatible types when initializing type ‘char *’ using type ‘double’
           void foo() { char * x = 0.2; x = 0.2; }
                                   ^
test.c:1:46: error: incompatible types when assigning to type ‘char *’ from type ‘double’
           void foo() { char * x = 0.2; x = 0.2; }
                                          ^

    */
    error(
      """
              void foo() { char * x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf8_6(): Unit = {
    correct(
      """
              char * x = "0.2";
                """)
    correct(
      """
              void foo() { char * x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf8_7(): Unit = {
    /* gcc reports:
test.c:1:26: warning: initialization from incompatible pointer type [enabled by default]
           char * x = &"foo";
                      ^

    */
    warning(
      """
              char * x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { char * x = &"foo"; x = &"foo"; }
                                   ^
test.c:1:49: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { char * x = &"foo"; x = &"foo"; }
                                             ^

    */
    warning(
      """
              void foo() { char * x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf8_8(): Unit = {
    /* gcc reports:
test.c:1:26: warning: initialization makes pointer from integer without a cast [enabled by default]
           char * x = *"foo";
                      ^
test.c:1:15: error: initializer element is not constant
           char * x = *"foo";
           ^

    */
    error(
      """
              char * x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = *"foo"; x = *"foo"; }
                                   ^
test.c:1:49: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char * x = *"foo"; x = *"foo"; }
                                             ^

    */
    warning(
      """
              void foo() { char * x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf8_9(): Unit = {
    /* gcc reports:
test.c:1:26: error: lvalue required as unary ‘&’ operand
           char * x = &1;
                      ^

    */
    error(
      """
              char * x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:39: error: lvalue required as unary ‘&’ operand
           void foo() { char * x = &1; x = &1; }
                                   ^
test.c:1:47: error: lvalue required as unary ‘&’ operand
           void foo() { char * x = &1; x = &1; }
                                           ^

    */
    error(
      """
              void foo() { char * x = &1; x = &1; }
                """)
  }


  @Test def test_conf9_0(): Unit = {
    correct(
      """
              signed char * x = 0;
                """)
    correct(
      """
              void foo() { signed char * x = 0; x = 0; }
                """)
  }


  @Test def test_conf9_1(): Unit = {
    /* gcc reports:
test.c:1:33: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char * x = 1;
                             ^

    */
    warning(
      """
              signed char * x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = 1; x = 1; }
                                          ^
test.c:1:51: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = 1; x = 1; }
                                               ^

    */
    warning(
      """
              void foo() { signed char * x = 1; x = 1; }
                """)
  }


  @Test def test_conf9_2(): Unit = {
    /* gcc reports:
test.c:1:33: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char * x = -1;
                             ^

    */
    warning(
      """
              signed char * x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = -1; x = -1; }
                                          ^
test.c:1:52: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = -1; x = -1; }
                                                ^

    */
    warning(
      """
              void foo() { signed char * x = -1; x = -1; }
                """)
  }


  @Test def test_conf9_3(): Unit = {
    /* gcc reports:
test.c:1:33: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char * x = 1l;
                             ^

    */
    warning(
      """
              signed char * x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = 1l; x = 1l; }
                                          ^
test.c:1:52: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = 1l; x = 1l; }
                                                ^

    */
    warning(
      """
              void foo() { signed char * x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf9_4(): Unit = {
    /* gcc reports:
test.c:1:33: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char * x = 0xa4;
                             ^

    */
    warning(
      """
              signed char * x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = 0xa4; x = 0xa4; }
                                          ^
test.c:1:54: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = 0xa4; x = 0xa4; }
                                                  ^

    */
    warning(
      """
              void foo() { signed char * x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf9_5(): Unit = {
    /* gcc reports:
test.c:1:33: error: incompatible types when initializing type ‘signed char *’ using type ‘double’
           signed char * x = 0.2;
                             ^

    */
    error(
      """
              signed char * x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: error: incompatible types when initializing type ‘signed char *’ using type ‘double’
           void foo() { signed char * x = 0.2; x = 0.2; }
                                          ^
test.c:1:53: error: incompatible types when assigning to type ‘signed char *’ from type ‘double’
           void foo() { signed char * x = 0.2; x = 0.2; }
                                                 ^

    */
    error(
      """
              void foo() { signed char * x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf9_6(): Unit = {
    correct(
      """
              signed char * x = "0.2";
                """)
    correct(
      """
              void foo() { signed char * x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf9_7(): Unit = {
    /* gcc reports:
test.c:1:33: warning: initialization from incompatible pointer type [enabled by default]
           signed char * x = &"foo";
                             ^

    */
    warning(
      """
              signed char * x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { signed char * x = &"foo"; x = &"foo"; }
                                          ^
test.c:1:56: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { signed char * x = &"foo"; x = &"foo"; }
                                                    ^

    */
    warning(
      """
              void foo() { signed char * x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf9_8(): Unit = {
    /* gcc reports:
test.c:1:33: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char * x = *"foo";
                             ^
test.c:1:15: error: initializer element is not constant
           signed char * x = *"foo";
           ^

    */
    error(
      """
              signed char * x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = *"foo"; x = *"foo"; }
                                          ^
test.c:1:56: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char * x = *"foo"; x = *"foo"; }
                                                    ^

    */
    warning(
      """
              void foo() { signed char * x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf9_9(): Unit = {
    /* gcc reports:
test.c:1:33: error: lvalue required as unary ‘&’ operand
           signed char * x = &1;
                             ^

    */
    error(
      """
              signed char * x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:46: error: lvalue required as unary ‘&’ operand
           void foo() { signed char * x = &1; x = &1; }
                                          ^
test.c:1:54: error: lvalue required as unary ‘&’ operand
           void foo() { signed char * x = &1; x = &1; }
                                                  ^

    */
    error(
      """
              void foo() { signed char * x = &1; x = &1; }
                """)
  }


  @Test def test_conf10_0(): Unit = {
    correct(
      """
              unsigned char * x = 0;
                """)
    correct(
      """
              void foo() { unsigned char * x = 0; x = 0; }
                """)
  }


  @Test def test_conf10_1(): Unit = {
    /* gcc reports:
test.c:1:35: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char * x = 1;
                               ^

    */
    warning(
      """
              unsigned char * x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = 1; x = 1; }
                                            ^
test.c:1:53: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = 1; x = 1; }
                                                 ^

    */
    warning(
      """
              void foo() { unsigned char * x = 1; x = 1; }
                """)
  }


  @Test def test_conf10_2(): Unit = {
    /* gcc reports:
test.c:1:35: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char * x = -1;
                               ^

    */
    warning(
      """
              unsigned char * x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = -1; x = -1; }
                                            ^
test.c:1:54: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = -1; x = -1; }
                                                  ^

    */
    warning(
      """
              void foo() { unsigned char * x = -1; x = -1; }
                """)
  }


  @Test def test_conf10_3(): Unit = {
    /* gcc reports:
test.c:1:35: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char * x = 1l;
                               ^

    */
    warning(
      """
              unsigned char * x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = 1l; x = 1l; }
                                            ^
test.c:1:54: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = 1l; x = 1l; }
                                                  ^

    */
    warning(
      """
              void foo() { unsigned char * x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf10_4(): Unit = {
    /* gcc reports:
test.c:1:35: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char * x = 0xa4;
                               ^

    */
    warning(
      """
              unsigned char * x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = 0xa4; x = 0xa4; }
                                            ^
test.c:1:56: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = 0xa4; x = 0xa4; }
                                                    ^

    */
    warning(
      """
              void foo() { unsigned char * x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf10_5(): Unit = {
    /* gcc reports:
test.c:1:35: error: incompatible types when initializing type ‘unsigned char *’ using type ‘double’
           unsigned char * x = 0.2;
                               ^

    */
    error(
      """
              unsigned char * x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: error: incompatible types when initializing type ‘unsigned char *’ using type ‘double’
           void foo() { unsigned char * x = 0.2; x = 0.2; }
                                            ^
test.c:1:55: error: incompatible types when assigning to type ‘unsigned char *’ from type ‘double’
           void foo() { unsigned char * x = 0.2; x = 0.2; }
                                                   ^

    */
    error(
      """
              void foo() { unsigned char * x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf10_6(): Unit = {
    correct(
      """
              unsigned char * x = "0.2";
                """)
    correct(
      """
              void foo() { unsigned char * x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf10_7(): Unit = {
    /* gcc reports:
test.c:1:35: warning: initialization from incompatible pointer type [enabled by default]
           unsigned char * x = &"foo";
                               ^

    */
    warning(
      """
              unsigned char * x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { unsigned char * x = &"foo"; x = &"foo"; }
                                            ^
test.c:1:58: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { unsigned char * x = &"foo"; x = &"foo"; }
                                                      ^

    */
    warning(
      """
              void foo() { unsigned char * x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf10_8(): Unit = {
    /* gcc reports:
test.c:1:35: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char * x = *"foo";
                               ^
test.c:1:15: error: initializer element is not constant
           unsigned char * x = *"foo";
           ^

    */
    error(
      """
              unsigned char * x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = *"foo"; x = *"foo"; }
                                            ^
test.c:1:58: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char * x = *"foo"; x = *"foo"; }
                                                      ^

    */
    warning(
      """
              void foo() { unsigned char * x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf10_9(): Unit = {
    /* gcc reports:
test.c:1:35: error: lvalue required as unary ‘&’ operand
           unsigned char * x = &1;
                               ^

    */
    error(
      """
              unsigned char * x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: error: lvalue required as unary ‘&’ operand
           void foo() { unsigned char * x = &1; x = &1; }
                                            ^
test.c:1:56: error: lvalue required as unary ‘&’ operand
           void foo() { unsigned char * x = &1; x = &1; }
                                                    ^

    */
    error(
      """
              void foo() { unsigned char * x = &1; x = &1; }
                """)
  }


  @Test def test_conf11_0(): Unit = {
    correct(
      """
              char ** x = 0;
                """)
    correct(
      """
              void foo() { char ** x = 0; x = 0; }
                """)
  }


  @Test def test_conf11_1(): Unit = {
    /* gcc reports:
test.c:1:27: warning: initialization makes pointer from integer without a cast [enabled by default]
           char ** x = 1;
                       ^

    */
    warning(
      """
              char ** x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:40: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = 1; x = 1; }
                                    ^
test.c:1:45: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = 1; x = 1; }
                                         ^

    */
    warning(
      """
              void foo() { char ** x = 1; x = 1; }
                """)
  }


  @Test def test_conf11_2(): Unit = {
    /* gcc reports:
test.c:1:27: warning: initialization makes pointer from integer without a cast [enabled by default]
           char ** x = -1;
                       ^

    */
    warning(
      """
              char ** x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:40: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = -1; x = -1; }
                                    ^
test.c:1:46: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = -1; x = -1; }
                                          ^

    */
    warning(
      """
              void foo() { char ** x = -1; x = -1; }
                """)
  }


  @Test def test_conf11_3(): Unit = {
    /* gcc reports:
test.c:1:27: warning: initialization makes pointer from integer without a cast [enabled by default]
           char ** x = 1l;
                       ^

    */
    warning(
      """
              char ** x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:40: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = 1l; x = 1l; }
                                    ^
test.c:1:46: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = 1l; x = 1l; }
                                          ^

    */
    warning(
      """
              void foo() { char ** x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf11_4(): Unit = {
    /* gcc reports:
test.c:1:27: warning: initialization makes pointer from integer without a cast [enabled by default]
           char ** x = 0xa4;
                       ^

    */
    warning(
      """
              char ** x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:40: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = 0xa4; x = 0xa4; }
                                    ^
test.c:1:48: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = 0xa4; x = 0xa4; }
                                            ^

    */
    warning(
      """
              void foo() { char ** x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf11_5(): Unit = {
    /* gcc reports:
test.c:1:27: error: incompatible types when initializing type ‘char **’ using type ‘double’
           char ** x = 0.2;
                       ^

    */
    error(
      """
              char ** x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:40: error: incompatible types when initializing type ‘char **’ using type ‘double’
           void foo() { char ** x = 0.2; x = 0.2; }
                                    ^
test.c:1:47: error: incompatible types when assigning to type ‘char **’ from type ‘double’
           void foo() { char ** x = 0.2; x = 0.2; }
                                           ^

    */
    error(
      """
              void foo() { char ** x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf11_6(): Unit = {
    /* gcc reports:
test.c:1:27: warning: initialization from incompatible pointer type [enabled by default]
           char ** x = "0.2";
                       ^

    */
    warning(
      """
              char ** x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:40: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { char ** x = "0.2"; x = "0.2"; }
                                    ^
test.c:1:49: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { char ** x = "0.2"; x = "0.2"; }
                                             ^

    */
    warning(
      """
              void foo() { char ** x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf11_7(): Unit = {
    /* gcc reports:
test.c:1:27: warning: initialization from incompatible pointer type [enabled by default]
           char ** x = &"foo";
                       ^

    */
    warning(
      """
              char ** x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:40: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { char ** x = &"foo"; x = &"foo"; }
                                    ^
test.c:1:50: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { char ** x = &"foo"; x = &"foo"; }
                                              ^

    */
    warning(
      """
              void foo() { char ** x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf11_8(): Unit = {
    /* gcc reports:
test.c:1:27: warning: initialization makes pointer from integer without a cast [enabled by default]
           char ** x = *"foo";
                       ^
test.c:1:15: error: initializer element is not constant
           char ** x = *"foo";
           ^

    */
    error(
      """
              char ** x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:40: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = *"foo"; x = *"foo"; }
                                    ^
test.c:1:50: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { char ** x = *"foo"; x = *"foo"; }
                                              ^

    */
    warning(
      """
              void foo() { char ** x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf11_9(): Unit = {
    /* gcc reports:
test.c:1:27: error: lvalue required as unary ‘&’ operand
           char ** x = &1;
                       ^

    */
    error(
      """
              char ** x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:40: error: lvalue required as unary ‘&’ operand
           void foo() { char ** x = &1; x = &1; }
                                    ^
test.c:1:48: error: lvalue required as unary ‘&’ operand
           void foo() { char ** x = &1; x = &1; }
                                            ^

    */
    error(
      """
              void foo() { char ** x = &1; x = &1; }
                """)
  }


  @Test def test_conf12_0(): Unit = {
    correct(
      """
              unsigned char ** x = 0;
                """)
    correct(
      """
              void foo() { unsigned char ** x = 0; x = 0; }
                """)
  }


  @Test def test_conf12_1(): Unit = {
    /* gcc reports:
test.c:1:36: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char ** x = 1;
                                ^

    */
    warning(
      """
              unsigned char ** x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:49: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = 1; x = 1; }
                                             ^
test.c:1:54: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = 1; x = 1; }
                                                  ^

    */
    warning(
      """
              void foo() { unsigned char ** x = 1; x = 1; }
                """)
  }


  @Test def test_conf12_2(): Unit = {
    /* gcc reports:
test.c:1:36: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char ** x = -1;
                                ^

    */
    warning(
      """
              unsigned char ** x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:49: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = -1; x = -1; }
                                             ^
test.c:1:55: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = -1; x = -1; }
                                                   ^

    */
    warning(
      """
              void foo() { unsigned char ** x = -1; x = -1; }
                """)
  }


  @Test def test_conf12_3(): Unit = {
    /* gcc reports:
test.c:1:36: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char ** x = 1l;
                                ^

    */
    warning(
      """
              unsigned char ** x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:49: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = 1l; x = 1l; }
                                             ^
test.c:1:55: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = 1l; x = 1l; }
                                                   ^

    */
    warning(
      """
              void foo() { unsigned char ** x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf12_4(): Unit = {
    /* gcc reports:
test.c:1:36: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char ** x = 0xa4;
                                ^

    */
    warning(
      """
              unsigned char ** x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:49: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = 0xa4; x = 0xa4; }
                                             ^
test.c:1:57: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = 0xa4; x = 0xa4; }
                                                     ^

    */
    warning(
      """
              void foo() { unsigned char ** x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf12_5(): Unit = {
    /* gcc reports:
test.c:1:36: error: incompatible types when initializing type ‘unsigned char **’ using type ‘double’
           unsigned char ** x = 0.2;
                                ^

    */
    error(
      """
              unsigned char ** x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:49: error: incompatible types when initializing type ‘unsigned char **’ using type ‘double’
           void foo() { unsigned char ** x = 0.2; x = 0.2; }
                                             ^
test.c:1:56: error: incompatible types when assigning to type ‘unsigned char **’ from type ‘double’
           void foo() { unsigned char ** x = 0.2; x = 0.2; }
                                                    ^

    */
    error(
      """
              void foo() { unsigned char ** x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf12_6(): Unit = {
    /* gcc reports:
test.c:1:36: warning: initialization from incompatible pointer type [enabled by default]
           unsigned char ** x = "0.2";
                                ^

    */
    warning(
      """
              unsigned char ** x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:49: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { unsigned char ** x = "0.2"; x = "0.2"; }
                                             ^
test.c:1:58: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { unsigned char ** x = "0.2"; x = "0.2"; }
                                                      ^

    */
    warning(
      """
              void foo() { unsigned char ** x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf12_7(): Unit = {
    /* gcc reports:
test.c:1:36: warning: initialization from incompatible pointer type [enabled by default]
           unsigned char ** x = &"foo";
                                ^

    */
    warning(
      """
              unsigned char ** x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:49: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { unsigned char ** x = &"foo"; x = &"foo"; }
                                             ^
test.c:1:59: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { unsigned char ** x = &"foo"; x = &"foo"; }
                                                       ^

    */
    warning(
      """
              void foo() { unsigned char ** x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf12_8(): Unit = {
    /* gcc reports:
test.c:1:36: warning: initialization makes pointer from integer without a cast [enabled by default]
           unsigned char ** x = *"foo";
                                ^
test.c:1:15: error: initializer element is not constant
           unsigned char ** x = *"foo";
           ^

    */
    error(
      """
              unsigned char ** x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:49: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = *"foo"; x = *"foo"; }
                                             ^
test.c:1:59: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { unsigned char ** x = *"foo"; x = *"foo"; }
                                                       ^

    */
    warning(
      """
              void foo() { unsigned char ** x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf12_9(): Unit = {
    /* gcc reports:
test.c:1:36: error: lvalue required as unary ‘&’ operand
           unsigned char ** x = &1;
                                ^

    */
    error(
      """
              unsigned char ** x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:49: error: lvalue required as unary ‘&’ operand
           void foo() { unsigned char ** x = &1; x = &1; }
                                             ^
test.c:1:57: error: lvalue required as unary ‘&’ operand
           void foo() { unsigned char ** x = &1; x = &1; }
                                                     ^

    */
    error(
      """
              void foo() { unsigned char ** x = &1; x = &1; }
                """)
  }


  @Test def test_conf13_0(): Unit = {
    correct(
      """
              signed char ** x = 0;
                """)
    correct(
      """
              void foo() { signed char ** x = 0; x = 0; }
                """)
  }


  @Test def test_conf13_1(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char ** x = 1;
                              ^

    */
    warning(
      """
              signed char ** x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = 1; x = 1; }
                                           ^
test.c:1:52: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = 1; x = 1; }
                                                ^

    */
    warning(
      """
              void foo() { signed char ** x = 1; x = 1; }
                """)
  }


  @Test def test_conf13_2(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char ** x = -1;
                              ^

    */
    warning(
      """
              signed char ** x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = -1; x = -1; }
                                           ^
test.c:1:53: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = -1; x = -1; }
                                                 ^

    */
    warning(
      """
              void foo() { signed char ** x = -1; x = -1; }
                """)
  }


  @Test def test_conf13_3(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char ** x = 1l;
                              ^

    */
    warning(
      """
              signed char ** x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = 1l; x = 1l; }
                                           ^
test.c:1:53: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = 1l; x = 1l; }
                                                 ^

    */
    warning(
      """
              void foo() { signed char ** x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf13_4(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char ** x = 0xa4;
                              ^

    */
    warning(
      """
              signed char ** x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = 0xa4; x = 0xa4; }
                                           ^
test.c:1:55: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = 0xa4; x = 0xa4; }
                                                   ^

    */
    warning(
      """
              void foo() { signed char ** x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf13_5(): Unit = {
    /* gcc reports:
test.c:1:34: error: incompatible types when initializing type ‘signed char **’ using type ‘double’
           signed char ** x = 0.2;
                              ^

    */
    error(
      """
              signed char ** x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: error: incompatible types when initializing type ‘signed char **’ using type ‘double’
           void foo() { signed char ** x = 0.2; x = 0.2; }
                                           ^
test.c:1:54: error: incompatible types when assigning to type ‘signed char **’ from type ‘double’
           void foo() { signed char ** x = 0.2; x = 0.2; }
                                                  ^

    */
    error(
      """
              void foo() { signed char ** x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf13_6(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization from incompatible pointer type [enabled by default]
           signed char ** x = "0.2";
                              ^

    */
    warning(
      """
              signed char ** x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { signed char ** x = "0.2"; x = "0.2"; }
                                           ^
test.c:1:56: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { signed char ** x = "0.2"; x = "0.2"; }
                                                    ^

    */
    warning(
      """
              void foo() { signed char ** x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf13_7(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization from incompatible pointer type [enabled by default]
           signed char ** x = &"foo";
                              ^

    */
    warning(
      """
              signed char ** x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { signed char ** x = &"foo"; x = &"foo"; }
                                           ^
test.c:1:57: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { signed char ** x = &"foo"; x = &"foo"; }
                                                     ^

    */
    warning(
      """
              void foo() { signed char ** x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf13_8(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           signed char ** x = *"foo";
                              ^
test.c:1:15: error: initializer element is not constant
           signed char ** x = *"foo";
           ^

    */
    error(
      """
              signed char ** x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = *"foo"; x = *"foo"; }
                                           ^
test.c:1:57: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { signed char ** x = *"foo"; x = *"foo"; }
                                                     ^

    */
    warning(
      """
              void foo() { signed char ** x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf13_9(): Unit = {
    /* gcc reports:
test.c:1:34: error: lvalue required as unary ‘&’ operand
           signed char ** x = &1;
                              ^

    */
    error(
      """
              signed char ** x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: error: lvalue required as unary ‘&’ operand
           void foo() { signed char ** x = &1; x = &1; }
                                           ^
test.c:1:55: error: lvalue required as unary ‘&’ operand
           void foo() { signed char ** x = &1; x = &1; }
                                                   ^

    */
    error(
      """
              void foo() { signed char ** x = &1; x = &1; }
                """)
  }


  @Test def test_conf14_0(): Unit = {
    correct(
      """
              double * x = 0;
                """)
    correct(
      """
              void foo() { double * x = 0; x = 0; }
                """)
  }


  @Test def test_conf14_1(): Unit = {
    /* gcc reports:
test.c:1:28: warning: initialization makes pointer from integer without a cast [enabled by default]
           double * x = 1;
                        ^

    */
    warning(
      """
              double * x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:41: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = 1; x = 1; }
                                     ^
test.c:1:46: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = 1; x = 1; }
                                          ^

    */
    warning(
      """
              void foo() { double * x = 1; x = 1; }
                """)
  }


  @Test def test_conf14_2(): Unit = {
    /* gcc reports:
test.c:1:28: warning: initialization makes pointer from integer without a cast [enabled by default]
           double * x = -1;
                        ^

    */
    warning(
      """
              double * x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:41: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = -1; x = -1; }
                                     ^
test.c:1:47: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = -1; x = -1; }
                                           ^

    */
    warning(
      """
              void foo() { double * x = -1; x = -1; }
                """)
  }


  @Test def test_conf14_3(): Unit = {
    /* gcc reports:
test.c:1:28: warning: initialization makes pointer from integer without a cast [enabled by default]
           double * x = 1l;
                        ^

    */
    warning(
      """
              double * x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:41: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = 1l; x = 1l; }
                                     ^
test.c:1:47: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = 1l; x = 1l; }
                                           ^

    */
    warning(
      """
              void foo() { double * x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf14_4(): Unit = {
    /* gcc reports:
test.c:1:28: warning: initialization makes pointer from integer without a cast [enabled by default]
           double * x = 0xa4;
                        ^

    */
    warning(
      """
              double * x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:41: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = 0xa4; x = 0xa4; }
                                     ^
test.c:1:49: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = 0xa4; x = 0xa4; }
                                             ^

    */
    warning(
      """
              void foo() { double * x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf14_5(): Unit = {
    /* gcc reports:
test.c:1:28: error: incompatible types when initializing type ‘double *’ using type ‘double’
           double * x = 0.2;
                        ^

    */
    error(
      """
              double * x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:41: error: incompatible types when initializing type ‘double *’ using type ‘double’
           void foo() { double * x = 0.2; x = 0.2; }
                                     ^
test.c:1:48: error: incompatible types when assigning to type ‘double *’ from type ‘double’
           void foo() { double * x = 0.2; x = 0.2; }
                                            ^

    */
    error(
      """
              void foo() { double * x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf14_6(): Unit = {
    /* gcc reports:
test.c:1:28: warning: initialization from incompatible pointer type [enabled by default]
           double * x = "0.2";
                        ^

    */
    warning(
      """
              double * x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:41: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { double * x = "0.2"; x = "0.2"; }
                                     ^
test.c:1:50: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { double * x = "0.2"; x = "0.2"; }
                                              ^

    */
    warning(
      """
              void foo() { double * x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf14_7(): Unit = {
    /* gcc reports:
test.c:1:28: warning: initialization from incompatible pointer type [enabled by default]
           double * x = &"foo";
                        ^

    */
    warning(
      """
              double * x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:41: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { double * x = &"foo"; x = &"foo"; }
                                     ^
test.c:1:51: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { double * x = &"foo"; x = &"foo"; }
                                               ^

    */
    warning(
      """
              void foo() { double * x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf14_8(): Unit = {
    /* gcc reports:
test.c:1:28: warning: initialization makes pointer from integer without a cast [enabled by default]
           double * x = *"foo";
                        ^
test.c:1:15: error: initializer element is not constant
           double * x = *"foo";
           ^

    */
    error(
      """
              double * x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:41: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = *"foo"; x = *"foo"; }
                                     ^
test.c:1:51: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { double * x = *"foo"; x = *"foo"; }
                                               ^

    */
    warning(
      """
              void foo() { double * x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf14_9(): Unit = {
    /* gcc reports:
test.c:1:28: error: lvalue required as unary ‘&’ operand
           double * x = &1;
                        ^

    */
    error(
      """
              double * x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:41: error: lvalue required as unary ‘&’ operand
           void foo() { double * x = &1; x = &1; }
                                     ^
test.c:1:49: error: lvalue required as unary ‘&’ operand
           void foo() { double * x = &1; x = &1; }
                                             ^

    */
    error(
      """
              void foo() { double * x = &1; x = &1; }
                """)
  }


  @Test def test_conf15_0(): Unit = {
    /* gcc reports:
test.c:3:22: error: invalid initializer
           struct S x = 0;
                  ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = 0;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:35: error: invalid initializer
           void foo() { struct S x = 0; x = 0; }
                               ^
test.c:3:46: error: incompatible types when assigning to type ‘struct S’ from type ‘int’
           void foo() { struct S x = 0; x = 0; }
                                          ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = 0; x = 0; }
                """)
  }


  @Test def test_conf15_1(): Unit = {
    /* gcc reports:
test.c:3:22: error: invalid initializer
           struct S x = 1;
                  ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:35: error: invalid initializer
           void foo() { struct S x = 1; x = 1; }
                               ^
test.c:3:46: error: incompatible types when assigning to type ‘struct S’ from type ‘int’
           void foo() { struct S x = 1; x = 1; }
                                          ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = 1; x = 1; }
                """)
  }


  @Test def test_conf15_2(): Unit = {
    /* gcc reports:
test.c:3:22: error: invalid initializer
           struct S x = -1;
                  ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:35: error: invalid initializer
           void foo() { struct S x = -1; x = -1; }
                               ^
test.c:3:47: error: incompatible types when assigning to type ‘struct S’ from type ‘int’
           void foo() { struct S x = -1; x = -1; }
                                           ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = -1; x = -1; }
                """)
  }


  @Test def test_conf15_3(): Unit = {
    /* gcc reports:
test.c:3:22: error: invalid initializer
           struct S x = 1l;
                  ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:35: error: invalid initializer
           void foo() { struct S x = 1l; x = 1l; }
                               ^
test.c:3:47: error: incompatible types when assigning to type ‘struct S’ from type ‘long int’
           void foo() { struct S x = 1l; x = 1l; }
                                           ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf15_4(): Unit = {
    /* gcc reports:
test.c:3:22: error: invalid initializer
           struct S x = 0xa4;
                  ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:35: error: invalid initializer
           void foo() { struct S x = 0xa4; x = 0xa4; }
                               ^
test.c:3:49: error: incompatible types when assigning to type ‘struct S’ from type ‘int’
           void foo() { struct S x = 0xa4; x = 0xa4; }
                                             ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf15_5(): Unit = {
    /* gcc reports:
test.c:3:22: error: invalid initializer
           struct S x = 0.2;
                  ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:35: error: invalid initializer
           void foo() { struct S x = 0.2; x = 0.2; }
                               ^
test.c:3:48: error: incompatible types when assigning to type ‘struct S’ from type ‘double’
           void foo() { struct S x = 0.2; x = 0.2; }
                                            ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf15_6(): Unit = {
    /* gcc reports:
test.c:3:22: error: invalid initializer
           struct S x = "0.2";
                  ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:35: error: invalid initializer
           void foo() { struct S x = "0.2"; x = "0.2"; }
                               ^
test.c:3:50: error: incompatible types when assigning to type ‘struct S’ from type ‘char *’
           void foo() { struct S x = "0.2"; x = "0.2"; }
                                              ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf15_7(): Unit = {
    /* gcc reports:
test.c:3:22: error: invalid initializer
           struct S x = &"foo";
                  ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:35: error: invalid initializer
           void foo() { struct S x = &"foo"; x = &"foo"; }
                               ^
test.c:3:51: error: incompatible types when assigning to type ‘struct S’ from type ‘char (*)[4]’
           void foo() { struct S x = &"foo"; x = &"foo"; }
                                               ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf15_8(): Unit = {
    /* gcc reports:
test.c:3:22: error: invalid initializer
           struct S x = *"foo";
                  ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:35: error: invalid initializer
           void foo() { struct S x = *"foo"; x = *"foo"; }
                               ^
test.c:3:51: error: incompatible types when assigning to type ‘struct S’ from type ‘char’
           void foo() { struct S x = *"foo"; x = *"foo"; }
                                               ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf15_9(): Unit = {
    /* gcc reports:
test.c:3:28: error: lvalue required as unary ‘&’ operand
           struct S x = &1;
                        ^

    */
    error(
      """
              struct S { int x; int y; };

              struct S x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:3:41: error: lvalue required as unary ‘&’ operand
           void foo() { struct S x = &1; x = &1; }
                                     ^
test.c:3:49: error: lvalue required as unary ‘&’ operand
           void foo() { struct S x = &1; x = &1; }
                                             ^

    */
    error(
      """
              struct S { int x; int y; };

              void foo() { struct S x = &1; x = &1; }
                """)
  }


  @Test def test_conf16_0(): Unit = {
    /* gcc reports:
test.c:1:22: error: invalid initializer
           struct { float b; } x = 0;
                  ^

    */
    error(
      """
              struct { float b; } x = 0;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:35: error: invalid initializer
           void foo() { struct { float b; } x = 0; x = 0; }
                               ^
test.c:1:57: error: incompatible types when assigning to type ‘struct <anonymous>’ from type ‘int’
           void foo() { struct { float b; } x = 0; x = 0; }
                                                     ^

    */
    error(
      """
              void foo() { struct { float b; } x = 0; x = 0; }
                """)
  }


  @Test def test_conf16_1(): Unit = {
    /* gcc reports:
test.c:1:22: error: invalid initializer
           struct { float b; } x = 1;
                  ^

    */
    error(
      """
              struct { float b; } x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:35: error: invalid initializer
           void foo() { struct { float b; } x = 1; x = 1; }
                               ^
test.c:1:57: error: incompatible types when assigning to type ‘struct <anonymous>’ from type ‘int’
           void foo() { struct { float b; } x = 1; x = 1; }
                                                     ^

    */
    error(
      """
              void foo() { struct { float b; } x = 1; x = 1; }
                """)
  }


  @Test def test_conf16_2(): Unit = {
    /* gcc reports:
test.c:1:22: error: invalid initializer
           struct { float b; } x = -1;
                  ^

    */
    error(
      """
              struct { float b; } x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:35: error: invalid initializer
           void foo() { struct { float b; } x = -1; x = -1; }
                               ^
test.c:1:58: error: incompatible types when assigning to type ‘struct <anonymous>’ from type ‘int’
           void foo() { struct { float b; } x = -1; x = -1; }
                                                      ^

    */
    error(
      """
              void foo() { struct { float b; } x = -1; x = -1; }
                """)
  }


  @Test def test_conf16_3(): Unit = {
    /* gcc reports:
test.c:1:22: error: invalid initializer
           struct { float b; } x = 1l;
                  ^

    */
    error(
      """
              struct { float b; } x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:35: error: invalid initializer
           void foo() { struct { float b; } x = 1l; x = 1l; }
                               ^
test.c:1:58: error: incompatible types when assigning to type ‘struct <anonymous>’ from type ‘long int’
           void foo() { struct { float b; } x = 1l; x = 1l; }
                                                      ^

    */
    error(
      """
              void foo() { struct { float b; } x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf16_4(): Unit = {
    /* gcc reports:
test.c:1:22: error: invalid initializer
           struct { float b; } x = 0xa4;
                  ^

    */
    error(
      """
              struct { float b; } x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:35: error: invalid initializer
           void foo() { struct { float b; } x = 0xa4; x = 0xa4; }
                               ^
test.c:1:60: error: incompatible types when assigning to type ‘struct <anonymous>’ from type ‘int’
           void foo() { struct { float b; } x = 0xa4; x = 0xa4; }
                                                        ^

    */
    error(
      """
              void foo() { struct { float b; } x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf16_5(): Unit = {
    /* gcc reports:
test.c:1:22: error: invalid initializer
           struct { float b; } x = 0.2;
                  ^

    */
    error(
      """
              struct { float b; } x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:35: error: invalid initializer
           void foo() { struct { float b; } x = 0.2; x = 0.2; }
                               ^
test.c:1:59: error: incompatible types when assigning to type ‘struct <anonymous>’ from type ‘double’
           void foo() { struct { float b; } x = 0.2; x = 0.2; }
                                                       ^

    */
    error(
      """
              void foo() { struct { float b; } x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf16_6(): Unit = {
    /* gcc reports:
test.c:1:22: error: invalid initializer
           struct { float b; } x = "0.2";
                  ^

    */
    error(
      """
              struct { float b; } x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:35: error: invalid initializer
           void foo() { struct { float b; } x = "0.2"; x = "0.2"; }
                               ^
test.c:1:61: error: incompatible types when assigning to type ‘struct <anonymous>’ from type ‘char *’
           void foo() { struct { float b; } x = "0.2"; x = "0.2"; }
                                                         ^

    */
    error(
      """
              void foo() { struct { float b; } x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf16_7(): Unit = {
    /* gcc reports:
test.c:1:22: error: invalid initializer
           struct { float b; } x = &"foo";
                  ^

    */
    error(
      """
              struct { float b; } x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:35: error: invalid initializer
           void foo() { struct { float b; } x = &"foo"; x = &"foo"; }
                               ^
test.c:1:62: error: incompatible types when assigning to type ‘struct <anonymous>’ from type ‘char (*)[4]’
           void foo() { struct { float b; } x = &"foo"; x = &"foo"; }
                                                          ^

    */
    error(
      """
              void foo() { struct { float b; } x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf16_8(): Unit = {
    /* gcc reports:
test.c:1:22: error: invalid initializer
           struct { float b; } x = *"foo";
                  ^

    */
    error(
      """
              struct { float b; } x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:35: error: invalid initializer
           void foo() { struct { float b; } x = *"foo"; x = *"foo"; }
                               ^
test.c:1:62: error: incompatible types when assigning to type ‘struct <anonymous>’ from type ‘char’
           void foo() { struct { float b; } x = *"foo"; x = *"foo"; }
                                                          ^

    */
    error(
      """
              void foo() { struct { float b; } x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf16_9(): Unit = {
    /* gcc reports:
test.c:1:39: error: lvalue required as unary ‘&’ operand
           struct { float b; } x = &1;
                                   ^

    */
    error(
      """
              struct { float b; } x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:52: error: lvalue required as unary ‘&’ operand
           void foo() { struct { float b; } x = &1; x = &1; }
                                                ^
test.c:1:60: error: lvalue required as unary ‘&’ operand
           void foo() { struct { float b; } x = &1; x = &1; }
                                                        ^

    */
    error(
      """
              void foo() { struct { float b; } x = &1; x = &1; }
                """)
  }


  @Test def test_conf17_0(): Unit = {
    correct(
      """
              volatile int x = 0;
                """)
    correct(
      """
              void foo() { volatile int x = 0; x = 0; }
                """)
  }


  @Test def test_conf17_1(): Unit = {
    correct(
      """
              volatile int x = 1;
                """)
    correct(
      """
              void foo() { volatile int x = 1; x = 1; }
                """)
  }


  @Test def test_conf17_2(): Unit = {
    correct(
      """
              volatile int x = -1;
                """)
    correct(
      """
              void foo() { volatile int x = -1; x = -1; }
                """)
  }


  @Test def test_conf17_3(): Unit = {
    correct(
      """
              volatile int x = 1l;
                """)
    correct(
      """
              void foo() { volatile int x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf17_4(): Unit = {
    correct(
      """
              volatile int x = 0xa4;
                """)
    correct(
      """
              void foo() { volatile int x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf17_5(): Unit = {
    correct(
      """
              volatile int x = 0.2;
                """)
    correct(
      """
              void foo() { volatile int x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf17_6(): Unit = {
    /* gcc reports:
test.c:1:32: warning: initialization makes integer from pointer without a cast [enabled by default]
           volatile int x = "0.2";
                            ^
test.c:1:15: error: initializer element is not computable at load time
           volatile int x = "0.2";
           ^

    */
    error(
      """
              volatile int x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:45: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { volatile int x = "0.2"; x = "0.2"; }
                                         ^
test.c:1:54: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { volatile int x = "0.2"; x = "0.2"; }
                                                  ^

    */
    warning(
      """
              void foo() { volatile int x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf17_7(): Unit = {
    /* gcc reports:
test.c:1:32: warning: initialization makes integer from pointer without a cast [enabled by default]
           volatile int x = &"foo";
                            ^
test.c:1:15: error: initializer element is not computable at load time
           volatile int x = &"foo";
           ^

    */
    error(
      """
              volatile int x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:45: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { volatile int x = &"foo"; x = &"foo"; }
                                         ^
test.c:1:55: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { volatile int x = &"foo"; x = &"foo"; }
                                                   ^

    */
    warning(
      """
              void foo() { volatile int x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf17_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           volatile int x = *"foo";
           ^

    */
    error(
      """
              volatile int x = *"foo";
                """)
    correct(
      """
              void foo() { volatile int x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf17_9(): Unit = {
    /* gcc reports:
test.c:1:32: error: lvalue required as unary ‘&’ operand
           volatile int x = &1;
                            ^

    */
    error(
      """
              volatile int x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:45: error: lvalue required as unary ‘&’ operand
           void foo() { volatile int x = &1; x = &1; }
                                         ^
test.c:1:53: error: lvalue required as unary ‘&’ operand
           void foo() { volatile int x = &1; x = &1; }
                                                 ^

    */
    error(
      """
              void foo() { volatile int x = &1; x = &1; }
                """)
  }


  @Test def test_conf18_0(): Unit = {
    correct(
      """
              const int x = 0;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const int x = 0; x = 0; }
           ^

    */
    error(
      """
              void foo() { const int x = 0; x = 0; }
                """)
  }


  @Test def test_conf18_1(): Unit = {
    correct(
      """
              const int x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const int x = 1; x = 1; }
           ^

    */
    error(
      """
              void foo() { const int x = 1; x = 1; }
                """)
  }


  @Test def test_conf18_2(): Unit = {
    correct(
      """
              const int x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const int x = -1; x = -1; }
           ^

    */
    error(
      """
              void foo() { const int x = -1; x = -1; }
                """)
  }


  @Test def test_conf18_3(): Unit = {
    correct(
      """
              const int x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const int x = 1l; x = 1l; }
           ^

    */
    error(
      """
              void foo() { const int x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf18_4(): Unit = {
    correct(
      """
              const int x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const int x = 0xa4; x = 0xa4; }
           ^

    */
    error(
      """
              void foo() { const int x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf18_5(): Unit = {
    correct(
      """
              const int x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const int x = 0.2; x = 0.2; }
           ^

    */
    error(
      """
              void foo() { const int x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf18_6(): Unit = {
    /* gcc reports:
test.c:1:29: warning: initialization makes integer from pointer without a cast [enabled by default]
           const int x = "0.2";
                         ^
test.c:1:15: error: initializer element is not computable at load time
           const int x = "0.2";
           ^

    */
    error(
      """
              const int x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:42: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { const int x = "0.2"; x = "0.2"; }
                                      ^
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const int x = "0.2"; x = "0.2"; }
           ^

    */
    error(
      """
              void foo() { const int x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf18_7(): Unit = {
    /* gcc reports:
test.c:1:29: warning: initialization makes integer from pointer without a cast [enabled by default]
           const int x = &"foo";
                         ^
test.c:1:15: error: initializer element is not computable at load time
           const int x = &"foo";
           ^

    */
    error(
      """
              const int x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:42: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { const int x = &"foo"; x = &"foo"; }
                                      ^
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const int x = &"foo"; x = &"foo"; }
           ^

    */
    error(
      """
              void foo() { const int x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf18_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           const int x = *"foo";
           ^

    */
    error(
      """
              const int x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const int x = *"foo"; x = *"foo"; }
           ^

    */
    error(
      """
              void foo() { const int x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf18_9(): Unit = {
    /* gcc reports:
test.c:1:29: error: lvalue required as unary ‘&’ operand
           const int x = &1;
                         ^

    */
    error(
      """
              const int x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:42: error: lvalue required as unary ‘&’ operand
           void foo() { const int x = &1; x = &1; }
                                      ^
test.c:1:50: error: lvalue required as unary ‘&’ operand
           void foo() { const int x = &1; x = &1; }
                                              ^

    */
    error(
      """
              void foo() { const int x = &1; x = &1; }
                """)
  }


  @Test def test_conf19_0(): Unit = {
    correct(
      """
              const double x = 0;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const double x = 0; x = 0; }
           ^

    */
    error(
      """
              void foo() { const double x = 0; x = 0; }
                """)
  }


  @Test def test_conf19_1(): Unit = {
    correct(
      """
              const double x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const double x = 1; x = 1; }
           ^

    */
    error(
      """
              void foo() { const double x = 1; x = 1; }
                """)
  }


  @Test def test_conf19_2(): Unit = {
    correct(
      """
              const double x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const double x = -1; x = -1; }
           ^

    */
    error(
      """
              void foo() { const double x = -1; x = -1; }
                """)
  }


  @Test def test_conf19_3(): Unit = {
    correct(
      """
              const double x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const double x = 1l; x = 1l; }
           ^

    */
    error(
      """
              void foo() { const double x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf19_4(): Unit = {
    correct(
      """
              const double x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const double x = 0xa4; x = 0xa4; }
           ^

    */
    error(
      """
              void foo() { const double x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf19_5(): Unit = {
    correct(
      """
              const double x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const double x = 0.2; x = 0.2; }
           ^

    */
    error(
      """
              void foo() { const double x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf19_6(): Unit = {
    /* gcc reports:
test.c:1:32: error: incompatible types when initializing type ‘double’ using type ‘char *’
           const double x = "0.2";
                            ^

    */
    error(
      """
              const double x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:45: error: incompatible types when initializing type ‘double’ using type ‘char *’
           void foo() { const double x = "0.2"; x = "0.2"; }
                                         ^
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const double x = "0.2"; x = "0.2"; }
           ^

    */
    error(
      """
              void foo() { const double x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf19_7(): Unit = {
    /* gcc reports:
test.c:1:32: error: incompatible types when initializing type ‘double’ using type ‘char (*)[4]’
           const double x = &"foo";
                            ^

    */
    error(
      """
              const double x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:45: error: incompatible types when initializing type ‘double’ using type ‘char (*)[4]’
           void foo() { const double x = &"foo"; x = &"foo"; }
                                         ^
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const double x = &"foo"; x = &"foo"; }
           ^

    */
    error(
      """
              void foo() { const double x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf19_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           const double x = *"foo";
           ^

    */
    error(
      """
              const double x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:15: error: assignment of read-only variable ‘x’
           void foo() { const double x = *"foo"; x = *"foo"; }
           ^

    */
    error(
      """
              void foo() { const double x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf19_9(): Unit = {
    /* gcc reports:
test.c:1:32: error: lvalue required as unary ‘&’ operand
           const double x = &1;
                            ^

    */
    error(
      """
              const double x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:45: error: lvalue required as unary ‘&’ operand
           void foo() { const double x = &1; x = &1; }
                                         ^
test.c:1:53: error: lvalue required as unary ‘&’ operand
           void foo() { const double x = &1; x = &1; }
                                                 ^

    */
    error(
      """
              void foo() { const double x = &1; x = &1; }
                """)
  }


  @Test def test_conf20_0(): Unit = {
    correct(
      """
              volatile double x = 0;
                """)
    correct(
      """
              void foo() { volatile double x = 0; x = 0; }
                """)
  }


  @Test def test_conf20_1(): Unit = {
    correct(
      """
              volatile double x = 1;
                """)
    correct(
      """
              void foo() { volatile double x = 1; x = 1; }
                """)
  }


  @Test def test_conf20_2(): Unit = {
    correct(
      """
              volatile double x = -1;
                """)
    correct(
      """
              void foo() { volatile double x = -1; x = -1; }
                """)
  }


  @Test def test_conf20_3(): Unit = {
    correct(
      """
              volatile double x = 1l;
                """)
    correct(
      """
              void foo() { volatile double x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf20_4(): Unit = {
    correct(
      """
              volatile double x = 0xa4;
                """)
    correct(
      """
              void foo() { volatile double x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf20_5(): Unit = {
    correct(
      """
              volatile double x = 0.2;
                """)
    correct(
      """
              void foo() { volatile double x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf20_6(): Unit = {
    /* gcc reports:
test.c:1:35: error: incompatible types when initializing type ‘double’ using type ‘char *’
           volatile double x = "0.2";
                               ^

    */
    error(
      """
              volatile double x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: error: incompatible types when initializing type ‘double’ using type ‘char *’
           void foo() { volatile double x = "0.2"; x = "0.2"; }
                                            ^
test.c:1:57: error: incompatible types when assigning to type ‘double’ from type ‘char *’
           void foo() { volatile double x = "0.2"; x = "0.2"; }
                                                     ^

    */
    error(
      """
              void foo() { volatile double x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf20_7(): Unit = {
    /* gcc reports:
test.c:1:35: error: incompatible types when initializing type ‘double’ using type ‘char (*)[4]’
           volatile double x = &"foo";
                               ^

    */
    error(
      """
              volatile double x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: error: incompatible types when initializing type ‘double’ using type ‘char (*)[4]’
           void foo() { volatile double x = &"foo"; x = &"foo"; }
                                            ^
test.c:1:58: error: incompatible types when assigning to type ‘double’ from type ‘char (*)[4]’
           void foo() { volatile double x = &"foo"; x = &"foo"; }
                                                      ^

    */
    error(
      """
              void foo() { volatile double x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf20_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: initializer element is not constant
           volatile double x = *"foo";
           ^

    */
    error(
      """
              volatile double x = *"foo";
                """)
    correct(
      """
              void foo() { volatile double x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf20_9(): Unit = {
    /* gcc reports:
test.c:1:35: error: lvalue required as unary ‘&’ operand
           volatile double x = &1;
                               ^

    */
    error(
      """
              volatile double x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:48: error: lvalue required as unary ‘&’ operand
           void foo() { volatile double x = &1; x = &1; }
                                            ^
test.c:1:56: error: lvalue required as unary ‘&’ operand
           void foo() { volatile double x = &1; x = &1; }
                                                    ^

    */
    error(
      """
              void foo() { volatile double x = &1; x = &1; }
                """)
  }


  @Test def test_conf21_0(): Unit = {
    correct(
      """
              int * x = 0;
                """)
    correct(
      """
              void foo() { int * x = 0; x = 0; }
                """)
  }


  @Test def test_conf21_1(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = 1;
                     ^

    */
    warning(
      """
              int * x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 1; x = 1; }
                                  ^
test.c:1:43: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 1; x = 1; }
                                       ^

    */
    warning(
      """
              void foo() { int * x = 1; x = 1; }
                """)
  }


  @Test def test_conf21_2(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = -1;
                     ^

    */
    warning(
      """
              int * x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = -1; x = -1; }
                                  ^
test.c:1:44: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = -1; x = -1; }
                                        ^

    */
    warning(
      """
              void foo() { int * x = -1; x = -1; }
                """)
  }


  @Test def test_conf21_3(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = 1l;
                     ^

    */
    warning(
      """
              int * x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 1l; x = 1l; }
                                  ^
test.c:1:44: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 1l; x = 1l; }
                                        ^

    */
    warning(
      """
              void foo() { int * x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf21_4(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = 0xa4;
                     ^

    */
    warning(
      """
              int * x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 0xa4; x = 0xa4; }
                                  ^
test.c:1:46: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = 0xa4; x = 0xa4; }
                                          ^

    */
    warning(
      """
              void foo() { int * x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf21_5(): Unit = {
    /* gcc reports:
test.c:1:25: error: incompatible types when initializing type ‘int *’ using type ‘double’
           int * x = 0.2;
                     ^

    */
    error(
      """
              int * x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: error: incompatible types when initializing type ‘int *’ using type ‘double’
           void foo() { int * x = 0.2; x = 0.2; }
                                  ^
test.c:1:45: error: incompatible types when assigning to type ‘int *’ from type ‘double’
           void foo() { int * x = 0.2; x = 0.2; }
                                         ^

    */
    error(
      """
              void foo() { int * x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf21_6(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization from incompatible pointer type [enabled by default]
           int * x = "0.2";
                     ^

    */
    warning(
      """
              int * x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { int * x = "0.2"; x = "0.2"; }
                                  ^
test.c:1:47: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { int * x = "0.2"; x = "0.2"; }
                                           ^

    */
    warning(
      """
              void foo() { int * x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf21_7(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization from incompatible pointer type [enabled by default]
           int * x = &"foo";
                     ^

    */
    warning(
      """
              int * x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { int * x = &"foo"; x = &"foo"; }
                                  ^
test.c:1:48: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { int * x = &"foo"; x = &"foo"; }
                                            ^

    */
    warning(
      """
              void foo() { int * x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf21_8(): Unit = {
    /* gcc reports:
test.c:1:25: warning: initialization makes pointer from integer without a cast [enabled by default]
           int * x = *"foo";
                     ^
test.c:1:15: error: initializer element is not constant
           int * x = *"foo";
           ^

    */
    error(
      """
              int * x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = *"foo"; x = *"foo"; }
                                  ^
test.c:1:48: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { int * x = *"foo"; x = *"foo"; }
                                            ^

    */
    warning(
      """
              void foo() { int * x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf21_9(): Unit = {
    /* gcc reports:
test.c:1:25: error: lvalue required as unary ‘&’ operand
           int * x = &1;
                     ^

    */
    error(
      """
              int * x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:38: error: lvalue required as unary ‘&’ operand
           void foo() { int * x = &1; x = &1; }
                                  ^
test.c:1:46: error: lvalue required as unary ‘&’ operand
           void foo() { int * x = &1; x = &1; }
                                          ^

    */
    error(
      """
              void foo() { int * x = &1; x = &1; }
                """)
  }


  @Test def test_conf22_0(): Unit = {
    correct(
      """
              const int * x = 0;
                """)
    correct(
      """
              void foo() { const int * x = 0; x = 0; }
                """)
  }


  @Test def test_conf22_1(): Unit = {
    /* gcc reports:
test.c:1:31: warning: initialization makes pointer from integer without a cast [enabled by default]
           const int * x = 1;
                           ^

    */
    warning(
      """
              const int * x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = 1; x = 1; }
                                        ^
test.c:1:49: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = 1; x = 1; }
                                             ^

    */
    warning(
      """
              void foo() { const int * x = 1; x = 1; }
                """)
  }


  @Test def test_conf22_2(): Unit = {
    /* gcc reports:
test.c:1:31: warning: initialization makes pointer from integer without a cast [enabled by default]
           const int * x = -1;
                           ^

    */
    warning(
      """
              const int * x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = -1; x = -1; }
                                        ^
test.c:1:50: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = -1; x = -1; }
                                              ^

    */
    warning(
      """
              void foo() { const int * x = -1; x = -1; }
                """)
  }


  @Test def test_conf22_3(): Unit = {
    /* gcc reports:
test.c:1:31: warning: initialization makes pointer from integer without a cast [enabled by default]
           const int * x = 1l;
                           ^

    */
    warning(
      """
              const int * x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = 1l; x = 1l; }
                                        ^
test.c:1:50: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = 1l; x = 1l; }
                                              ^

    */
    warning(
      """
              void foo() { const int * x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf22_4(): Unit = {
    /* gcc reports:
test.c:1:31: warning: initialization makes pointer from integer without a cast [enabled by default]
           const int * x = 0xa4;
                           ^

    */
    warning(
      """
              const int * x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = 0xa4; x = 0xa4; }
                                        ^
test.c:1:52: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = 0xa4; x = 0xa4; }
                                                ^

    */
    warning(
      """
              void foo() { const int * x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf22_5(): Unit = {
    /* gcc reports:
test.c:1:31: error: incompatible types when initializing type ‘const int *’ using type ‘double’
           const int * x = 0.2;
                           ^

    */
    error(
      """
              const int * x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: error: incompatible types when initializing type ‘const int *’ using type ‘double’
           void foo() { const int * x = 0.2; x = 0.2; }
                                        ^
test.c:1:51: error: incompatible types when assigning to type ‘const int *’ from type ‘double’
           void foo() { const int * x = 0.2; x = 0.2; }
                                               ^

    */
    error(
      """
              void foo() { const int * x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf22_6(): Unit = {
    /* gcc reports:
test.c:1:31: warning: initialization from incompatible pointer type [enabled by default]
           const int * x = "0.2";
                           ^

    */
    warning(
      """
              const int * x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { const int * x = "0.2"; x = "0.2"; }
                                        ^
test.c:1:53: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { const int * x = "0.2"; x = "0.2"; }
                                                 ^

    */
    warning(
      """
              void foo() { const int * x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf22_7(): Unit = {
    /* gcc reports:
test.c:1:31: warning: initialization from incompatible pointer type [enabled by default]
           const int * x = &"foo";
                           ^

    */
    warning(
      """
              const int * x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { const int * x = &"foo"; x = &"foo"; }
                                        ^
test.c:1:54: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { const int * x = &"foo"; x = &"foo"; }
                                                  ^

    */
    warning(
      """
              void foo() { const int * x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf22_8(): Unit = {
    /* gcc reports:
test.c:1:31: warning: initialization makes pointer from integer without a cast [enabled by default]
           const int * x = *"foo";
                           ^
test.c:1:15: error: initializer element is not constant
           const int * x = *"foo";
           ^

    */
    error(
      """
              const int * x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = *"foo"; x = *"foo"; }
                                        ^
test.c:1:54: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { const int * x = *"foo"; x = *"foo"; }
                                                  ^

    */
    warning(
      """
              void foo() { const int * x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf22_9(): Unit = {
    /* gcc reports:
test.c:1:31: error: lvalue required as unary ‘&’ operand
           const int * x = &1;
                           ^

    */
    error(
      """
              const int * x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:44: error: lvalue required as unary ‘&’ operand
           void foo() { const int * x = &1; x = &1; }
                                        ^
test.c:1:52: error: lvalue required as unary ‘&’ operand
           void foo() { const int * x = &1; x = &1; }
                                                ^

    */
    error(
      """
              void foo() { const int * x = &1; x = &1; }
                """)
  }


  @Test def test_conf23_0(): Unit = {
    correct(
      """
              volatile int * x = 0;
                """)
    correct(
      """
              void foo() { volatile int * x = 0; x = 0; }
                """)
  }


  @Test def test_conf23_1(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           volatile int * x = 1;
                              ^

    */
    warning(
      """
              volatile int * x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = 1; x = 1; }
                                           ^
test.c:1:52: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = 1; x = 1; }
                                                ^

    */
    warning(
      """
              void foo() { volatile int * x = 1; x = 1; }
                """)
  }


  @Test def test_conf23_2(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           volatile int * x = -1;
                              ^

    */
    warning(
      """
              volatile int * x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = -1; x = -1; }
                                           ^
test.c:1:53: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = -1; x = -1; }
                                                 ^

    */
    warning(
      """
              void foo() { volatile int * x = -1; x = -1; }
                """)
  }


  @Test def test_conf23_3(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           volatile int * x = 1l;
                              ^

    */
    warning(
      """
              volatile int * x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = 1l; x = 1l; }
                                           ^
test.c:1:53: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = 1l; x = 1l; }
                                                 ^

    */
    warning(
      """
              void foo() { volatile int * x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf23_4(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           volatile int * x = 0xa4;
                              ^

    */
    warning(
      """
              volatile int * x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = 0xa4; x = 0xa4; }
                                           ^
test.c:1:55: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = 0xa4; x = 0xa4; }
                                                   ^

    */
    warning(
      """
              void foo() { volatile int * x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf23_5(): Unit = {
    /* gcc reports:
test.c:1:34: error: incompatible types when initializing type ‘volatile int *’ using type ‘double’
           volatile int * x = 0.2;
                              ^

    */
    error(
      """
              volatile int * x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: error: incompatible types when initializing type ‘volatile int *’ using type ‘double’
           void foo() { volatile int * x = 0.2; x = 0.2; }
                                           ^
test.c:1:54: error: incompatible types when assigning to type ‘volatile int *’ from type ‘double’
           void foo() { volatile int * x = 0.2; x = 0.2; }
                                                  ^

    */
    error(
      """
              void foo() { volatile int * x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf23_6(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization from incompatible pointer type [enabled by default]
           volatile int * x = "0.2";
                              ^

    */
    warning(
      """
              volatile int * x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { volatile int * x = "0.2"; x = "0.2"; }
                                           ^
test.c:1:56: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { volatile int * x = "0.2"; x = "0.2"; }
                                                    ^

    */
    warning(
      """
              void foo() { volatile int * x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf23_7(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization from incompatible pointer type [enabled by default]
           volatile int * x = &"foo";
                              ^

    */
    warning(
      """
              volatile int * x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization from incompatible pointer type [enabled by default]
           void foo() { volatile int * x = &"foo"; x = &"foo"; }
                                           ^
test.c:1:57: warning: assignment from incompatible pointer type [enabled by default]
           void foo() { volatile int * x = &"foo"; x = &"foo"; }
                                                     ^

    */
    warning(
      """
              void foo() { volatile int * x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf23_8(): Unit = {
    /* gcc reports:
test.c:1:34: warning: initialization makes pointer from integer without a cast [enabled by default]
           volatile int * x = *"foo";
                              ^
test.c:1:15: error: initializer element is not constant
           volatile int * x = *"foo";
           ^

    */
    error(
      """
              volatile int * x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: warning: initialization makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = *"foo"; x = *"foo"; }
                                           ^
test.c:1:57: warning: assignment makes pointer from integer without a cast [enabled by default]
           void foo() { volatile int * x = *"foo"; x = *"foo"; }
                                                     ^

    */
    warning(
      """
              void foo() { volatile int * x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf23_9(): Unit = {
    /* gcc reports:
test.c:1:34: error: lvalue required as unary ‘&’ operand
           volatile int * x = &1;
                              ^

    */
    error(
      """
              volatile int * x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:47: error: lvalue required as unary ‘&’ operand
           void foo() { volatile int * x = &1; x = &1; }
                                           ^
test.c:1:55: error: lvalue required as unary ‘&’ operand
           void foo() { volatile int * x = &1; x = &1; }
                                                   ^

    */
    error(
      """
              void foo() { volatile int * x = &1; x = &1; }
                """)
  }


  @Test def test_conf24_0(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = 0;
           ^

    */
    error(
      """
              void x = 0;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = 0; x = 0; }
                             ^

    */
    error(
      """
              void foo() { void x = 0; x = 0; }
                """)
  }


  @Test def test_conf24_1(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = 1;
           ^

    */
    error(
      """
              void x = 1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = 1; x = 1; }
                             ^

    */
    error(
      """
              void foo() { void x = 1; x = 1; }
                """)
  }


  @Test def test_conf24_2(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = -1;
           ^

    */
    error(
      """
              void x = -1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = -1; x = -1; }
                             ^

    */
    error(
      """
              void foo() { void x = -1; x = -1; }
                """)
  }


  @Test def test_conf24_3(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = 1l;
           ^

    */
    error(
      """
              void x = 1l;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = 1l; x = 1l; }
                             ^

    */
    error(
      """
              void foo() { void x = 1l; x = 1l; }
                """)
  }


  @Test def test_conf24_4(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = 0xa4;
           ^

    */
    error(
      """
              void x = 0xa4;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = 0xa4; x = 0xa4; }
                             ^

    */
    error(
      """
              void foo() { void x = 0xa4; x = 0xa4; }
                """)
  }


  @Test def test_conf24_5(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = 0.2;
           ^

    */
    error(
      """
              void x = 0.2;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = 0.2; x = 0.2; }
                             ^

    */
    error(
      """
              void foo() { void x = 0.2; x = 0.2; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf24_6(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = "0.2";
           ^

    */
    error(
      """
              void x = "0.2";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = "0.2"; x = "0.2"; }
                             ^
test.c:1:37: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { void x = "0.2"; x = "0.2"; }
                                 ^
test.c:1:46: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { void x = "0.2"; x = "0.2"; }
                                          ^

    */
    error(
      """
              void foo() { void x = "0.2"; x = "0.2"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf24_7(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = &"foo";
           ^

    */
    error(
      """
              void x = &"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = &"foo"; x = &"foo"; }
                             ^
test.c:1:37: warning: initialization makes integer from pointer without a cast [enabled by default]
           void foo() { void x = &"foo"; x = &"foo"; }
                                 ^
test.c:1:47: warning: assignment makes integer from pointer without a cast [enabled by default]
           void foo() { void x = &"foo"; x = &"foo"; }
                                           ^

    */
    error(
      """
              void foo() { void x = &"foo"; x = &"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf24_8(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = *"foo";
           ^

    */
    error(
      """
              void x = *"foo";
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = *"foo"; x = *"foo"; }
                             ^

    */
    error(
      """
              void foo() { void x = *"foo"; x = *"foo"; }
                """)
  }


  @Ignore("initializers are not analyzed precisely enough")
  @Test def test_conf24_9(): Unit = {
    /* gcc reports:
test.c:1:15: error: variable ‘x’ has initializer but incomplete type
           void x = &1;
           ^
test.c:1:24: error: lvalue required as unary ‘&’ operand
           void x = &1;
                    ^

    */
    error(
      """
              void x = &1;
                """)
    /* gcc reports:
test.c: In function ‘foo’:
test.c:1:33: error: variable or field ‘x’ declared void
           void foo() { void x = &1; x = &1; }
                             ^
test.c:1:37: error: lvalue required as unary ‘&’ operand
           void foo() { void x = &1; x = &1; }
                                 ^
test.c:1:45: error: lvalue required as unary ‘&’ operand
           void foo() { void x = &1; x = &1; }
                                         ^

    */
    error(
      """
              void foo() { void x = &1; x = &1; }
                """)
  }


}