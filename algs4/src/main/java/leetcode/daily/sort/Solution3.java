package leetcode.daily.sort;

/**
 * Author: lsf Time: 11/10/20-10:52 AM
 */
public class Solution3 {

  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    int[] nums = {1, 1, 1, 2, 5, 4};
    solution3.nextPermutation(nums);
  }
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[i] >= nums[j]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public void reverse(int[] nums, int start) {
    int left = start, right = nums.length - 1;
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }
}
