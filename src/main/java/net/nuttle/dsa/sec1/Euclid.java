package net.nuttle.dsa.sec1;

public class Euclid {

  public static int findGCD(int num, int div) throws Exception {
    if (num < div) {
      throw new Exception("Numerator must be >= divisor");
    }
    int m = num;
    int n = div;
    while(true) {
      int r = m % n;
      if (r==0) {
        return n;
      }
      m = n;
      n = r;
    }
  }

}
