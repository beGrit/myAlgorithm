package leetcode.medium.sortandsearch;

/**
 * Author: lsf Time: 10/23/20-2:12 PM
 */
public class Solution5 {

  public int[] searchRange(int[] nums, int target) {
    return null;
  }

  /**
   * 方法一:二分查找
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] function1(int[] nums, int target) {
    int len = nums.length;
    int l = 0;
    int r = nums.length - 1;
    int lo = -1;
    int hi = -1;
    while (l <= r && lo == -1) {
      int mid = (l + r) / 2;
      if (target > nums[mid]) {
        l = mid + 1;
      } else if (target < nums[mid]) {
        r = mid - 1;
      } else { // target == nums[mid]
        if (mid == 0) {
          lo = mid;
        } else if (nums[mid] != nums[mid - 1]) {
          lo = mid;
        } else {
          r = mid - 1;
        }
      }
    }
    while (l <= r && hi == -1) {
      int mid = (l + r) / 2;
      if (target > nums[mid]) {
        l = mid + 1;
      } else if (target < nums[mid]) {
        r = mid - 1;
      } else { // target == nums[mid]
        if (mid == len - 1) {
          hi = mid;
        } else if (nums[mid] != nums[mid + 1]) {
          hi = mid;
        } else {
          l = mid + 1;
        }
      }
    }
    return new int[]{lo, hi};
  }
}
