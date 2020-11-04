package leetcode.daily.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 11/2/20-8:33 PM
 */
public class Solution1 {
  public int[] intersection(int[] nums1, int[] nums2) {
    return function1(nums1, nums2);
  }

  // 方法一:Hash表
  public int[] function1(int[] nums1, int[] nums2) {
    Map<Integer,Boolean> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (int num : nums1) { // O(n)
      if (!map.containsKey(num)) {
        map.put(num, Boolean.TRUE);
      }
    }
    for (int num : nums2) { // O(n)
      if (map.containsKey(num)) {
        res.add(num);
        map.remove(num);
      }
    }
    return res.stream().mapToInt(Integer::valueOf).toArray();
  }

  // 方法二:排序 + 双指针
}
