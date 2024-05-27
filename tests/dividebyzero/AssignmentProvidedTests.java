import org.checkerframework.checker.dividebyzero.qual.*;

// A simple test case for your divide-by-zero checker.
// The file contains "// ::" comments to indicate expected
// errors and warnings.
//
// Passing this test does not guarantee a perfect grade on this assignment,
// but it is an important start. You should always write your own test cases,
// in addition to using those provided to you.
class AssignmentProvidedTests {

  public static void f() {
    int one = 1;
    int zero = 0;
    // :: error: divide.by.zero
    int x = one / zero;
    int y = zero / one;
    // :: error: divide.by.zero
    int z = x / y;
    String s = "hello";
  }

  public static void g(int y) {
    if (y == 0) {
      // :: error: divide.by.zero
      int x = 1 / y;
    } else {
      int x = 1 / y;
    }

    if (y != 0) {
      int x = 1 / y;
    } else {
      // :: error: divide.by.zero
      int x = 1 / y;
    }

    if (!(y == 0)) {
      int x = 1 / y;
    } else {
      // :: error: divide.by.zero
      int x = 1 / y;
    }

    if (!(y != 0)) {
      // :: error: divide.by.zero
      int x = 1 / y;
    } else {
      int x = 1 / y;
    }

    if (y < 0) {
      int x = 1 / y;
    }

    if (y <= 0) {
      // :: error: divide.by.zero
      int x = 1 / y;
    }

    if (y > 0) {
      int x = 1 / y;
    }

    if (y >= 0) {
      // :: error: divide.by.zero
      int x = 1 / y;
    }
  }

  public static void h() {
    int zero_the_hard_way = 0 + 0 - 0 * 0;
    // :: error: divide.by.zero
    int x = 1 / zero_the_hard_way;

    int one_the_hard_way = 0 * 1 + 1;
    int y = 1 / one_the_hard_way;

    int zero_the_hard_way2 = 0 * (1 + 1);
    // :: error: divide.by.zero
    int z = 1 / zero_the_hard_way2;
  }

  public static void l() {
    // :: error: divide.by.zero
    int a = 1 / (1 - 1);

    int y = 1;
    // :: error: divide.by.zero
    int x = 1 / (y - y);

    int z = y - y;
    // :: error: divide.by.zero
    int k = 1 / z;
  }

  public static void mod() {
    int a = -1 % 3;
    int b = 1 % -3;
    int c = 1 % 3;

    // :: error: divide.by.zero
    int x = 1 % 0;
    // :: error: divide.by.zero
    int y = 0 % 0;

    int z = 0 % 5;
  }

  public static void div(int y) {
    if (y > -4) {
      // :: error: divide.by.zero
      int x = 1 / y;

      // :: error: divide.by.zero
      int z = 4 / y;
    }

    if (y >= (4 * 0)) {
      // :: error: divide.by.zero
      int x = 1 / y;

      // :: error: divide.by.zero
      int z = 4 / y;
    }

    if (y >= 4) {
      int x = 4 / y;
    }
  }
}
