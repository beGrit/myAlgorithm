package leetcode.daily.dp;

import java.util.Arrays;

/**
 * Author: lsf Time: 10/24/20-9:54 PM
 */
public class Solution66 {

  public static void main(String[] args) {
    Solution66 solution66 = new Solution66();
    int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
    int T = 10;
    solution66.function4(clips, T);
  }

  public int videoStitching(int[][] clips, int T) {
    return function2(clips, T);
  }

  public int function1(int[][] clips, int T) {
    int[] dp = new int[T + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= T; i++) {
      for (int[] clip : clips) {
        if (clip[0] < i && clip[1] >= i) {
          dp[i] = Math.min(dp[i], dp[i - clip[0]] + 1);
        }
      }
    }
    return dp[T] == Integer.MAX_VALUE ? -1 : dp[T];
  }

  public int function2(int[][] clips, int T) {
    sort(clips);
    int res = 0;
    int[] dp = new int[T + 1];
    int len = clips.length;
    int subMax = Integer.MIN_VALUE;
    for (int i = 0; i <= T; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    if (clips[0][0] > 0) {
      return -1;
    } else {
      dp[0] = 0;
      subMax = clips[0][1];
    }
    for (int i = 1; i <= len; i++) {
      if (i == len || clips[i][0] != clips[i - 1][0]) {
        if (dp[clips[i - 1][0]] == Integer.MAX_VALUE) {
          res = -1;
          break;
        } else {
          for (int t = clips[i - 1][0]; t <= subMax; t++) {
            dp[t] = Math.min(dp[t], dp[clips[i - 1][0]] + 1);
          }
        }
        if (i != len) {
          subMax = clips[i][1];
        }
        continue;
      }
      if (clips[i][0] == clips[i - 1][0] && clips[i][1] > subMax) {
        subMax = clips[i][1];
      }
    }
    res = dp[T];
    return res;
  }

  public void sort(int[][] nums) {
    int len = nums.length;
    for (int i = 1; i < len; i++) {
      for (int j = i; j > 0; j--) {
        if (nums[j - 1][0] > nums[j][0]) {
          swap(nums, j - 1, j);
        } else {
          break;
        }
      }
    }
  }

  public void swap(int[][] nums, int i, int j) {
    int[] tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }


  /**
   * 官方方法一:动态规划
   *
   * @param clips
   * @param T
   * @return
   */
  public int function3(int[][] clips, int T) {
    int[] dp = new int[T + 1];
    for (int i = 0; i <= T; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    dp[0] = 0;
    for (int i = 1; i <= T; i++) {
      for (int[] clip : clips) {
        if (clip[0] < i && clip[1] >= i) {
          dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
        }
      }
    }

    return dp[T] == Integer.MAX_VALUE ? -1 : dp[T];
  }

  /**
   * 官方方法二:贪心算法
   *
   * @param clips
   * @param T
   * @return
   */
  public int function4(int[][] clips, int T) {
    int len = clips.length;

    // index 位置上能跳到的 最远距离
    int[] nums = new int[T + 1];

    for (int i = 0; i < len; i++) { // O(n)
      int bg = clips[i][0];
      int end = clips[i][1];
      nums[bg] = Math.max(nums[bg], end);
    }
    int curMax = 0;
    int pre = 0;
    int res = 0;
    for (int i = 0; i <= T; i++) {
      if (curMax >= i) {
        curMax = Math.max(curMax, nums[i]);
      } else {
        return -1;
      }
      if (pre == i) {
        res++;
        pre = curMax;
      }
    }
    return res - 1;
  }
}
