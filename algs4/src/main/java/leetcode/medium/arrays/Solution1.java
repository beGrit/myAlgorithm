package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 9/21/20-8:15 PM
 */
public class Solution1 {

  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> threeSum(int[] nums) {
    return function2(nums);
  }

  /**
   * 方法一:递归回溯(超时)
   * @param nums
   * @param sum
   * @param begin
   * @param path
   */
  public void function1(int[] nums, int sum, int begin, List<Integer> path) {
    if (path.size() == 3 && sum == 0) {
      res.add(new ArrayList<>(path));
      return;
    }
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = begin; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        continue;
      }
      map.put(nums[i],1);
      path.add(nums[i]);
      if (sum + nums[i] > 0) {
        return;
      }
      function1(nums, sum + nums[i],i + 1, path);
      path.remove(path.size() - 1);
    }
  }

  /**
   * 方法二:双指针
   */
  public List<List<Integer>> function2(int[] nums) {
    Arrays.sort(nums);
    int len = nums.length;
    for (int first = 0; first < len; first++) {
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }
      int third = len - 1;
      int target = -nums[first];
      for (int second = first + 1; second < len; second++) {
        if (second != first + 1 && nums[second] == nums[second - 1]) {
          continue;
        }
        while (second < third && nums[second] + nums[third] > target) {
          third--;
        }
        if (second == third) {
          break;
        }
        if (nums[second] + nums[third] == target) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[first]);
          list.add(nums[second]);
          list.add(nums[third]);
          res.add(list);
        }
      }
    }
    return res;
  }
}
