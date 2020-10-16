package leetcode.medium.arrays;

/**
 * Author: lsf Time: 9/26/20-10:23 PM
 */
public class Solution5 {

  public static void main(String[] args) {
    Solution5 solution5 = new Solution5();
    String s = "babad";
    solution5.longestPalindrome(s);
  }

  public String longestPalindrome(String s) {
    int len = s.length();
    boolean[][] dp = new boolean[len][len];
    int maxCount = 0;
    int left = -1, right = 0;
    for (int i = len; i >= 0; i--) {
      for (int j = i; j < len; j++) {
        dp[i][j] = false;
        boolean isEqual = s.charAt(i) == s.charAt(j);
        // 基态
        if (i == j || i == j - 1 && isEqual) {
          dp[i][j] = true;
          if (maxCount < j - i + 1) {
            left = i;
            right = j;
            maxCount = j - i;
          }
          continue;
        }

        // 状态转移
        if (isEqual && dp[i + 1][j - 1]) {
          dp[i][j] = true;
          if (maxCount <= j - i + 1) {
            left = i;
            right = j;
            maxCount = j - i + 1;
          }
        }
      }
    }
    return left == -1?"":s.substring(left, right + 1);
  }
}
