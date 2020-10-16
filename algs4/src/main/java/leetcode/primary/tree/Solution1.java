package leetcode.primary.tree;

import java.util.LinkedList;
import java.util.Stack;
import leetcode.In;

/**
 * Author: lsf Time: 9/5/20-5:42 PM
 */
public class Solution1 {

  private boolean b = true;
  private Stack<Integer> stack = new Stack<>();

  /**
   * 求解给定树的最大深度 方法一:递归求深度
   *
   * @param root
   * @return
   */
  public int maxDepth(TreeNode root) {
    /**
     * 若当前节点为空(null)节点
     */
    if (root == null) {
      return 0;
    }
    /**
     * 求左右子树的最大深度
     */
    int maxLeftH = maxDepth(root.left);
    int maxRightH = maxDepth(root.right);
    int h = Math.max(maxLeftH, maxRightH) + 1;
    return h;
  }

  /**
   * 求解给定树是不是BST(Binary Search Tree)
   *
   * @param root
   * @return
   */
  public boolean isValidBST(TreeNode root) {
    helper(root);
    return b;
  }

  /**
   * @param root
   * @return
   */
  public void helper(TreeNode root) {
    if (root == null || b == false) {
      return;
    } else {
      helper(root.left);

      if (!stack.isEmpty() && stack.peek() >= root.val) {
        b = false;
        return;
      }
      stack.push(root.val);

      helper(root.right);
    }
  }
}
