package leetcode.daily;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: lsf Time: 9/24/20-9:08 AM
 */
public class Solution36 {

  private List<Integer> res = new LinkedList<Integer>();
  private Integer pre;
  private int count;
  private int max;

  public int[] findMode(TreeNode root) {
    function1(root);
    int[] nums = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      nums[i] = res.get(i);
    }
    return nums;
  }

  /**
   * 方法一:中序遍历
   *
   * @param root
   */
  public void function1(TreeNode root) {
    if (root == null) {
      return;
    }
    function1(root.left);
    if (pre == null || pre == root.val) {
      count++;
    } else {
      count = 1;
    }
    if (max == count) {
      res.add(root.val);
    } else if (max < count) {
      res.clear();
      res.add(root.val);
      max = count;
    }
    pre = root.val;
    function1(root.right);
  }
}
