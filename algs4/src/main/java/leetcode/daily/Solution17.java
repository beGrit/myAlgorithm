package leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsf Time: 9/5/20-10:10 AM
 */
public class Solution17 {

  private Map<Integer, Boolean> map = new HashMap<>();
  private int[] res;
  private int k;

  public static void main(String[] args) {
    Solution17 solution17 = new Solution17();
    String ans = solution17.getPermutation(1, 1);
    return;
  }

  /**
   * 方法一.递归回溯
   *
   * @param n
   * @param k
   * @return
   */
  public String getPermutation(int n, int k) {
    int[] nums = new int[n];
    this.k = k;
    helper(nums, 0);
    return arraysToString(res);
  }

  /**
   * DFS递归回溯算法
   * @param nums  记录当前序列
   * @param curIndex  记录当前在curIndex位置上进行选择
   */
  public void helper(int[] nums, int curIndex) {
    if (res != null) {
      return;
    }
    if (curIndex == nums.length) {
      if (--k == 0) {
        res = Arrays.copyOf(nums, nums.length);
      }
      return;
    }
    for (int i = 1; i < nums.length + 1; i++) {
      if (map.getOrDefault(i, false)) {
        continue;
      } else {
        nums[curIndex] = i;
        map.put(i, true);
        helper(nums, curIndex + 1);
        // 回溯
        nums[curIndex] = 0;
        map.remove(i);
      }
    }
  }

  /**
   * int数组 转 String
   * @param nums
   * @return
   */
  public String arraysToString(int[] nums) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < nums.length; i++) {
      stringBuffer.append(nums[i]);
    }
    return stringBuffer.toString();
  }

}
