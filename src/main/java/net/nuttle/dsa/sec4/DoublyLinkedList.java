package net.nuttle.dsa.sec4;

public interface DoublyLinkedList<T extends Comparable<T>> {

  DoublyLinkedListNode<T> getHead();
  
  void setHead(DoublyLinkedListNode<T> head);
  
  void insertAtHead(T value);
  
  DoublyLinkedListNode<T> deleteHead();
  
  int size();
  
  T get(int index);
  
  DoublyLinkedListNode<T> find(T value);
  
  int findIndex(T value);
  
  void sort();

}
