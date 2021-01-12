package leetcode.daily.sort;

/**
 * Author: lsf Time: 11/15/20-11:07 AM
 */
public class Solution5 {
  // 922. 按奇偶排序数组 II


  // 时间 O(n) 空间 O(n)
  public int[] sortArrayByParityII(int[] A) {
    int p1 = 0;
    int p2 = 1;
    int[] res = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 == 0) {
        // 偶数
        res[p1] = A[i];
        p1 += 2;
      } else {
        // 奇数
        res[p2] = A[i];
        p2 += 2;
      }
    }
    return res;
  }
}
