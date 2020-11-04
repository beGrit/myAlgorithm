package leetcode.daily.tree;

import java.util.Deque;
import java.util.LinkedList;
import leetcode.daily.dataobject.TreeNode;
import leetcode.daily.util.TreeUtil;

/**
 * Author: lsf Time: 10/29/20-8:26 AM
 */
public class Solution1 {

  private int res = 0;

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    TreeNode root = TreeUtil.init(new Integer[]{4});
    solution1.sumNumbers(root);
  }

  public int sumNumbers(TreeNode root) {
    bfs(root);
    return res;
  }

  // 方法一:DFS深度优先搜索
  public void helper(TreeNode root, int preSum) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      res += preSum + root.val;
      return;
    }
    helper(root.left, preSum * 10 + root.val);
    helper(root.right, preSum * 10 + root.val);
  }

  // 方法二:BFS广度优先搜索
  public void bfs(TreeNode root) {
    if (root == null) {
      return;
    }
    Deque<Object[]> dq = new LinkedList<>();
    dq.offer(new Object[]{root, root.val});
    TreeNode tn = null;
    while (tn != null || !dq.isEmpty()) {
      Object[] objects = dq.poll();
      tn = (TreeNode) objects[0];
      if (tn.left == null && tn.right == null) { // 叶子节点
        res += (Integer) objects[1];
        tn = null;
        continue;
      }
      if (tn.left != null) {
        dq.offer(new Object[]{tn.left, tn.left.val + (Integer) objects[1] * 10});
      }
      if (tn.right != null) {
        dq.offer(new Object[]{tn.right, tn.right.val + (Integer) objects[1] * 10});
      }
    }
  }
}
