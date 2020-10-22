package leetcode.medium.dp;

/**
 * Author: lsf Time: 10/19/20-5:14 PM
 */
public class Solution4 {

  public int lengthOfLIS(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    int res = 0;
    for (int i = 0; i < len; i++) {
      dp[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (i != 0 && nums[j] < nums[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
      res = Math.max(dp[i],res);
    }
    return res;
  }

  public int function2(int[] nums) {
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    int[] d = new int[len + 1];
    d[1] = nums[0];
    int maxLen = 1;
    for (int i = 1; i < len; i++) {
      if (nums[i] > d[maxLen]) {
        maxLen++;
        d[maxLen] = nums[i];
      } else {
        int l = 1, r = len, pos = 0;
        while (l <= r) {
          int mid = (l + r) >> 1;
          if (d[mid] < nums[i]) {
            pos = mid;
            l = mid + 1;
          } else {
            r = mid - 1;
          }
        }
        d[pos + 1] = nums[i];
      }
    }
    return maxLen;
  }


  public static void main(String[] args) {
    Solution4 solution4 = new Solution4();
    int[] nums = {1,3,6,7,9,4,10,5,6};
    int res = solution4.lengthOfLIS(nums);
  }
}
