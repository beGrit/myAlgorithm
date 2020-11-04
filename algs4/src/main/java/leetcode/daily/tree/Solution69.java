package leetcode.daily.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 10/27/20-9:09 AM
 */
public class Solution69 {

  private List<Integer> res = new ArrayList<>();

  public List<Integer> preorderTraversal(TreeNode root) {
    function2(root);
    return res;
  }

  /**
   * 方法一:递归
   *
   * @param root
   */
  public void recursionPre(TreeNode root) {
    res.add(root.val);
    recursionPre(root.left);
    recursionPre(root.right);
  }

  /**
   * 方法二:迭代
   *
   * @param root
   */
  public void function2(TreeNode root) {
    TreeNode tn = root;
    Stack<TreeNode> stack = new Stack<>();
    while (tn != null || !stack.isEmpty()) {
      while (tn != null) {
        res.add(tn.val);
        stack.push(tn);
        tn = tn.left;
      }
      tn = stack.pop();
      tn = tn.right;
    }
  }

  /**
   * 方法三:morris解法 基本思想:利用好大量的空指针,使得各个节点能联通
   *
   * @param root
   */
  public void morris(TreeNode root) {
    TreeNode pre;
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == null) {
        res.add(cur.val);
        cur = cur.right;
      } else {
        pre = cur.left;
        // 寻找前驱节点
        while (pre.right != cur && pre.right != null) {
          pre = pre.right;
        }
        if (pre.right == null) {
          res.add(cur.val);
          pre.right = cur;
          cur = pre.right;
          cur = cur.left;
        } else {
          pre.right = null;
          cur = cur.right;
        }
      }
    }
  }
}
