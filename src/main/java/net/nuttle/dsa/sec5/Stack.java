package net.nuttle.dsa.sec5;

public interface Stack<T> {

  T pop();
  
  void push(T value);
  
  T peek();
}
