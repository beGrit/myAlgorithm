package leetcode.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Author: lsf Time: 8/25/20-8:11 PM
 */
public class Solution5 {
  private List<List<Integer>> ans = new ArrayList<>();
  public List<List<Integer>> findSubsequences(int[] nums) {
    DFS(new ArrayList<>(),-1,nums);
    return ans;
  }

  public void DFS(List<Integer> oldList,int target,int[] nums) {
    int len = nums.length;
    if (oldList.size() > 1) {
      ans.add(new ArrayList<>(oldList));
    }
    // 当前递归维度去重复
    Set<Integer> set = new HashSet<>();
    for (int i = target + 1; i < len; i++) {
      if (set.contains(nums[i])) {
        continue;
      }
      set.add(nums[i]);
      if (target == -1 || nums[i] >= nums[target]) {
        oldList.add(nums[i]);
        DFS(oldList,i,nums);
        oldList.remove(oldList.size() - 1);
      }
    }
  }
}
