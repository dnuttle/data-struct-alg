package net.nuttle.dsa.sec1;


import org.junit.Assert;
import org.junit.Test;

public class EuclidTest {

  @Test
  public void testFindGCD() throws Exception {
    int gcd = Euclid.findGCD(54, 24);
    Assert.assertEquals(6, gcd);
    gcd = Euclid.findGCD(23,  7);
    Assert.assertEquals(1, gcd);
  }
  
  @Test(expected=Exception.class)
  public void testFindGCDBadParams() throws Exception {
    Euclid.findGCD(1, 3);
  }
}
