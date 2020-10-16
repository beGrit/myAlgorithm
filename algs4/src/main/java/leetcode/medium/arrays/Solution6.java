package leetcode.medium.arrays;

/**
 * Author: lsf Time: 9/26/20-11:29 PM
 */
public class Solution6 {

  public static void main(String[] args) {
    int[] nums = {5,1,5,5,2,5,4};
    Solution6 solution6 = new Solution6();
    solution6.increasingTriplet(nums);
  }
  public boolean increasingTriplet(int[] nums) {
    return function1(nums);
  }

  /**
   * 方法一:滑动窗口(双指针)
   *
   * @param nums
   */
  public boolean function1(int[] nums) {
    int rp = 0;
    int maxWidth = 0;
    int len = nums.length;
    for (int lp = 0; lp < len; lp++) {
/*      if (lp == 0) {
        maxWidth = 1;
      }*/
      if (lp == rp) {
        rp++;
        maxWidth++;
      }
      while (rp < len && nums[rp] > nums[rp - 1]) {
        rp++;
        maxWidth++;
        if (maxWidth == 3) {
          return true;
        }
      }
      maxWidth--;
    }
    return false;
  }
}
