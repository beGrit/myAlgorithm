package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 9/3/20-4:38 PM
 */
public class Solution15 {

  private Map<Integer, Boolean> rowHash = new HashMap<>();
  private Map<Integer, Boolean> colHash = new HashMap<>();
  private Map<Integer, Boolean> rDiagonalHash = new HashMap<>();
  private Map<Integer, Boolean> lDiagonalHash = new HashMap<>();
  private List<int[]> ans = new ArrayList<int[]>();

  public static void main(String[] args) {
    Solution15 solution15 = new Solution15();
    solution15.solveNQueens(2);
  }

  public List<List<String>> solveNQueens(int n) {
    int[] nums = new int[n];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = -1;
    }
    findQueenLocation(nums, 0);
    if (ans.size() == 0) {
      return new ArrayList();
    }
    List<List<String>> res = intToStringList(ans);
    return res;
  }

  /**
   * @param nums   记录之前皇后安放的位置
   * @param target 标识当前空间是在安排target行的皇后
   * @return
   */
  public void findQueenLocation(int[] nums, int target) {
    // 全部皇后都可以安排位置,将此方案添加到ans中
    if (target == nums.length) {
      int[] subArray = Arrays.copyOf(nums, nums.length);
      ans.add(subArray);
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      int lDigIndex = i - target;
      int rDigIndex = i + target;
      nums[target] = i;
      if (colHash.getOrDefault(i, false) || rDiagonalHash.getOrDefault(rDigIndex, false)
          || lDiagonalHash.getOrDefault(lDigIndex, false)) {
        continue;
      } else {
        // 该位置适合,修改数据,进入下层空间
        rowHash.put(target, true);
        colHash.put(i, true);
        rDiagonalHash.put(rDigIndex, true);
        lDiagonalHash.put(lDigIndex, true);
        findQueenLocation(nums, target + 1);
      }
      // 回溯
      rowHash.put(target, false);
      colHash.put(i, false);
      rDiagonalHash.put(rDigIndex, false);
      lDiagonalHash.put(lDigIndex, false);
      nums[target] = -1;
    }
  }

  public List<List<String>> intToStringList(List<int[]> nums) {
    List<List<String>> lists = new ArrayList<>();
    int listLength = nums.size();
    int arrayLength = nums.get(0).length;
    char[] temp = new char[arrayLength];
    for (int i = 0; i < arrayLength; i++) {
      temp[i] = '.';
    }
    for (int i = 0; i < listLength; i++) {
      List<String> list = new ArrayList<>();
      for (int j = 0; j < arrayLength; j++) {
        char[] c = Arrays.copyOf(temp, arrayLength);
        c[nums.get(i)[j]] = 'Q';
        list.add(new String(c));
      }
      lists.add(list);
    }
    return lists;
  }
}