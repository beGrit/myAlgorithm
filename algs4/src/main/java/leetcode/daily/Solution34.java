package leetcode.daily;

import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 9/22/20-9:59 AM
 */
public class Solution34 {

  private int count = 0;
  private boolean flag = false;

  public int minCameraCover(TreeNode root) {
    return function1(root);
  }

  /**
   * 方法一:递归
   *
   * @param root
   * @return
   */
  public int function1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    int n = helper(root);
    if (n == 3) {
      count++;
    }
    return count;
  }

  /**
   * 叶子: 0 安装:1 可装可不装:2
   *
   * @param root
   * @return
   */
  public int helper(TreeNode root) {
    if (root == null) {
      return 2;
    }
    if (root.left == null && root.right == null) {
      return 0;
    }
    int left = helper(root.left);
    int right = helper(root.right);
    if (left == 0 || right == 0 || left == 3 || right == 3) {
      count++;
      return 1;
    } else if (left == 1 || right == 1) {
      return 2;
    } else {
      return 3;
    }
  }
}
