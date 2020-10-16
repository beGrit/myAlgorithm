package leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 9/20/20-10:15 AM
 */
public class Solution32 {

  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      helper(nums, new ArrayList<>(), i, 0);
    }
    return res;
  }

  /**
   * 方法一:递归回溯
   *
   * @param nums
   * @param path
   * @param number
   * @param begin
   */
  public void helper(int[] nums, List<Integer> path, int number, int begin) {
    if (path.size() == number) {
      res.add(new ArrayList<>(path));
      return;
    }
    int len = nums.length;
    for (int i = begin; i < len; i++) {
      path.add(nums[i]);
      helper(nums, path, number, i + 1);
      // 回溯
      path.remove(path.size() - 1);
    }
  }
}
