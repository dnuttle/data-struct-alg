package net.nuttle.dsa.sec4;


public interface LinkedList<T> {
  
  LinkedListNode<T> getHead();
  
  void setHead(T head);
  
  void insertAtHead(T value);
  
  T deleteHead();
  
  int size();
  
  int findIndex(T value);
  
  LinkedListNode<T> find(T value);
  
  T get(int index);
 
  void reverse();
  
  void removeDuplicates();
  
  void deleteNode(LinkedListNode<T> node);
}
