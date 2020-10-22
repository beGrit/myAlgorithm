package leetcode.daily;

import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 10/12/20-9:10 AM
 */
public class Solution52 {

  private int res = Integer.MAX_VALUE;
  private int pre = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    inOrder(root);
    return res;
  }

  public void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    int val = root.val;
    if (pre != Integer.MAX_VALUE) {
      this.res = Math.min(res, val - pre);
    }
    pre = val;
    inOrder(root.right);
  }
}
