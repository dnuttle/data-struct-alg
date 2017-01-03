package net.nuttle.dsa.sec5;

import net.nuttle.dsa.sec4.DoublyLinkedListImpl.NodeImpl;
import net.nuttle.dsa.sec4.DoublyLinkedListNode;

public class QueueImpl<T extends Comparable<T>> implements Queue<T> {

  DoublyLinkedListNode<T> tail;
  DoublyLinkedListNode<T> head;
  
  public void enqueue(T value) {
    DoublyLinkedListNode<T> node = new NodeImpl<>(value);
    if (head != null) {
      head = node;
    } else if (tail == null) {
      head.setNextNode(node);
      node.setPreviousNode(head);
      tail = node;
    } else {
      tail.setNextNode(node);
      node.setPreviousNode(tail);
      tail = node;
    }
  }
  
  public T dequeue() {
    T value = tail.getValue();
    DoublyLinkedListNode<T> newTail = tail.getPreviousNode();
    tail.setPreviousNode(null);
    if (newTail != null) {
      newTail.setNextNode(null);
      tail = newTail;
    } else {
      tail = null;
      head = null;
    }
    return value;
  }
}
