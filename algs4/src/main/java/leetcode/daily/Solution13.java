package leetcode.daily;

/**
 * Author: lsf Time: 9/1/20-9:20 AM
 */
public class Solution13 {

  private static final int User1Turn = 1;
  private static final int User2Turn = -1;

  public static void main(String[] args) {
    Solution13 solution13 = new Solution13();
    int[] nums = {1, 5, 2};
//    solution13.PredictTheWinner(nums);
    solution13.PredictTheWinner2(nums);
  }

  public boolean PredictTheWinner(int[] nums) {
    int length = nums.length;
    if (pick(User1Turn, nums, 0, length - 1) > 0) {
      return true;
    }
    return false;
  }

  /**
   * 递归计算当前子问题下对于该先手用户的最大化分数
   *
   * @param turn  标记当前子问题是谁在选择
   * @param nums
   * @param left
   * @param right
   * @return
   */
  public int pick(int turn, int[] nums, int left, int right) {
    if (left == right) {
      return nums[left] * turn;
    }
    int choice1 = pick(-turn, nums, left + 1, right) + nums[left] * turn;
    int choice2 = pick(-turn, nums, left, right - 1) + nums[right] * turn;
    if (turn == User1Turn) {
      return Math.max(choice1, choice2);
    } else {
      return Math.min(choice1, choice2);
    }
  }

  public boolean PredictTheWinner2(int[] nums) {
    int length = nums.length;
    int[][] dp = new int[length][length];
    /*for (int i = 0; i < length; i++) {
      dp[i] = new int[length];
    }*/
    for (int i = length - 1; i >= 0; i--) {
      for (int j = i; j < length; j++) {
        if (i == j) {
          dp[i][j] = nums[i];
        } else {
          dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        }
      }
    }
    return dp[0][length - 1] >= 0;
  }
}
