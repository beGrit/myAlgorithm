package leetcode.daily.dp;

/**
 * Author: lsf Time: 11/3/20-2:22 PM
 */
public class Solution3 {
  // 941. 有效的山脉数组

  // 方法一: 简易dp
  public boolean validMountainArray(int[] A) {
    int status = 0;
    int len = A.length;
    if (len <= 1) {
      return false;
    }
    for (int i = 1; i < len; i++) {
      if (status == 0 && A[i] > A[i - 1]) {
        continue;
      } else if (status == 1 && A[i] < A[i - 1]) {
        continue;
      } else if (i != 1 && status == 0 && A[i] < A[i - 1]) {
        status = 1;
      } else {
        return false;
      }
    }
    return true;
  }

  public boolean function2(int[] A) {
    boolean res = false;
    int len = A.length;
    for (int i = 0; i < len; i++) {
      if ((i == 0 || A[i] > A[i - 1]) && (i == len - 1 || A[i] > A[i + 1])) {
        if (!res) {
          res = true;
        } else {
          return false;
        }
      }
    }
    return res;
  }
}
