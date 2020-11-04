package leetcode.daily.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 11/4/20-10:12 AM
 */
public class Solution2 {

  public static void main(String[] args) {
    Solution2 solution2 = new Solution2();
    int[][] intervals = {{1, 3}, {6, 9}};
    int[] newInterval = {2, 5};
    solution2.insert(intervals, newInterval);
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      return new int[][]{newInterval};
    }
    List<int[]> res = new ArrayList<>();
    int len = intervals.length;
    int count = 0;
    if (intervals[0][0] < newInterval[0]) {
      int[] tmp = intervals[0];
      intervals[0] = newInterval;
      newInterval = tmp;
    }
    int[] nums = new int[2];
    nums[0] = newInterval[0];
    nums[1] = newInterval[1];
    res.add(nums);
    for (int i = 1; i <= len; i++) {
      if (i != len && intervals[i][0] < newInterval[0]) {
        int[] tmp = intervals[i];
        intervals[i] = newInterval;
        newInterval = tmp;
      }
      int[] num1 = res.get(res.size() - 1);
      int[] num2 = newInterval;
      if (num2[0] <= num1[1]) {
        res.get(res.size() - 1)[1] = Math.max(num1[1], num2[1]);
      } else {
        int[] newNum = new int[2];
        newNum[0] = num2[0];
        newNum[1] = num2[1];
        res.add(newNum);
      }
    }
    return res.toArray(new int[res.size()][]);
  }
}
