package net.nuttle.dsa.sec3;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {
  @Test
  public void testInsertionSort() {
    int[] data = {2,5,8,12,7};
    int[] sorted = {2,5,7,8,12};
    InsertionSort.sortInt(data);
    for (int i = 0; i < data.length; i++) {
      Assert.assertEquals("Unexpected item " + i, sorted[i], data[i]);
    }
  }

  @Test
  public void testInsertionSort2() {
    int[] data = {7, 3, 2, 0, 11};
    int[] sorted = {0, 2, 3, 7, 11};
    InsertionSort.sortInt(data);
    for (int i = 0; i < data.length; i++) {
      Assert.assertEquals("Unexpected item " + i, sorted[i], data[i]);
    }
  }
  
  @Test
  public void testEmployeeInsertionSort() {
    Employee emp1 = new Employee(12345670, "Dan", "Smith", "dsmith@gmail.com");
    Employee emp2 = new Employee(12345671, "Dan", "Smith", "dsmith@gmail.com");
    Employee emp3 = new Employee(12345672, "Dan", "Smith", "dsmith@gmail.com");
    Employee emp4 = new Employee(12345673, "Dan", "Smith", "dsmith@gmail.com");
    Employee emp5 = new Employee(12345674, "Dan", "Smith", "dsmith@gmail.com");
    
    Employee[] data = {emp3, emp1, emp5, emp4, emp2};
    Employee[] sorted = {emp1, emp2, emp3, emp4, emp5};
    InsertionSort.sortEmployee(data);
    for (int i = 0; i < data.length; i++) {
      Assert.assertEquals("Unexpected item " + i, sorted[i], data[i]);
    }
  }
  
  @Test
  public void testGenericInsertionSort() {
    Employee emp1 = new Employee(12345670, "Dan", "Smith", "dsmith@gmail.com");
    Employee emp2 = new Employee(12345671, "Dan", "Smith", "dsmith@gmail.com");
    Employee emp3 = new Employee(12345672, "Dan", "Smith", "dsmith@gmail.com");
    Employee emp4 = new Employee(12345673, "Dan", "Smith", "dsmith@gmail.com");
    Employee emp5 = new Employee(12345674, "Dan", "Smith", "dsmith@gmail.com");
    
    Employee[] data = {emp3, emp1, emp5, emp4, emp2};
    Employee[] sorted = {emp1, emp2, emp3, emp4, emp5};
    InsertionSort.sort(data);
    for (int i = 0; i < data.length; i++) {
      Assert.assertEquals("Unexpected item " + i, sorted[i], data[i]);
    }
  }

}
