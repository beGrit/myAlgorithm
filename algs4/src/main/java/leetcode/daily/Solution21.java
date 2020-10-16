package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: lsf Time: 9/9/20-9:34 AM
 */
public class Solution21 {

  private List<List<Integer>> res = new ArrayList<>();

  public static void main(String[] args) {
    Solution21 solution21 = new Solution21();
    int[] candidates = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    solution21.combinationSum2(candidates, target);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    int[] nums = Arrays.copyOf(candidates, candidates.length);
    helper(nums, new ArrayList<>(), 0, target, 0);
    return res;
  }

  /**
   * 方法一:递归回溯
   */
  public void helper(int[] nums, List<Integer> curList, int curSum, int target, int i) {
    if (curSum == target) {
      res.add(new ArrayList<>(curList));
      return;
    }
    int len = nums.length;
    for (; i < len; i++) {
      if (curSum + nums[i] > target) {
        continue;
      } else { // <=
        curList.add(nums[i]);
        helper(nums, curList, curSum + nums[i], target, i);

        // 递归回溯
        curList.remove(curList.size() - 1);
      }
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    int[] nums = Arrays.copyOf(candidates, candidates.length);
    Arrays.sort(nums);
    helper2(nums, new ArrayList<>(), 0, target, 0);
    return res;
  }

  /**
   * @param nums   给定的 candidates(候选值) 数组的副本
   * @param path   记录当前递归子层下所经过的路径
   * @param curSum Sum(path)
   * @param target 需要达到的数
   * @param begin  当前递归层初始位置
   */
  public void helper2(int[] nums, List<Integer> path, int curSum, int target, int begin) {
    if (curSum == target) { // 若当前Sum(path)满足target,记录该path
      res.add(new ArrayList<>(path));
      return;
    }
    int len = nums.length;
    for (int i = begin; i < len; i++) {
      // 若当前递归层迭代时遇到连续出现的数 : 剪枝
      if (i > begin && nums[i] == nums[i - 1]) {
        continue;
      }
      // Sum(path) > target : 剪枝
      if (curSum + nums[i] > target) {
        continue;
      }
      path.add(nums[i]);
      helper2(nums, path, curSum + nums[i], target, i + 1);
      // 递归回溯
      path.remove(path.size() - 1);
    }
  }
}
