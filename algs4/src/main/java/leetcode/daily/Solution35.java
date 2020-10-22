package leetcode.daily;

import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 9/23/20-9:30 AM
 */
public class Solution35 {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    return function1(t1, t2);
  }

  /**
   * 方法一:深度优先搜索(DFS)
   *
   * @param t1
   * @param t2
   * @return
   */
  public TreeNode function1(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    if (t1 != null && t2 != null) {
      t1.val += t2.val;
    } else if (t1 == null) {
      t1 = t2;
      return t1;
    } else {
      return t1;
    }
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;
  }
}
