package leetcode.daily;

import java.util.LinkedList;
import java.util.Queue;
import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 9/16/20-8:46 AM
 */
public class Solution27 {
  public TreeNode invertTree(TreeNode root) {
    root = helper(root);
    return root;
  }

  /**
   * 方法一:递归
   * @param root
   * @return
   */
  public TreeNode helper(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = helper(root.left);
    TreeNode right = helper(root.right);
    root.right = left;
    root.left = right;
    return root;
  }

  /**
   * 方法二:BFS解法
   * @param root
   * @return
   */
  public TreeNode helper2(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode tn = queue.poll();
      if (tn == null) {
        continue;
      }
      // 交换
      TreeNode tmp = tn.left;
      tn.left = tn.right;
      tn.right = tmp;

      queue.offer(tn.left);
      queue.offer(tn.right);
    }
    return root;
  }
}
