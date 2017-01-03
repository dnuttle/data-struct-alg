package net.nuttle.dsa.sec4;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LinkedListTest {

  @Test
  public void testLinkedList() {
    LinkedList<String> ll = new LinkedListImpl<>();
    Assert.assertEquals(0,  ll.size());
    ll.insertAtHead("abc");
    ll.insertAtHead("def");
    
    Assert.assertEquals("{def, abc}", ll.toString());
    Assert.assertEquals(2, ll.size());
    Assert.assertEquals(0, ll.findIndex("def"));
    Assert.assertEquals(-1, ll.findIndex("jki"));
    Assert.assertEquals("abc",  ll.get(1));
    
    LinkedListNode<String> node = ll.getHead();
    Assert.assertEquals("def", node.getValue());
    node = node.getNextNode();
    Assert.assertEquals("abc",  node.getValue());
    node = node.getNextNode();
    Assert.assertNull(node);
    
    String s = ll.deleteHead();
    Assert.assertEquals("def", s);
    node = ll.getHead();
    Assert.assertEquals("abc", node.getValue());
    Assert.assertNull(node.getNextNode());
    Assert.assertEquals(1, ll.size());
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndexOutOfBounds() {
    LinkedList<String> ll = new LinkedListImpl<>();
    String s = ll.get(10);
  }
  
  @Test
  public void testPrimitive() {
    LinkedList<Integer> ll = new LinkedListImpl<>();
    ll.insertAtHead(10);
    ll.insertAtHead(12);
    Assert.assertEquals(2, ll.size());
  }
  
  @Test
  public void testReverse() {
    LinkedList<String> ll = new LinkedListImpl<>();
    ll.insertAtHead("abc");
    ll.insertAtHead("def");
    ll.insertAtHead("ghi");
    ll.reverse();
    Assert.assertEquals("{abc, def, ghi}", ll.toString());
  }
  
  @Test
  public void testRemoveDuplictes() {
    LinkedList<String> ll = new LinkedListImpl<>();
    ll.insertAtHead("abc");
    ll.insertAtHead("def");
    ll.insertAtHead("def");
    ll.insertAtHead("abc");
    ll.insertAtHead("ghi");
    ll.removeDuplicates();
    Assert.assertEquals("{ghi, abc, def}", ll.toString());
  }
  
  @Test
  public void testDeleteNode() {
    LinkedList<String> ll = new LinkedListImpl<>();
    ll.insertAtHead("ghi");
    ll.insertAtHead("def");
    ll.insertAtHead("abc");
    ll.deleteNode(ll.find("def"));
    Assert.assertEquals("{abc, ghi}", ll.toString());

    ll = new LinkedListImpl<>();
    ll.insertAtHead("ghi");
    ll.insertAtHead("def");
    ll.insertAtHead("abc");
    ll.deleteNode(ll.find("abc"));
    Assert.assertEquals("{def, ghi}", ll.toString());

    ll = new LinkedListImpl<>();
    ll.insertAtHead("ghi");
    ll.insertAtHead("def");
    ll.insertAtHead("abc");
    ll.deleteNode(ll.find("ghi"));
    Assert.assertEquals("{abc, def}", ll.toString());
}
}
