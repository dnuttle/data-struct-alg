package net.nuttle.dsa.sec4;

import org.junit.Assert;
import org.junit.Test;

public class DoublyLinkedListTest {

  @Test
  public void test() {
    DoublyLinkedList<String> ll = new DoublyLinkedListImpl<>();
    ll.insertAtHead("abc");
    ll.insertAtHead("def");
    DoublyLinkedListNode<String> node = ll.getHead().getNextNode();
    Assert.assertEquals("abc", node.getValue());
  }
  
  @Test
  public void testSort() {
    DoublyLinkedList<String> ll = new DoublyLinkedListImpl<>();
    ll.insertAtHead("def");
    ll.insertAtHead("ghi");
    ll.insertAtHead("abc");
    ll.sort();
    Assert.assertEquals("{abc, def, ghi}", ll.toString());
    
    ll = new DoublyLinkedListImpl<>();
    ll.insertAtHead("abc");
    ll.insertAtHead("def");
    ll.insertAtHead("ghi");
    ll.sort();
    Assert.assertEquals("{abc, def, ghi}", ll.toString());
    
    ll = new DoublyLinkedListImpl<>();
    ll.insertAtHead("abc");
    ll.insertAtHead("ghi");
    ll.insertAtHead("def");
  }
  
  @Test
  public void testSortNulls() {
    DoublyLinkedList<String> ll = new DoublyLinkedListImpl<>();
    ll.insertAtHead(null);
    ll.insertAtHead("def");
    ll.insertAtHead("abc");
    ll.sort();
    Assert.assertEquals("{[null], abc, def}", ll.toString());

  
    ll = new DoublyLinkedListImpl<>();
    ll.insertAtHead("def");
    ll.insertAtHead("abc");
    ll.insertAtHead(null);
    ll.sort();
    Assert.assertEquals("{[null], abc, def}", ll.toString());
}
}
