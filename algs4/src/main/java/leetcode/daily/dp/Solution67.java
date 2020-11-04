package leetcode.daily.dp;

/**
 * Author: lsf Time: 10/25/20-3:19 PM
 */
public class Solution67 {

  public int longestMountain(int[] A) {
    int res = 0;
    int len = A.length;
    boolean[][] dp = new boolean[len][len];
    for (int i = len - 1; i >= 0; i--) {
      for (int j = i; j < len; j++) {
        if (j == i) {
          dp[i][j] = true;
        } else if (j - i == 1) {
          dp[i][j] = true;
        } else {

        }
      }
    }
    return res;
  }

  public int function1(int[] A) {
    int len = A.length;
    int[] left = new int[len];
    int[] right = new int[len];
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      if (i == 0 || A[i] <= A[i - 1]) {
        left[i] = 0;
      } else {
        left[i] = left[i - 1] + 1;
      }
    }
    for (int i = len - 1; i >= 0; i--) {
      if (i == len - 1 || A[i] <= A[i + 1]) {
        right[i] = 0;
      } else {
        right[i] = right[i + 1] + 1;
      }
      if (right[i] > 0 && left[i] > 0) {
        res = Math.max(res, left[i] + right[i] + 1);
      }
    }
    return res;
  }
}
