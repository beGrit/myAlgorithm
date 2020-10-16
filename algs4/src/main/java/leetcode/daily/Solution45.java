package leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsf Time: 10/3/20-7:59 PM
 */
public class Solution45 {

  public int[] twoSum(int[] nums, int target) {
    int len = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < len; i++) {
      if (map.containsKey(target - nums[i])) {
        Integer val = map.get(target - nums[i]);
        if (val == i) {
          continue;
        } else {
          return new int[]{i, val};
        }
      }
    }
    return null;
  }
}
