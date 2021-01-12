package leetcode.daily.sort;

/**
 * Author: lsf Time: 11/7/20-9:32 AM
 */
public class Solution1 {
  // 1356. 根据数字二进制下 1 的数目排序

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int[] nums = {-2, 5, -1};
    int lower = -2;
    int upper = 2;
    solution1.countRangeSum(nums, lower, upper);
  }

  public int[] sortByBits(int[] arr) {
    // 统计每个数字二进制表示中 1 出现的个数
    int[] bit = new int[10001];
    return null;
  }

  public int countRangeSum(int[] nums, int lower, int upper) {
    // 直观解法
    int len = nums.length;
    int count = 0;
    // 统计所有区间和 (d[i][j])
    int[][] d = new int[len][len];
    for (int i = 0; i < len; i++) { // O(len)
      int pre = 0;
      for (int j = i; j < len; j++) { // O(len - i)
        d[i][j] = pre + nums[j];
        if (d[i][j] >= lower && d[i][j] <= upper) {
          count++;
        }
        pre = d[i][j];
      }
    }

    return count;
  }

  private int function2(int[] nums, int lower, int upper) {
    int len = nums.length;
    int[][] dp = new int[len][3];
    dp[0][0] = nums[0] >= lower && nums[1] <= upper ? 1 : 0;
    dp[0][1] = nums[0];
    dp[0][2] = nums[0];
    for (int i = 1; i < len; i++) {
//      if ()
    }
    return 0;
  }
}
