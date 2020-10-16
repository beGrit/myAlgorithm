package leetcode.daily;

/**
 * Author: lsf Time: 9/30/20-6:45 PM
 */
public class Solution42 {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    TreeNode tn = root;
    while (true) {
      if (val > tn.val) {
        if (tn.right == null) {
          tn.right = new TreeNode(val) ;
          tn.right.left = null;
          tn.right.right = null;
        }
        tn = tn.right;
      } else if (val < tn.val) {
        if (tn.left == null) {
          tn.left = new TreeNode(val);
          tn.left.left = null;
          tn.left.right = null;
        }
        tn = tn.left;
      } else if (val == tn.val) {
        break;
      }
    }
    return root;
  }
}
