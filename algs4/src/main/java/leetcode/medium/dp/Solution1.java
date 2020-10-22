package leetcode.medium.dp;

/**
 * Author: lsf Time: 10/16/20-10:04 AM
 */
public class Solution1 {
  public boolean canJump(int[] nums) {
    int len = nums.length;
    boolean[] dp = new boolean[len];
    for (int i = len - 1; i >= 0; i--) {
      for (int j = nums[i]; j >= 0; j--) {
        if (i + j >= len - 1) {
          dp[i] = true;
          break;
        } else if (dp[i + j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[0];
  }

  public boolean canJumpPlus(int[] nums) {
    int len = nums.length;
    int t = len - 1;
    boolean res = false;
    for (int i = t -1; i >= 0; i--) {
      if (i + nums[i] >= t) {
        t = i;
        res = true;
      } else {
        res = false;
      }
    }
    return res;
  }
}
