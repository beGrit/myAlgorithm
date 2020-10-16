package leetcode.medium.sortandsearch;

/**
 * Author: lsf Time: 10/3/20-11:07 PM
 */
public class Solution1 {

  public void sortColors(int[] nums) {
    int c1 = 0;
    int c2 = 0;
    int c3 = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] == 0) {
        swap(nums, i, c1 + c2);
        swap(nums, c1 + c2, c1);
        c1++;
      } else if (nums[i] == 1) {
        swap(nums, i, c1 + c2);
        c2++;
      } else if (nums[i] == 2) {
        c3++;
      }
    }
  }

  public void swap(int[] nums, int i, int j) {
    int len = nums.length;
    assert i > 0 && j < len;
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int[] nums = new int[]{2,0,2,1,1,0};
    solution1.sortColors(nums);
  }
}
