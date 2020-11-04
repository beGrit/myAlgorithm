package leetcode.medium.sortandsearch;

import java.util.Arrays;

/**
 * Author: lsf Time: 10/27/20-4:06 PM
 */
public class Solution7 {

  public static void main(String[] args) {
    Solution7 solution7 = new Solution7();
    int[] nums = {4};
    int target = 2;
    int res = solution7.search(nums, target);
  }

  public int search(int[] nums, int target) {
    int len = nums.length;
    int index = find(nums);
    int res = -1;
    if (target > nums[len - 1]) {
      res = binarySearch(nums, 0, index - 1, target);
    } else {
      res = binarySearch(nums, index, len - 1, target);
    }
    return res;
  }

  public int find(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        return i;
      }
    }
    return 0;
  }

  public int binarySearch(int[] nums, int lo, int hi, int target) {
    int mid = -1;
    while (lo <= hi) {
      mid = (lo + hi) / 2;
      if (nums[mid] > target) {
        hi = mid - 1;
      } else if (nums[mid] < target) {
        lo = mid + 1;
      } else {
        break;
      }
    }
    return lo > hi ? - 1 : mid;
  }
}
