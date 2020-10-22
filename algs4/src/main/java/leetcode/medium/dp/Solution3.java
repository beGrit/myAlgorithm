package leetcode.medium.dp;

import java.util.Arrays;

/**
 * Author: lsf Time: 10/16/20-10:41 AM
 */
public class Solution3 {

  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    int[] coins = {186,419,83,408};
    int amount = 6249;
    int res = solution3.coinChange(coins, amount);
  }

  public int coinChange(int[] coins, int amount) {
    int len = coins.length;
    int[][] dp = new int[len][amount + 1];
    sort_desc(coins);
    // 基态
    for (int i = 0; i < len; i++) {
      for (int j = 1; j <= amount; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }
    for (int i = 1; i <= amount; i++) {
      dp[0][i] = i % coins[0] == 0 ? i / coins[0] : Integer.MAX_VALUE;
    }
    for (int i = 1; i < len; i++) {
      for (int j = 1; j <= amount; j++) {
        int curCount = 0;
        while (curCount * coins[i] <= j) {
          if (dp[i - 1][j - coins[i] * curCount] != Integer.MAX_VALUE) {
            dp[i][j] = Math.min(dp[i - 1][j - coins[i] * curCount] + curCount, dp[i][j]);
          }
          curCount++;
        }
      }
    }
    return dp[len - 1][amount] == Integer.MAX_VALUE ? -1 : dp[len - 1][amount];
  }

  public void sort_desc(int[] coins) {
    Arrays.sort(coins);
    int len = coins.length;
    int left = 0;
    int right = len - 1;
    while (left < right) {
      int tmp = coins[left];
      coins[left] = coins[right];
      coins[right] = tmp;
      left++;
      right--;
    }
  }
}
