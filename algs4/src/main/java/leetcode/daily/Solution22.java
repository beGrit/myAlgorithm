package leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 9/11/20-8:48 AM
 */
public class Solution22 {

  private List<List<Integer>> res = new ArrayList<>();

  public static void main(String[] args) {
    Solution22 solution22 = new Solution22();
    solution22.combinationSum3(3, 7);
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    int[] nums = new int[9];
    /**
     * 排序给数组赋初值
     */
    for (int i = 0; i < 9; i++) {
      nums[i] = i + 1;
    }
    helper(nums, new ArrayList<>(), 0, 0, n, k, 0);
    return res;
  }

  /**
   * 方法:递归回溯
   *
   * @param nums
   * @param path
   * @param curSum
   * @param begin
   */
  public void helper(int[] nums, List<Integer> path, int curSum, int count, int target, int k,
      int begin) {
    if (curSum == target && count == k ) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = begin; i < nums.length; i++) {
      /**
       * 剪枝
       * 当前和 > targetsolution22solution22
       * 当前数 > k
       */
      if (curSum + nums[i] > target || count + 1 > k) {
        continue;
      }
      curSum += nums[i];
      count++;
      path.add(nums[i]);
      helper(nums, path, curSum, count, target, k, i + 1);

      /**
       * 回溯
       */
      curSum -= nums[i];
      count--;
      path.remove(path.size() - 1);
    }
  }
}
