package leetcode.daily.dp;

/**
 * Author: lsf Time: 10/14/20-3:10 PM
 */
public class Solution56 {

  public static void main(String[] args) {
    Solution56 solution56 = new Solution56();
    String[] strs = {"10", "0001", "111001", "1", "0"};
    int m = 5;
    int n = 3;
    solution56.findMaxForm(strs,m,n);
  }

  public int findMaxForm(String[] strs, int m, int n) {
    int len = strs.length;
    int[][][] dp = new int[len][m + 1][n + 1];
    int[][] count = new int[len][2];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < strs[i].length(); j++) {
        if (strs[i].charAt(j) == '0') {
          count[i][0]++;
        } else {
          count[i][1]++;
        }
      }
    }
    for (int i = count[0][0]; i <= m; i++) {
      for (int j = count[0][1]; j <= n; j++) {
        dp[0][i][j]++;
      }
    }
    for (int i = 1; i < len; i++) {
      for (int j = 0; j <= m; j++) {
        for (int k = 0; k <= n; k++) {
          if (count[i][0] <= j && count[i][1] <= k) {
            dp[i][j][k] = Math.max(dp[i - 1][j][k],dp[i - 1][j - count[i][0]][k - count[i][1]] + 1);
          } else {
            dp[i][j][k] = dp[i - 1][j][k];
          }
        }
      }
    }
    return dp[len-1][m][n];
  }
}
