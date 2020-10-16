package leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 9/8/20-8:53 AM
 */
public class Solution20 {
  private int k;
  private List<List<Integer>> lists = new ArrayList<>();

  public static void main(String[] args) {
    Solution20 solution20 = new Solution20();
    solution20.combine(4,3);
  }

  public List<List<Integer>> combine(int n, int k) {
    this.k = k;
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    helper(nums, new ArrayList<>(), 0);
    return lists;
  }

  // 递归回溯
  public void helper(int[] nums, List<Integer> list, int i) {
    if (list.size() == k) {
      lists.add(new ArrayList<>(list));
      return;
    }
    for (; i < nums.length; i++) {
      if (list.contains(nums[i])) {
        continue;
      }
      list.add(nums[i]);
      helper(nums, list, i + 1);

      // 递归回溯
      list.remove(list.size() - 1);
    }
  }
}
