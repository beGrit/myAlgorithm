package leetcode.daily;

import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 9/21/20-1:10 PM
 */
public class Solution33 {
  public TreeNode convertBST(TreeNode root) {
    helper(root);
    return root;
  }
  private int sum = 0;
  public void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.right);
    root.val += sum;
    sum = root.val;
    helper(root.left);
  }

  public static void main(String[] args) {
    Solution33 solution33 = new Solution33();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(13);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(7);
    solution33.helper(root);
  }
}
