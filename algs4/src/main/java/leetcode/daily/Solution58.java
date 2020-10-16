package leetcode.daily;

/**
 * Author: lsf Time: 10/16/20-8:26 AM
 */
public class Solution58 {

  /**
   * 双指针法
   * @param A
   * @return
   */
  public int[] sortedSquares(int[] A) {
    int len = A.length;
    int[] res = new int[len];
    for (int i = 0, j = len - 1, k = len - 1; i <= j;) {
      if (A[i] * A[i] > A[j] * A[j]) {
        res[k] = A[i] * A[i];
        ++i;
      } else {
        res[k] = A[j] * A[j];
        --j;
      }
      --k;
    }
    return res;
  }
}
