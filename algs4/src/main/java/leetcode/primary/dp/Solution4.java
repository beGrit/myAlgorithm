package leetcode.primary.dp;

/**
 * Author: lsf Time: 9/14/20-10:05 AM
 */
public class Solution4 {

  public int rob(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        dp[i] = nums[i];
      } else if (i == 1) {
        dp[i] = Math.max(nums[i], dp[i - 1]);
      } else {
        dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
      }
    }
    return dp[len - 1];
  }
}
