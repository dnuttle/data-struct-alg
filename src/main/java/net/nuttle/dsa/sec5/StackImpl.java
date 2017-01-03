package net.nuttle.dsa.sec5;

import net.nuttle.dsa.sec4.DoublyLinkedListImpl.NodeImpl;
import net.nuttle.dsa.sec4.DoublyLinkedListNode;

public class StackImpl<T extends Comparable<T>> implements Stack<T> {

  DoublyLinkedListNode<T> tail;
  
  @Override
  public void push(T value) {
    if (tail == null) {
      tail = new NodeImpl<T>(value);
    } else {
      DoublyLinkedListNode<T> node = new NodeImpl<>(value);
      tail.setNextNode(node);
      node.setPreviousNode(tail);
      tail = node;
    }
  }
  
  @Override
  public T peek() {
    return tail.getValue();
  }
  
  @Override
  public T pop() {
    T value = tail.getValue();
    if (tail.getPreviousNode() != null) {
      DoublyLinkedListNode<T> newTail = tail.getPreviousNode();
      tail.getPreviousNode().setNextNode(null);
      tail.setPreviousNode(null);
      tail = newTail;
    } else {
      tail = null;
    }
    return value;
  }
  
}
