package leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 10/10/20-4:25 PM
 */
public class Solution3 {

  Map<Integer, Integer> map = new HashMap();
  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    function1(nums, new ArrayList<>());
    return res;
  }

  public void function1(int[] nums, List<Integer> path) {
    if (path.size() == nums.length) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        continue;
      }
      map.put(nums[i], 1);
      path.add(nums[i]);
      function1(nums, path);
      path.remove(path.size() - 1);
      map.remove(nums[i]);
    }
  }
}
