package leetcode.daily;

/**
 * Author: lsf Time: 9/19/20-4:25 PM
 */
public class Solution31 {

  private int sum = 0;

  public int sumOfLeftLeaves(TreeNode root) {
    helper(root);
    return sum;
  }

  /**
   * 方法一:递归
   */
  public void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null && root.left.left == null && root.left.right == null) {
      sum += root.left.val;
    }
    helper(root.left);
    helper(root.right);
  }
}
