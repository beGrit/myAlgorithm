package leetcode.daily;

import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 9/25/20-8:31 AM
 */
public class Solution37 {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    TreeNode res = helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    return res;
  }

  public TreeNode helper(int[] inorder, int bg1, int end1, int[] postorder, int bg2, int end2) {
    if (bg1 > end1 && bg2 > end2) {
      return null;
    }
    int rootVal = postorder[end2];
    int index = bg1;
    while (inorder[index] != rootVal) {
      index++;
    }

    // 当前左子树的长度
    int leftLength = index - bg1;

    TreeNode root = new TreeNode(rootVal);
    root.left = helper(inorder, bg1, bg1 + leftLength - 1, postorder, bg2, bg2 + leftLength - 1);
    root.right = helper(inorder, bg1 + leftLength + 1, end1, postorder, bg2 + leftLength, end2 - 1);
    return root;
  }
}
