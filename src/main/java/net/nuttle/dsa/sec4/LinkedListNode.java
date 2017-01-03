package net.nuttle.dsa.sec4;

public interface LinkedListNode<T> {

  LinkedListNode<T> getNextNode();
  
  T getValue();
  
  void setValue(T value);
  
  void setNextNode(LinkedListNode<T> nextNode);
}
