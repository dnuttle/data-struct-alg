package net.nuttle.dsa.sec4;

public class DoublyLinkedListImpl<T extends Comparable<T>> implements DoublyLinkedList<T> {

  private DoublyLinkedListNode<T> head = null;
  
  @Override
  public void insertAtHead(T value) {
    DoublyLinkedListNode<T> newNode = new NodeImpl<>(value);
    if (head == null) {
      head = newNode;
      return;
    }
    head.setPreviousNode(newNode);
    newNode.setNextNode(head);
    head = newNode;
  }
  
  @Override
  public DoublyLinkedListNode<T> getHead() {
    return head;
  }
  
  @Override
  public DoublyLinkedListNode<T> deleteHead() {
    if (head == null) {
      return null;
    }
    DoublyLinkedListNode<T> curr = head;
    head = head.getNextNode();
    if (head != null) {
      head.setPreviousNode(null);
    }
    curr.setPreviousNode(null);
    curr.setNextNode(null);
    return curr;
  }
  
  @Override
  public void setHead(DoublyLinkedListNode<T> head) {
    this.head = head;
  }
  
  @Override
  public int size() {
    int count = 0;
    DoublyLinkedListNode<T> curr = head;
    while (curr != null) {
      count++;
      curr = curr.getNextNode();
    }
    return count;
  }
  
  @Override
  public T get(int index) {
    if (index < 0) {
      throw new IllegalArgumentException("Index must be >= 0");
    }
    int count = 0;
    DoublyLinkedListNode<T> curr = head;
    while (curr != null) {
      if (count == index) {
        return curr.getValue();
      }
      count++;
    }
    throw new IndexOutOfBoundsException("Index is larger than size of linked list");
  }
  
  @Override
  public DoublyLinkedListNode<T> find(T value) {
    DoublyLinkedListNode<T> curr = head;
    if (value == null) {
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
  public int findIndex(T value) {
    int index = 0;
    DoublyLinkedListNode<T> curr = head;
    if (value == null) {
      while (curr != null) {
        if (curr.getValue() == null) {
          return index;
        }
        curr = curr.getNextNode();
        index++;
      }
    } else {
      while (curr != null) {
        if (value.equals(curr.getValue())) {
          return index;
        }
        curr = curr.getNextNode();
        index++;
      }
    }
    return -1;
 }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("{");
    DoublyLinkedListNode<T> node = head;
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
  public void sort() {
    if (head == null) {
      return;
    }
    DoublyLinkedListNode<T> curr = head;
    DoublyLinkedListNode<T> prev = head.getPreviousNode();
    //When curr is null, it means we have reached the nextNode of the last node
    while (curr != null) {
      //If prev is null, then it is the previousNode of head; no action
      while (prev != null) {
        if (prev.getValue() != null) {
          //If prev's value is null, this is considered the
          //minimum possible value, so no action needed
          //If curr's value is null (and we know prev's value is not), need to swap
          if (curr.getValue() == null) {
            swapNodes(curr, prev);
          } else if (prev.getValue() != null && prev.getValue().compareTo(curr.getValue()) > 0) {
            swapNodes(curr, prev);
          }
        }
        prev = prev.getPreviousNode();
      }
      curr = curr.getNextNode();
      if (curr != null) {
        prev = curr.getPreviousNode();
      }
    }
  }
  
  private void swapNodes(DoublyLinkedListNode<T> curr, DoublyLinkedListNode<T> prev) {
    DoublyLinkedListNode<T> currPrevNode = curr.getPreviousNode();
    DoublyLinkedListNode<T> currNextNode = curr.getNextNode();
    DoublyLinkedListNode<T> prevPrevNode = prev.getPreviousNode();
    DoublyLinkedListNode<T> prevNextNode = prev.getNextNode();
    
    
    if (prev.getNextNode() == curr) {
      prev.setNextNode(currNextNode);
      prev.setPreviousNode(curr);
      if (prevPrevNode != null) {
        prevPrevNode.setNextNode(curr);
      }
      if (currNextNode != null) {
        currNextNode.setPreviousNode(prev);
      }
      curr.setNextNode(prev);
      curr.setPreviousNode(prevPrevNode);
      //prevNextNode is equal to curr, so don't set its previousNode to curr
      //currPrevNode is equal to prev, so don't set its nextNode to prev
      if (curr.getPreviousNode() == null) {
        head = curr;
      }
      return;
    }

    prev.setNextNode(currNextNode);
    prev.setPreviousNode(currPrevNode);
    if (currNextNode != null) {
      currNextNode.setPreviousNode(prev);
    }
    if (currPrevNode != null) {
      currPrevNode.setNextNode(prev);
    }
    curr.setNextNode(prevNextNode);
    curr.setPreviousNode(prevPrevNode);
    if (prevNextNode != null) {
      prevNextNode.setNextNode(curr);
    }
    if (prevPrevNode != null) {
      prevPrevNode.setNextNode(curr);
    }
    //I believe this can never happen;
    //the swap with head node would occur when the nodes are adjacent(?)
    if (curr.getPreviousNode() == null) {
      head = curr;
    }
    
  }

  public static class NodeImpl<T extends Comparable<T>> implements DoublyLinkedListNode<T> {
    
    private T data;
    private DoublyLinkedListNode<T> next = null;
    private DoublyLinkedListNode<T> prev = null;
    
    public NodeImpl(T data) {
      this.data = data;
    }
    
    @Override
    public DoublyLinkedListNode<T> getNextNode() {
      return next;
    }
    
    @Override
    public void setNextNode(DoublyLinkedListNode<T> next) {
      this.next = next;
    }
    
    @Override
    public DoublyLinkedListNode<T> getPreviousNode() {
      return prev;
    }
    
    @Override
    public void setPreviousNode(DoublyLinkedListNode<T> prev) {
      this.prev = prev;
    }
    
    @Override
    public T getValue() {
      return data;
    }
    
    @Override
    public String toString() {
      return data.toString();
    }
    
  }
}
