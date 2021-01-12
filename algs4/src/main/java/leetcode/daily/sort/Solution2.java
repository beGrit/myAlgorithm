package leetcode.daily.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: lsf Time: 11/9/20-12:13 PM
 */
public class Solution2 {

  public static void main(String[] args) {
    Solution2 solution2 = new Solution2();
    int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
    int K = 2;
    solution2.kClosest(points, K);
  }

  public int[][] kClosest(int[][] points, int K) {
    int[][] data = new int[points.length][2];
    int index = 0;
    for (int point[] : points) {
      int d = point[0] * point[0] + point[1] * point[1];
      data[index][0] = d;
      data[index][1] = index;
      index++;
    }
    Arrays.sort(data, new Comparator<int[]>() {
      @Override
      public int compare(int[] num1, int[] num2) {
        return num1[0] - num2[0];
      }
    });
    int[][] res = new int[K][2];
    for (int i = 0; i < K; i++) {
      res[i] = points[data[i][1]];
    }
    return res;
  }
}
