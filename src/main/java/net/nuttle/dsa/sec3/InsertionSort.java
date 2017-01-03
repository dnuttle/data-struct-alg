package net.nuttle.dsa.sec3;


public class InsertionSort {

  /**
   * Steps (worst case): 
   * @param input
   */
  public static void sortInt(int[] input) {
    for (int i = 0; i < input.length; i++) {
      int current = input[i];
      int j = i - 1;
      while (j >= 0 && input[j] > current) {
        input[j+1] = input[j];
        j = j - 1;
      }
      input[j+1] = current;
    }
  }
  
  public static void sortEmployee(Employee[] input) {
    for (int i = 0; i < input.length; i++) {
      Employee current = input[i];
      int j = i - 1;
      while (j >= 0 && input[j].getEmployeeNumber() > current.getEmployeeNumber()) {
        input[j+1] = input[j];
        j = j - 1;
      }
      input[j+1] = current;
    }
  }
  
  public static <T extends Comparable<T>> void sort(T[] input) {
    for (int i = 0; i < input.length; i++) {
      T current = input[i];
      int j = i - 1;
      while (j >= 0 && input[j].compareTo(current) > 0) {
        input[j+1] = input[j];
        j = j - 1;
      }
      input[j+1] = current;
    }
    
  }
  
}
