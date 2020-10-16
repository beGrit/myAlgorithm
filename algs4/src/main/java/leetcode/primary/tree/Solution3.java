package leetcode.primary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: lsf Time: 9/12/20-7:35 PM
 */
public class Solution3 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int curSize = queue.size();
      List<Integer> subList = new ArrayList<>();
      for (int i = 0; i < curSize; i++) {
        TreeNode t1 = queue.poll();
        if (t1 == null) {
          continue;
        } else {
          queue.offer(t1.left);
          queue.offer(t1.right);
          subList.add(t1.val);
        }
      }
      if (!subList.isEmpty()) {
        res.add(subList);
      }
    }
    return res;
  }
}
