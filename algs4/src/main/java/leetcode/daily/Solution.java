package leetcode.daily;

import java.util.HashMap;

/**
 * Author: lsf Time: 8/17/20-5:13 PM
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
//    int[] nums = {0};
//    int newLength = solution.removeDuplicates(nums);
//    System.out.println(newLength);
//    for (int i = 0; i < newLength; i++) {
//      System.out.println(nums[i]);
//    }
    solution.rotate(new int[]{1, 2, 3, 4}, 2);
  }

  /**
   * 解题思路： 双指针法
   */
  public int removeDuplicates(int[] nums) {
    int i = 0;
    int j = i + 1;
    while (j < nums.length) {
      if (nums[i] == nums[j]) {
        j++;
      } else {
        nums[i + 1] = nums[j];
        i++;
        j++;
      }
    }
    return i + 1;
  }

  /*  示例 2:

    输入: [1,2,3,4,5]
    输入: [7,1,5,3,6,4]

    */
  public int maxProfit(int[] prices) {
    int i = 0;
    int j = 1;
    int profit = 0;
    while (j < prices.length) {
      if (prices[j] > prices[j - 1]) {
        j++;
      } else {
        profit += (prices[j - 1] - prices[i]);
        i = j;
        j++;
      }
    }
    profit += (prices[j - 1] - prices[i]);
    return profit;
  }

  /*
   * 买卖股票的最佳时机 II
   *
   * 动态规划
   * */
  public int maxProfit2(int[] prices) {
    int len = prices.length;
    if (len < 2) {
      return 0;
    }

    // 0：持有现金
    // 1：持有股票
    // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
    int[][] dp = new int[len][2];

    dp[0][0] = 0;
    dp[0][1] = -prices[0];

    for (int i = 1; i < len; i++) {
      // 这两行调换顺序也是可以的
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[len - 1][0];
  }

  /*
   * 旋转数组
   * 暴力解法
   * */
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    k = k % len;
    while (k > 0) {
      int tmp = nums[len - 1];
      for (int i = len - 2; i >= 0; i--) {
        nums[i + 1] = nums[i];
      }
      nums[0] = tmp;
      k--;
    }
  }

  /*
   * 旋转数组
   * 使用环状替换
   * */
  public void rotate2(int[] nums, int k) {
    int len = nums.length;
    k = k % len;
    int start;
    int count = 0;
    for (start = 0; count < k; start++) {
      int prev, next;
      int tmp = nums[start];
      prev = start;
      next = start + k;
      while (next < len) {
        tmp = nums[next];
        nums[next] = tmp;
        next += k;
      }
      nums[start] = tmp;
    }
  }

  public void swap(int[] nums, int i, int j) {
    int tmp;
    tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public boolean containsDuplicate(int[] nums) {
    Boolean flag = false;
    for (int i = 1; i < nums.length; i++) {
      for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
        swap(nums, j, j - 1);
        if (nums[j] == nums[j - 1]) {
          flag = true;
          break;
        }
      }
    }
    return flag;
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    int[] res = new int[Math.min(nums1.length, nums2.length)];
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int num : nums1) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }
    int k = 0;
    for (int num : nums2) {
      if (map.containsKey(num) && map.get(num) > 0) {
        map.put(num, map.get(num) - 1);
        res[k++] = num;
      } else {
        continue;
      }
    }
    return res;
  }
}