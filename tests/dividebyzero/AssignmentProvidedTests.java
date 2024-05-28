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

  public static void times(int y) {
    int zero = 0;
    int one = 1;
    int negOne = -1;

    System.out.println(zero * zero);
    System.out.println(zero * one);
    System.out.println(zero * negOne);
    System.out.println(zero * y);
  }

  public static void mod() {
    int a = -1 % 3;
    int b = 1 % -3;
    int c = 1 % 3;

    // :: error: divide.by.zero
    int error1 = 1 % 0;
    // :: error: divide.by.zero
    int error2 = 0 % 0;

    int d = 0 % 5;
  }

  public static void modIfEvenOdd(int y) {
    if (y % 2 == 0) {
      System.out.println("even");
    }

    if (y % 2 == 1) {
      System.out.println("odd");
    }
  }

  public static void divKnownDenom(int y) {
    int n = 4;
    n = n - 5;
    // Will error because nonzero / (nonzero - nonzero) = nonzero / top
    // :: error: divide.by.zero
    y = 1 / n;

    int one = 1 + 0;
    y = 1 / one;
  }

  public static void divUnknownDenom(int y, int x) {
    int one = 1 + 0;
    one = 1 / one;

    // :: error: divide.by.zero
    System.out.println(x / y);
    // :: error: divide.by.zero
    System.out.println(y / x);
  }

  public static void divGreaterThanRange(int y) {
    if (y > -4) {
      // :: error: divide.by.zero
      int error1 = 1 / y;

      // :: error: divide.by.zero
      int error2 = 4 / y;
    }

    if (y >= (4 * 0)) {
      // :: error: divide.by.zero
      int error3 = 1 / y;

      // :: error: divide.by.zero
      int error4 = 4 / y;
    }

    if (y > 10) {
      // :: error: divide.by.zero
      int a = 4 / y;  // nonzero / (top || nonzero)
    }
  }

  public static void divEquals(int y, int x) {
    if (y != -1) {
      // :: error: divide.by.zero
      int error1 = 1 / y;
    }

    if (y != 1) {
      // :: error: divide.by.zero
      int error2 = 1 / y;
    }

    if (y == 1) {
      int a = 1 / y;
    }

    int top = 6 - 5;
    if (y == top) {
      // :: error: divide.by.zero
      int error3 = top / y;
    }

    int one = 1;
    if (one == top) {
      int b = top / one;
    }

    if (y != 0) {
      System.out.println(x / y);
    } else {
      // :: error: divide.by.zero
      System.out.println(x / y);
    }
  }
}
