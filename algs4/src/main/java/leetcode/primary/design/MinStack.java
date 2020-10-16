package leetcode.primary.design;

import java.util.Stack;

/**
 * Author: lsf Time: 9/20/20-11:13 AM
 */
public class MinStack {
  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> minStack = new Stack<>();
  /** initialize your data structure here. */
  public MinStack() {

  }

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty()) {
      minStack.push(x);
      return;
    }
    int minStackTop = minStack.peek();
    if (x < minStackTop) {
      minStack.push(x);
    } else {
      minStack.push(minStackTop);
    }
  }

  public void pop() {
    minStack.pop();
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

}
