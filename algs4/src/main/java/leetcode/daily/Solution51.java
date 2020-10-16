package leetcode.daily;

import java.util.Arrays;

/**
 * Author: lsf Time: 10/11/20-7:09 PM
 */
public class Solution51 {

  private int sum;
  private boolean tag;
  private boolean isAwayFalse;

  public boolean canPartition(int[] nums) {
    if (nums.length == 0) {
      return false;
    }
    Arrays.sort(nums);
    for (int i : nums) {
      sum += i;
    }
    function1(nums, 0, 0);
    return tag;
  }

  public void function1(int[] nums, int begin, int curSum) {
    if (curSum >= sum - curSum) {
      isAwayFalse = true;
      if (curSum == sum - curSum) {
        tag = true;
      }
      return;
    }
    int len = nums.length;
    for (int i = begin; i < len; i++) {
      if (i != begin && nums[i] == nums[i - 1]) {
        continue;
      }
      function1(nums, i + 1, curSum + nums[i]);
      if (tag) {
        return;
      }
      if (isAwayFalse) {
        isAwayFalse = false;
        return;
      }
    }
  }

  public static void main(String[] args) {
    Solution51 solution51 = new Solution51();
    int[] nums = {2,2,1,1};
    solution51.canPartition(nums);
  }
}
