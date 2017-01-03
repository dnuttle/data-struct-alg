package net.nuttle.dsa.sec4;

import java.util.HashSet;
import java.util.Set;

public class LinkedListImpl<T> implements LinkedList<T> {

  private LinkedListNode<T> head;
  
  public LinkedListImpl(T head) {
    this.head = new NodeImpl<>(head);
  }
  
  public LinkedListImpl() {
    head = null;
  }
  
  @Override
  public void setHead(T head) {
    this.head = new NodeImpl<>(head);
  }

  @Override
  public LinkedListNode<T> getHead() {
    return head;
  }
  
  @Override
  public void insertAtHead(T value) {
    NodeImpl<T> newNode = new NodeImpl<>(value);
    newNode.setNextNode(head);
    head = newNode;
  }
  
  @Override
  public T deleteHead() {
    if (head == null) {
      return null;
    }
    LinkedListNode<T> tmp = head;
    head = head.getNextNode();
    tmp.setNextNode(null);
    return tmp.getValue();
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("{");
    LinkedListNode<T> node = head;
    String prefix = "";
    while (node != null) {
      sb.append(prefix);
      prefix = ", ";
      if (node.getValue() != null) {
        sb.append(node.getValue().toString());
      } else {
        sb.append("[null]");
      }
      node = node.getNextNode();
    }
    sb.append("}");
    return sb.toString();
  }
  
  @Override
  public int size() {
    int count = 0;
    LinkedListNode<T> curr = head;
    while (curr != null) {
      count++;
      curr = curr.getNextNode();
    }
    return count;
  }
  
  @Override
  public int findIndex(T value) {
    int index = 0;
    LinkedListNode<T> curr = head;
    //Optimize: Don't check value for null for each node in list
    if (value == null) {
      while (curr != null) {
        if (curr.getValue() == null) {
          return index;
        }
        index++;
        curr = curr.getNextNode();
      }
    } else {
      while (curr != null) {
        if (value.equals(curr.getValue())) {
          return index;
        }
        index++;
        curr = curr.getNextNode();
      }
    }
    return -1;
  }
  
  @Override
  public LinkedListNode<T> find(T value) {
    LinkedListNode<T> curr = head;
    //Optimize: Don't check value for null for each node in list
    if (value==null) {
      while (curr != null) {
        if (curr.getValue() == null) {
          return curr;
        }
        curr = curr.getNextNode();
      }
    } else {
      while (curr != null) {
        if (value.equals(curr.getValue())) {
          return curr;
        }
        curr = curr.getNextNode();
      }
    }
    return null;
  }
  
  @Override
  public T get(int index) {
    if (index < 0) {
      throw new IllegalArgumentException("Index must be >= 0");
    }
    LinkedListNode<T> curr = head;
    int count = 0;
    while (curr != null) {
      if (count == index) {
        return curr.getValue();
      }
      count++;
      curr = curr.getNextNode();
    }
    throw new IndexOutOfBoundsException("Index is larger than size of linked list");
  }
  
  @Override
  public void reverse() {
    @SuppressWarnings("unchecked")
    LinkedListNode<T>[] nodes = new LinkedListNode[this.size()];
    LinkedListNode<T> curr = head;
    int count = 0;
    while (curr != null) {
      nodes[count] = curr;
      curr = curr.getNextNode();
      count++;
    }
    head = nodes[nodes.length - 1];
    for (int i = nodes.length -1; i > 0; i--) {
      nodes[i].setNextNode(nodes[i-1]);
    }
    nodes[0].setNextNode(null);
  }
  
  @Override
  public void removeDuplicates() {
    Set<T> values = new HashSet<>();
    LinkedListNode<T> curr = head;
    LinkedListNode<T> prev = null;
    while (curr != null) {
      values.add(curr.getValue());
      curr = curr.getNextNode();
    }
    curr = head;
    while (curr != null) {
      if (values.contains(curr.getValue())) {
        values.remove(curr.getValue());
        prev = curr;
      } else {
        prev.setNextNode(curr.getNextNode());
      }
      curr = curr.getNextNode();
    }
  }
  
  @Override
  public void deleteNode(LinkedListNode<T> node) {
    
    /**
     * Better algorithm: copy value of next node to the node being deleted, then
     * delete the next node.  However, if it is the last node, then we have to use the naive
     * algorithm.
     */
    if (node.getNextNode() == null) {
      naiveDeleteNode(node);
    } else {
      node.setValue(node.getNextNode().getValue());
      node.setNextNode(node.getNextNode().getNextNode());
    }
  }

  /**
   * Naive algorithm to delete node.  Should be used only if
   * the node being deleted is the last one in the list.
   * @param node
   */
  private void naiveDeleteNode(LinkedListNode<T> node) {
    if (node == null) {
      return;
    }
    LinkedListNode<T> curr = head;
    LinkedListNode<T> prev = null;
    while (curr != null) {
      if (curr == node) {
        if (prev == null) {
          head = curr.getNextNode();
          curr.setNextNode(null);
        } else {
          prev.setNextNode(curr.getNextNode());
          curr.setNextNode(null);
        }
        return;
      }
      prev = curr;
      curr = curr.getNextNode();
    }
  }
  
  public static class NodeImpl<T> implements LinkedListNode<T> {
    private LinkedListNode<T> nextNode;
    private T data;
    
    public NodeImpl(T data) {
      this.data = data;
    }

    public LinkedListNode<T> getNextNode() {
      return nextNode;
    }
    
    @Override
    public void setNextNode(LinkedListNode<T> nextNode) {
      this.nextNode = nextNode;
    }
    
    @Override
    public T getValue() {
      return data;
    }
    
    @Override
    public String toString() {
      return data.toString();
    }
    
    @Override 
    public void setValue(T value) {
      this.data = value;
    }
    
  }
}
