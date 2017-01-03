package net.nuttle.dsa.sec2;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
  @Test
  public void testBubbleSort() {
    int[] data = {7, 3, 2, 0, 11};
    int[] sorted = {0, 2, 3, 7, 11};
    BubbleSort.sortInt(data);
    for (int i = 0; i < data.length; i++) {
      Assert.assertEquals("Unexpected item " + i, sorted[i], data[i]);
    }
  }

}
