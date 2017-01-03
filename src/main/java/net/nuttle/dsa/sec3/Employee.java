package net.nuttle.dsa.sec3;

public class Employee implements Comparable<Employee> {

  private int employeeNumber;
  private String firstName;
  private String lastName;
  private String emailId;

  public Employee(int empNum, String first, String last, String email) {
    employeeNumber = empNum;
    firstName = first;
    lastName = last;
    emailId = email;
  }
  
  public int compareTo(Employee e) {
    if (e == null) {
      return 1;
    }
    if (this.getEmployeeNumber() == e.getEmployeeNumber()) {
      return 0;
    }
    return (this.getEmployeeNumber() > e.getEmployeeNumber() ? 1 : -1);
  }
  
  public int getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(int employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
}
