package leetcode.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: lsf Time: 9/28/20-9:34 AM
 */
public class Solution40 {


  Node last = null, nextStart = null;

  public Node connect(Node root) {
    return function2(root);
  }

  /**
   * 方法一:层序遍历
   *
   * @param root
   * @return
   */
  public Node function1(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      Queue<Node> nextQ = new LinkedList();
      Node pre = null;
      while (!queue.isEmpty()) {
        Node cur = queue.poll();
        if (cur.left != null) {
          nextQ.offer(cur.left);
        }
        if (cur.right != null) {
          nextQ.offer(cur.right);
        }
        if (pre == null) {
          pre = cur;
          continue;
        }
        pre.next = cur;
        pre = cur;
      }
      if (pre != null) {
        pre.next = null;
      }
      queue = nextQ;
    }
    return root;
  }

  public Node function2(Node root) {
    if (root == null) {
      return null;
    }
    Node start = root;
    while (start != null) {
      last = null;
      nextStart = null;
      for (Node p = start; p != null; p = p.next) {
        if (p.left != null) {
          handle(p.left);
        }
        if (p.right != null) {
          handle(p.right);
        }
      }
      start = nextStart;
    }
    return root;
  }

  public void handle(Node p) {
    if (last != null) {
      last.next = p;
    }
    if (nextStart == null) {
      nextStart = p;
    }
    last = p;
  }

  public Node function3(Node root) {
    if (root == null) {
      return null;
    }
    Node r = root;
    Node nextHead = root.left != null ? root.left : root.right;
    Node pre = nextHead;
    Node cur = null;
    while (nextHead != null) {
      if (r == null) {
        r = nextHead;
        nextHead = null;
        pre = null;
        cur = null;
      }

      // 当前 r 节点不空
      while (r != null) {
        // leftChild 不为null
        if (r.left != null) {
          if (nextHead == null) {
            nextHead = r.left;
            pre = nextHead;
          }
          cur = r.left;
          if (pre != cur) {
            pre.next = cur;
            pre = cur;
          }
        }
        // rightChild 不为null
        if (r.right != null) {
          if (nextHead == null) {
            nextHead = r.right;
            pre = nextHead;
          }
          cur = r.right;
          if (pre != cur) {
            pre.next = cur;
            pre = cur;
          }
        }
        r = r.next;
      }
    }
    return root;
  }

  class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
}
