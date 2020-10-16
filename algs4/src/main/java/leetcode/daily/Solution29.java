package leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 9/18/20-8:25 AM
 */
public class Solution29 {

  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> permuteUnique(int[] nums) {
    helper(nums, 0, new ArrayList<>());
    return res;
  }

  public void helper(int[] nums, int begin, List<Integer> path) {
    int len = nums.length;
    if (path.size() == len) {
      res.add(new ArrayList<Integer>(path));
    }
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = begin; i < len; i++) {
      // 去重
      if (map.containsKey(i)) {
        continue;
      }

      // 递归
      swap(nums, begin, i);
      path.add(nums[begin]);
      map.put(nums[begin], map.getOrDefault(nums[begin], 0) + 1);
      helper(nums, begin + 1, path);
      swap(nums, begin, i);
      path.remove(path.size() - 1);
    }
  }

  public void swap(int[] nums, int left, int right) {
    int tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
  }
}
