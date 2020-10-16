package leetcode.primary.dp;

/**
 * Author: lsf Time: 9/13/20-12:10 PM
 */
public class Solution1 {

  public int climbStairs(int n) {
    int sum = 0;
    int count = 0;
    int len = n;
    int[] dp = new int[n];
    for (int i = 0; i < len; i--) {
      if (i == 0) {
        dp[i] = 1;
      } else if (i == 1) {
        dp[i] = 2;
      } else {
        dp[i] = dp[i - 1] + dp[i - 2] + 2;
      }
    }
    return dp[n - 1];
  }
}
