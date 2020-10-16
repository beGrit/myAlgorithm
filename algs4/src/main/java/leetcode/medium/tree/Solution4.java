package leetcode.medium.tree;

/**
 * Author: lsf Time: 9/29/20-2:47 PM
 */
public class Solution4 {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Node r = root;
    Node n = r.left;
    Node pre = r.left;
    Node cur = null;
    while (n != null) {
      if (r == null) {
        r = n;
        n = n.left;
        pre = n;
      } else {
        cur = r.left;
        pre.next = cur;
        pre = cur;
        cur = r.right;
        pre.next = cur;
        pre = cur;
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
