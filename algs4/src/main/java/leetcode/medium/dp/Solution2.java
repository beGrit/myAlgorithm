package leetcode.medium.dp;

/**
 * Author: lsf Time: 10/16/20-10:24 AM
 */
public class Solution2 {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (i == 1 && j == 1) {
          dp[1][1] = 1;
          continue;
        }
        if (i == 1) {
          dp[i][j] = dp[i][j - 1];
          continue;
        }
        if (j == 1) {
          dp[i][j] = dp[i - 1][j];
        }
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[n][m];
  }
}
