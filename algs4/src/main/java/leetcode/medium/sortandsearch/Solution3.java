package leetcode.medium.sortandsearch;

/**
 * Author: lsf Time: 10/15/20-8:57 AM
 */
public class Solution3 {

  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 4;
    int res = solution3.function1(nums, k);
  }

  public int findKthLargest(int[] nums, int k) {
    return 0;
  }

  public int function1(int[] nums, int k) {
    int curSize = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        continue;
      }
      int j = i;
      while (nums[(int) Math.floor(j / 2)] < nums[j] && j != 0) {
        swap(j, (int) Math.floor(j / 2), nums);
        j = (int) Math.floor(j / 2);
      }
    }
    int res = 0;
    for (int i = 0; i < k; i++) {
      res = delete(len - i, nums);
    }
    return res;
  }
  public int delete(int capacity, int[] nums) {
    int res = nums[0];
    nums[0] = nums[capacity - 1];
    toggleDown(0, capacity - 1, nums);
    return res;
  }

  public void toggleDown(int index, int capacity, int[] nums) {
    int j = index;
  }

  public void swap(int i, int j, int[] nums) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
