package leetcode.daily.tree;

import java.util.Deque;
import java.util.LinkedList;
import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 11/24/20-3:05 PM
 */
public class Solution2 {

  // 222. 完全二叉树的节点个数
  public int countNodes(TreeNode root) {
    return function(root);
  }
  // 方法二: BFS
  public int function(TreeNode root) {
    // 特殊情况
    if (root == null) {
      return 0;
    }
    int ans = 0;
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offer(root);
    while (!deque.isEmpty()) {
      TreeNode tn = deque.poll();
      ans++;
      if (tn.left != null) {
        deque.offer(tn.left);
      } else {
        break;
      }
      if (tn.right != null) {
        deque.offer(tn.right);
      } else {
        break;
      }
    }
    ans += deque.size();
    return ans;
  }

  // 方法一: 递归 (dfs)
  public int recursive(TreeNode root) {
    return 0;
  }

}
