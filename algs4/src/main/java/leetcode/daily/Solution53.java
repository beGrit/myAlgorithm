package leetcode.daily;

/**
 * Author: lsf Time: 10/12/20-6:52 PM
 */
public class Solution53 {

  public boolean canPartition(int[] nums) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num > max) {
        max = num;
      }
      sum += num;
    }
    int target = sum / 2;
    if (sum % 2 != 0 || target < max) {
      return false;
    }
    int len = nums.length;
    boolean[][] dp = new boolean[len][target + 1];
    dp[0][nums[0]] = true;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < target; j++) {
        if (j == 0) {
          dp[i][0] = true;
          continue;
        }
        if (j >= nums[i]) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[len][target];
  }


  // 空间优化

  public boolean canPartition2(int[] nums) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num > max) {
        max = num;
      }
      sum += num;
    }
    int target = sum / 2;
    if (sum % 2 != 0 || target < max) {
      return false;
    }
    int len = nums.length;
    boolean[] dp = new boolean[target + 1];
    dp[nums[0]] = true;
    dp[0] = true;
    for (int i = 1; i < len; i++) {
      for (int j = target; j >= 0; j--) {
        if (nums[i] < target && j != 0) {
          dp[j] = dp[j] | dp[j - nums[j]];
        } else {
          dp[j] = dp[j];
        }
      }
    }
    return dp[target];
  }

}
