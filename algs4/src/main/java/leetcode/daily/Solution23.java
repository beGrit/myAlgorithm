package leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Author: lsf Time: 9/12/20-8:56 AM
 */
public class Solution23 {

  private List<Double> res = new ArrayList<>();
  private Map<Integer, Integer> map = new HashMap<>();

  public List<Double> averageOfLevels(TreeNode root) {
    helper(root, 0);
    return res;
  }

  public void helper(TreeNode root, int layer) {
    if (root == null) {
      return;
    } else {
      int count;
      int val = root.val;
      if (map.containsKey(layer)) {
        count = map.get(layer);
        double avg = (val + count * res.get(layer)) / (count + 1);
        res.set(layer, avg);
      } else {
        count = 0;
        res.add(layer,val / 1.0);
      }
      map.put(layer, count + 1);
      helper(root.left, layer + 1);
      helper(root.right, layer + 1);
    }
  }

  public List<Double> averageOfLevels2(TreeNode root) {
    List<Double> averages = new ArrayList<Double>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      double sum = 0;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node.val;
        TreeNode left = node.left, right = node.right;
        if (left != null) {
          queue.offer(left);
        }
        if (right != null) {
          queue.offer(right);
        }
      }
      averages.add(sum / size);
    }
    return averages;
  }


}
