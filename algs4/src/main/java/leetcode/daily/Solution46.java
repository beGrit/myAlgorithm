package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: lsf Time: 10/4/20-8:36 AM
 */
public class Solution46 {

  private List<List<Integer>> res = new ArrayList<>();

  public static void main(String[] args) {
    Solution46 solution46 = new Solution46();
    int[] nums = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
    int target = -11;
    solution46.fourSum(nums, target);
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    function2(nums, target);
    return res;
  }

  /**
   * 方法一:递归回溯(超时)
   *
   * @param nums
   * @param target
   * @param sum
   * @param path
   * @param begin
   */
  public void function1(int[] nums, int target, int sum, List<Integer> path, int begin) {
    if (path.size() == 4) {
      if (sum == target) {
        res.add(new ArrayList<>(path));
      }
      return;
    }
    for (int i = begin; i < nums.length; i++) {
      if (i != begin && nums[i] == nums[i - 1]) {
        continue;
      }
      path.add(nums[i]);
      function1(nums, target, sum + nums[i], path, i + 1);
      path.remove(path.size() - 1);
    }
  }

  public void function2(int[] nums, int target) {
    Arrays.sort(nums);
    int len = nums.length;
    for (int first = 0; first < len - 3; first++) {
      // 剪枝
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }
      if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
        break;
      }
      if (nums[first] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
        continue;
      }
      for (int second = first + 1; second < len - 2; second++) {

        // 剪枝
        if (second != first + 1 && nums[second] == nums[second - 1]) {
          continue;
        }
        if (nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
          break;
        }
        if (nums[first] + nums[second] + nums[len - 2] + nums[len - 1] < target) {
          continue;
        }

        if (nums[second] > 0 && nums[first] + nums[second] > target) {
          continue;
        }

        int fourth = len - 1;
        int t = target - nums[first] - nums[second];

        for (int third = second + 1; third < len - 1; third++) {

          // 剪枝
          if (third != second + 1 && nums[third] == nums[third - 1]) {
            continue;
          }

          while (third < fourth && nums[third] + nums[fourth] > t) {
            fourth--;
          }
          if (third == fourth) {
            break;
          }
          if (nums[third] + nums[fourth] == t) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[first]);
            list.add(nums[second]);
            list.add(nums[third]);
            list.add(nums[fourth]);
            res.add(list);
          }

        }
      }

    }
  }
}
