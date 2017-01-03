package net.nuttle.dsa.sec5;

public interface Queue<T extends Comparable<T>> {

  public T dequeue();
  
  public void enqueue(T value);
}
