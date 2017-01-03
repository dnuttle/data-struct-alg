package net.nuttle.dsa.sec2;

public class BubbleSort {

  /**
   * Steps (worst case): 4n^2
   * Steps (best case): n^2
   * @param input
   */
  public static void sortInt(int[] input) {
    for (int i = 0; i < input.length-1; i++) {
      for (int j = i + 1; j < input.length-1; j++) {
        if (input[j] < input[i]) {
          int tmp = input[i];
          input[i] = input[j];
          input[j] = tmp;
        }
      }
    }
  }
  
}
