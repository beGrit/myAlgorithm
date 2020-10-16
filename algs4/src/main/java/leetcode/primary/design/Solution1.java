package leetcode.primary.design;

import java.util.Random;

/**
 * Author: lsf Time: 9/19/20-9:57 PM
 */
public class Solution1 {

  private int[] original;
  private int[] nums;
  private Random random = new Random();

  public Solution1(int[] original) {
    this.original = original;
    this.nums = original.clone();
  }

  /**
   * Resets the array to its original configuration and return it.
   */
  public int[] reset() {
    nums = original.clone();
    return nums;
  }

  /**
   * Returns a random shuffling of the array.
   */
  public int[] shuffle() {
    helper(nums);
    return nums;
  }

  public void helper(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      int index = randomInt(i, len);
      swap(nums, i, index);
    }
  }

  private int randomInt(int bg, int fi) {
    return random.nextInt(fi - bg) + bg;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
