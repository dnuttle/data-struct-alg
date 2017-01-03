package net.nuttle.dsa.sec4;

public interface DoublyLinkedListNode<T extends Comparable<T>> {

  DoublyLinkedListNode<T> getNextNode();
  
  void setNextNode(DoublyLinkedListNode<T> next);
  
  DoublyLinkedListNode<T> getPreviousNode();
  
  void setPreviousNode(DoublyLinkedListNode<T> prev);
  
  T getValue();
}
