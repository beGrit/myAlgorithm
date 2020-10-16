package leetcode.daily;

/**
 * Author: lsf Time: 10/1/20-8:30 AM
 */
public class Solution43 {

  public static void main(String[] args) {
    Solution43 solution43 = new Solution43();
    String ques = "rrryyyrryyyrr";
    int res = solution43.minimumOperations(ques);
  }

  /**
   * 方法一:动态规划
   * dp方程:
   *    dp[i][0] 表示 i位置作为 第一r段 时[0,i]最少需要改变多少片叶子
   *    dp[i][1] 表示 i位置作为 y段 时[0,i]最少需要改变多少片叶子
   *    dp[i][2] 表示 i位置作为 第二r段 时[0,i]最少需要改变多少片叶子
   *    状态转移方程:
   *    dp[i][0] = dp[i-1][0]+isRed;
   *    dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + isYellow;
   *    dp[i][2] = Math.min(dp[i-1][1],dp[i-1][2]) + isRed;
   * @param leaves
   * @return
   */
  public int minimumOperations(String leaves) {
    char[] chars = leaves.toCharArray();
    int len = chars.length;
    int[][] dp = new int[len][3];
    // 基态
    dp[0][0] = chars[0] == 'r' ? 0 : 1;
    dp[0][1] = Integer.MAX_VALUE;
    dp[1][2] = Integer.MAX_VALUE;
    // dp填表
    for (int i = 1; i < len; i++) {
      int isRed = chars[i] == 'r' ? 0 : 1;
      int isYellow = chars[i] == 'y' ? 0 : 1;
      dp[i][0] = dp[i - 1][0] + isRed;
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + isYellow;
      if (i > 1) {
        dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isRed;
      }
    }
    return dp[len - 1][2];
  }
}