package net.nuttle.dsa.sec5;


import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

  @Test(expected=NullPointerException.class)
  public void test() {
    Queue<String> q = new QueueImpl<>();
    q.enqueue("abc");
    q.enqueue("def");
    Assert.assertEquals("abc", q.dequeue());
    Assert.assertEquals("def", q.dequeue());
    q.dequeue();
  }

}
