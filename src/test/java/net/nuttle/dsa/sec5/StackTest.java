package net.nuttle.dsa.sec5;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class StackTest {

  @Test
  public void test() {
    Stack<String> stack = new StackImpl<>();
    stack.push("abc");
    stack.push("def");
    Assert.assertEquals("def", stack.peek());
    Assert.assertEquals("def", stack.pop());
    Assert.assertEquals("abc", stack.pop());
  }

  @Test(expected=NullPointerException.class)
  public void testEmptyStack() {
    Stack<String> stack = new StackImpl<>();
    stack.push("abc");
    stack.push("def");
    Assert.assertEquals("def", stack.peek());
    Assert.assertEquals("def", stack.pop());
    Assert.assertEquals("abc", stack.pop());
    stack.pop();
  }
  
  @Test(expected=NullPointerException.class)
  public void test2() {
    Stack<String> stack = new StackImpl<>();
    stack.push("abc");
    stack.push("def");
    stack.pop();
    stack.pop();
    stack.push("ghi");
    Assert.assertEquals("ghi", stack.pop());
    stack.pop();
  }
}
