package net.nuttle.dsa.sec3;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

  @Test
  public void testSelectionSort() {
    int[] data = {7, 3, 2, 0, 11};
    int[] sorted = {0, 2, 3, 7, 11};
    SelectionSort.sortInt(data);
    for (int i = 0; i < data.length; i++) {
      Assert.assertEquals("Unexpected item " + i, sorted[i], data[i]);
    }
    
  }
  
}
