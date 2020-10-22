package leetcode.medium.sortandsearch;
/**
 * Author: lsf Time: 10/15/20-9:47 AM
 */
public class Solution3_2 {

  public static void main(String[] args) {
    Solution3_2 solution3_2 = new Solution3_2();
    int[] nums = {3,2,3,1,2,4,5,5,6};
    int k = 4;
    int res = solution3_2.findKthLargest(nums, k);
  }

  public int findKthLargest(int[] nums, int k) {
    int len = nums.length;
    return quickSelect(nums, 0, len - 1, len - k);
  }

  private int quickSelect(int[] nums, int lo, int hi, int k) {
    if (lo >= hi) {
      return nums[0];
    }
    int len = nums.length;
    int index = partition(nums, lo, hi);
    while (true) {
      if (index < k) {
        index = partition(nums, index + 1, hi);
      } else if (index > k) {
        index = partition(nums, lo, index -1);
      } else {
        return nums[index];
      }
    }
  }

  // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
  // and return the index j.
  private int partition(int[] nums, int lo, int hi) {
    if (lo == hi) {
      return lo;
    }
    int v = nums[lo];
    int i = lo;
    int j = hi + 1;
    while (true) {
      while (less(nums[++i], v)) {
        if (i == hi) {
          break;
        }
      }
      while (less(v, nums[--j])) {
        if (j == lo) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      exch(nums, i, j);
    }

    exch(nums, lo, j);

    return j;
  }

  private void exch(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private boolean less(int[] nums, int left, int right) {
    return less(nums[left], nums[right]);
  }

  private boolean less(int i, int j) {
    return i < j;
  }
}
