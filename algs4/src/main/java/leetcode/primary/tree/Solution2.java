package leetcode.primary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: lsf Time: 9/12/20-11:04 AM
 */
public class Solution2 {

  public boolean isSymmetric(TreeNode root) {
    return check(root, root);
  }

  /**
   * 方法一:递归
   *
   * @param p
   * @param q
   * @return
   */
  public boolean check(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
  }

  /**
   * 方法二:迭代
   *
   * @param u
   * @param v
   * @return
   */
  public boolean check2(TreeNode u, TreeNode v) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(u);
    queue.offer(v);
    while (!queue.isEmpty()) { // 非空
      TreeNode t1 = queue.poll();
      TreeNode t2 = queue.poll();

      /**
       *
       * 节点存在空的情况
       */
      if (t1 == null && t2 == null) {
        continue;
      } else if (t1 == null || t2 == null) {
        return false;
      }

      /**
       * 节点非空
       */
      if (t1.val == t2.val) {
        queue.offer(t1.left);
        queue.offer(t2.right);
        queue.offer(t1.right);
        queue.offer(t2.left);
      } else {
        return false;
      }
    }
    return true;
  }

//  /**
//   * 方法三:层序遍历
//   */
//  public boolean check3(TreeNode root) {
//    Queue<TreeNode> queue = new LinkedList<>();
//    while (!queue.isEmpty()) {
//
//    }
//  }
}
