package leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 9/26/20-8:50 AM
 */
public class Solution38 {

  private List<List<Integer>> res = new ArrayList<>();

  public static void main(String[] args) {
    Integer[] integers = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
    TreeNode root = TreeUtil.init(integers);
    Solution38 solution38 = new Solution38();
    solution38.pathSum(root,22);
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    helper(root, new ArrayList<>(), 0, sum);
    return res;
  }

  public void helper(TreeNode root, List<Integer> path, int sum, int target) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      path.add(root.val);
      sum += root.val;
      if (sum == target) {
        res.add(new ArrayList<>(path));
      }
      path.remove(path.size() - 1);
      sum -= root.val;
      return;
    }
    TreeNode lChild = root.left;
    TreeNode rChild = root.right;
    path.add(root.val);
    helper(lChild, path, sum + root.val, target);
    helper(rChild, path, sum + root.val, target);
    path.remove(path.size() - 1);
  }
}
