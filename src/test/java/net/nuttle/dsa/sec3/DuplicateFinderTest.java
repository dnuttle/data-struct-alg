package net.nuttle.dsa.sec3;


import org.junit.Assert;
import org.junit.Test;

public class DuplicateFinderTest {
  
  @Test
  public void testDuplicateFinder() {
    boolean result = DuplicateFinder.hasDuplicateCharacters("anaconda");
    Assert.assertTrue(result);
    result = DuplicateFinder.hasDuplicateCharacters("great");
    Assert.assertFalse(result);
  }

}
