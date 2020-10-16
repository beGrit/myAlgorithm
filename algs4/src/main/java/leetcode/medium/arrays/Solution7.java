package leetcode.medium.arrays;

/**
 * Author: lsf Time: 9/27/20-9:11 AM
 */
public class Solution7 {
  public boolean increasingTriplet(int[] nums) {
    return function2(nums);
  }

  public boolean function1(int[] nums) {
    int minIndex = 0;
    int secondMinIndex = 0;
    int len = nums.length;
    for (int i = 1; i < len; i++) {
      if (minIndex < secondMinIndex && nums[i] > nums[minIndex] && nums[i] > nums[secondMinIndex]) {
        return true;
      }
      if (nums[i] == nums[minIndex]) {
        continue;
      }
      if (nums[i] == nums[secondMinIndex]) {
        secondMinIndex = i;
        continue;
      }
      if (nums[i] < nums[minIndex]) {
        secondMinIndex = minIndex;
        minIndex = i;
      } else {
        secondMinIndex = i;
      }
    }
    return false;
  }

  public boolean function2(int[] nums) {
    int len = nums.length;
    if (len < 3) {
      return false;
    }
    int small = Integer.MAX_VALUE;
    int mid = Integer.MAX_VALUE;
    for (int i = 0; i < len; i++) {
      if (nums[i] <= small) {
        small = nums[i];
      } else if (nums[i] <= mid) {
        mid = nums[i];
      } else if (nums[i] > mid) {
        return true;
      }
    }
    return false;
  }
}
