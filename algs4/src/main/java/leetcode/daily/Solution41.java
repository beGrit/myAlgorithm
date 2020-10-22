package leetcode.daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 9/29/20-12:21 PM
 */
public class Solution41 {
  private List<Integer> list = new ArrayList<>();

  public List<Integer> postorderTraversal(TreeNode root) {
    function1(root);
    return list;
  }

  /**
   * 方法一:递归
   * @param root
   */
  public void function1(TreeNode root) {
    if (root == null) {
      return;
    }
    function1(root.left);
    function1(root.right);
    list.add(root.val);
  }

  /**
   * 方法二:迭代
   * @param root
   */
  public void function2(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode tn = root;
    stack.push(root);
    while (!stack.isEmpty()) {
      tn = stack.peek();
      tn = tn.left;
      while (tn != null) {
        stack.push(tn);
      }
    }
  }

  public List<Integer> function3(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }

    TreeNode p1 = root, p2 = null;

    while (p1 != null) {
      p2 = p1.left;
      if (p2 != null) {
        while (p2.right != null && p2.right != p1) {
          p2 = p2.right;
        }
        if (p2.right == null) {
          p2.right = p1;
          p1 = p1.left;
          continue;
        } else {
          p2.right = null;
          addPath(res, p1.left);
        }
      }
      p1 = p1.right;
    }
    addPath(res, root);
    return res;
  }

  public void addPath(List<Integer> res, TreeNode node) {
    List<Integer> tmp = new ArrayList<Integer>();
    while (node != null) {
      tmp.add(node.val);
      node = node.right;
    }
    for (int i = tmp.size() - 1; i >= 0; --i) {
      res.add(tmp.get(i));
    }
  }
}
