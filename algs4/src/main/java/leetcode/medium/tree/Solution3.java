package leetcode.medium.tree;

/**
 * Author: lsf Time: 9/29/20-2:47 PM
 */
public class Solution3 {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
  }

  public TreeNode helper(int[] inorder, int bg1, int end1, int[] preorder, int bg2, int end2) {
    if (bg1 > end1 && bg2 > end2) {
      return null;
    }

    int rootVal = preorder[bg2];
    int index = bg1;
    while (inorder[index] != rootVal) {
      index++;
    }

    // 当前左子树的长度
    int leftLength = index - bg1;
    TreeNode root = new TreeNode(rootVal);
    root.left = helper(inorder, bg1, bg1 + leftLength - 1, preorder, bg2 + 1, bg2 + leftLength);
    root.right = helper(inorder, bg1 + leftLength + 1, end1, preorder, bg2 + leftLength + 1, end2);
    return root;

  }
}
