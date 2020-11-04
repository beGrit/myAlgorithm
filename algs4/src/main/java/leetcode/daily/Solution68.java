package leetcode.daily;

/**
 * Author: lsf Time: 10/26/20-10:24 AM
 */
public class Solution68 {

  private int len;
  private int[] res;

  public static void main(String[] args) {
    Solution68 solution68 = new Solution68();
    int[] nums = {8, 1, 2, 2, 3};
    int[] res = solution68.smallerNumbersThanCurrent(nums);
  }

  public int[] smallerNumbersThanCurrent(int[] nums) {
    this.len = nums.length;
    this.res = new int[len];
    return function2(nums);
  }

  private int[] function1(int[] nums) {
    int len = nums.length;
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (i != j) {
          if (nums[i] > nums[j]) {
            res[i]++;
          }
        }
      }
    }
    return res;
  }

  private int[] function2(int[] nums) {
    int[][] data = new int[len][2];
    for (int i = 0; i < len; i++) {
      data[i][0] = nums[i];
      data[i][1] = i;
    }
    helper(data, 0, len - 1);
    for (int i = 1; i < len; i++) {
      if (data[i][0] == data[i - 1][0]) {
        res[data[i][1]] = res[data[i - 1][1]];
      }
    }
    return res;
  }

  private int[] function3(int[] nums) {
    int[] map = new int[101];
    int len = nums.length;
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      map[nums[i]]++;
    }
    for (int i = 1; i < map.length; i++) {
      map[i] += map[i - 1];
    }
    for (int i = 0; i < len; i++) {
      res[i] = map[nums[i]];
    }
    return res;
  }

  private void helper(int[][] nums, int lo, int hi) {
    int len = nums.length;
    if (lo < hi) {
      int index = partition(nums, lo, hi);
      res[nums[index][1]] = index;
      helper(nums, lo, index - 1);
      helper(nums, index + 1, hi);
    } else if (lo == hi) {
      res[nums[lo][1]] = lo;
    }
  }


  private int partition(int[][] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    int v = a[lo][0];

    while (true) {
      do {
        ++i;
      } while (less(a[i][0], v) && i != hi);

      do {
        --j;
      } while (less(v, a[j][0]) && j != lo);
      if (i >= j) {
        exch(a, lo, j);
        return j;
      }

      exch(a, i, j);
    }
  }

  private boolean less(int v, int w) {
    return v < w;
  }

  private void exch(int[][] a, int i, int j) {
    int[] swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
}
