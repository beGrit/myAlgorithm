package leetcode.daily.sort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: lsf Time: 11/17/20-2:06 PM
 */
public class Solution6 {


  public static void main(String[] args) {
    Solution6 solution6 = new Solution6();
    int R = 2;
    int C = 3;
    int r0 = 1;
    int c0 = 2;
    int[][] ret = solution6.allCellsDistOrder(R, C, r0, c0);
  }

  // 1030.距离顺序排列矩阵单元格
  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    return bfs(R, C, r0, c0);
  }

  // 方法一: BFS
  public int[][] bfs(int R, int C, int i, int j) {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    boolean[][] visited = new boolean[R][C];
    List<int[]> ret = new ArrayList<>();
    Deque<int[]> deque = new LinkedList<>();
    deque.offer(new int[]{i, j});
    visited[i][j] = true;
    while (!deque.isEmpty()) {
      int[] nums = deque.poll();
      ret.add(nums);
      for (int k = 0; k < 4; k++) {
        int x = nums[0] + dx[k];
        int y = nums[1] + dy[k];
        if (x < 0 || y < 0 || x >= R || y >= C) {
          // 越界
          continue;
        } else if (visited[x][y]) {
          // 已遍历过
          continue;
        } else {
          visited[x][y] = true;
          deque.offer(new int[]{x, y});
        }
      }
    }
    return ret.toArray(new int[ret.size()][]);
  }
}
