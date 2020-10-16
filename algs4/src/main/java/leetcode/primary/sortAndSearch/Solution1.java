package leetcode.primary.sortAndSearch;

/**
 * Author: lsf Time: 9/12/20-8:05 PM
 */
public class Solution1 {

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    solution1.merge(nums1, 3, nums2, 3);
  }

  /**
   * 方法一:插入排序
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = m; i < n + m; i++) {
      nums1[i] = nums2[i - m];
      for (int j = i; j > 0; j--) {
        if (nums1[j - 1] > nums1[j]) {
          int tmp = nums1[j - 1];
          nums1[j - 1] = nums1[j];
          nums1[j] = tmp;
        } else {
          break;
        }
      }
    }
  }
}
