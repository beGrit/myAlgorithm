package leetcode.advanced.array;

import java.util.Arrays;

/**
 * Author: lsf Time: 10/30/20-3:20 PM
 */
public class Solution1 {

  /**
   * 238. 除自身以外数组的乘积
   */

  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] res = new int[len];
    Arrays.fill(res, 1);
    int t = nums[0];
    for (int i = 1; i < len; i++) {
      res[i] = t * nums[i];
      t *= nums[i];
    }
    t = nums[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      res[i] = t * res[i];
      t *= nums[i];
    }
    return res;
  }


  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int[] nums = {1,2,3,4};
    solution1.productExceptSelf(nums);
  }
}
