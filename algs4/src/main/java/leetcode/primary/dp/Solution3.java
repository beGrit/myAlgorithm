package leetcode.primary.dp;

/**
 * Author: lsf Time: 9/13/20-2:48 PM
 */
public class Solution3 {

  public int maxSubArray(int[] nums) {
    return function1(nums);
  }

  /**
   * 方法一:动态规划
   *
   * @param nums
   * @return
   */
  public int function1(int[] nums) {
    int max = nums[0];
    // 动态方程: dp[i] 表示 "以第i个数结尾的「连续子数组的最大和」"
    int len = nums.length;
    int[] dp = new int[len];
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        dp[i] = nums[i];
      } else {
        dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      }
      max = Math.max(dp[i], max);
    }
    return max;
  }
}
