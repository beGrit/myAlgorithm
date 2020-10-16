package leetcode.medium.tree;

/**
 * Author: lsf Time: 9/29/20-3:31 PM
 */
public class Solution5 {

  public int kthSmallest(TreeNode root, int k) {
    this.k = k;
    helper(root);
    return res;
  }
  private int count = 0;
  private int k;
  private int res;

  /**
   * 方法一:中序遍历
   * @param root
   */
  public void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.left);
    count++;
    if (count == k) {
      res = root.val;
      return;
    }
    helper(root.right);
  }
}
