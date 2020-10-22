package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 10/17/20-12:33 PM
 */
public class Solution59 {
  private Map<Integer, Boolean> rowHash = new HashMap<>();
  private Map<Integer, Boolean> colHash = new HashMap<>();
  private Map<Integer, Boolean> rDiagonalHash = new HashMap<>();
  private Map<Integer, Boolean> lDiagonalHash = new HashMap<>();
  private List<int[]> ans = new ArrayList<int[]>();
  private int count = 0;
  public int totalNQueens(int n) {
    int[] nums = new int[n];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = -1;
    }
    findQueenLocation(nums, 0);
    return count;
  }

  /**
   * @param nums   记录之前皇后安放的位置
   * @param target 标识当前空间是在安排target行的皇后
   * @return
   */
  public void findQueenLocation(int[] nums, int target) {
    // 全部皇后都可以安排位置,将此方案添加到ans中
    if (target == nums.length) {
      count++;
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
}
