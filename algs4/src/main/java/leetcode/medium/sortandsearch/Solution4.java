package leetcode.medium.sortandsearch;

/**
 * Author: lsf Time: 10/20/20-8:09 PM
 */
public class Solution4 {

  public int findPeakElement(int[] nums) {
    return function2(nums);
  }

  /**
   * 方法一:线性搜索
   *
   * @param nums
   * @return
   */
  public int function1(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        return i;
      }
    }
    return nums.length - 1;
  }

  /**
   * 方法二:二分搜索
   *
   * @param nums
   * @return
   */
  public int function2(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] > nums[mid + 1]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}