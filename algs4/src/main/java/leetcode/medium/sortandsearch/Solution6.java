package leetcode.medium.sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Author: lsf Time: 10/23/20-3:00 PM
 */
public class Solution6 {

  public static void main(String[] args) {
    Solution6 solution6 = new Solution6();
    int[][] intervals;
//    intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    intervals = new int[][]{};
    int[][] res = solution6.function1(intervals);
  }

  public int[][] merge(int[][] intervals) {
    return function1(intervals);
  }

  /**
   * O(n)
   *
   * @param intervals
   * @return
   */
  public int[][] function1(int[][] intervals) {
    // 1. 排序(ASCE)
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] nums1, int[] nums2) {
        return nums1[0] - nums2[0];
      }
    });
    // 2. 遍历并根据条件合并
    int len = intervals.length;
    List<int[]> res = new ArrayList<>();
    int count = 0;
    int[] nums = new int[2];
    nums[0] = intervals[0][0];
    nums[1] = intervals[0][1];
    res.add(nums);
    for (int i = 1; i < len; i++) {
      count = res.size() - 1;
      int[] i1 = res.get(count);
      int t1 = i1[1];
      int t2 = intervals[i][0];
      if (t1 >= t2) {
        res.get(count)[1] = Math.max(t1, intervals[i][1]);
      } else {
        int[] t = new int[2];
        t[0] = intervals[i][0];
        t[1] = intervals[i][1];
        res.add(t);
      }
    }
    // List<int[]> --> int[][]
    return res.toArray(new int[res.size()][]);
  }

  public int[][] ListToArray(List<Integer[]> list) {
    int len = list.size();
    int[][] nums = new int[len][2];
    int i = 0;
    for (Integer[] array : list) {
      nums[i][0] = array[0];
      nums[i][1] = array[1];
      i++;
    }
    return nums;
  }
}
