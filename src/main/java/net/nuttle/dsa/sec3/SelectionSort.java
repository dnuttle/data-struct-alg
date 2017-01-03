package net.nuttle.dsa.sec3;

public class SelectionSort {

  /**
   * Steps: n^2 + 3n
   * This is in every case, not just worst case.
   * If a list is completely or largely sorted already, bubble sort is more efficient.
   * @param input
   */
  public static void sortInt(int[] input) {
    for (int i = 0; i < input.length - 2; i++) {
      int minIndex = i;
      for (int j = i; j < input.length - 1; j++) {
        if (input[j] < input[minIndex]) {
          minIndex = j;
        }
      }
      int tmp = input[minIndex];
      input[minIndex] = input[i];
      input[i] = tmp;
    }
  }
}
