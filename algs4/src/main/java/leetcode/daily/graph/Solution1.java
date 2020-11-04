package leetcode.daily.graph;

/**
 * Author: lsf Time: 10/30/20-8:49 AM
 */
public class Solution1 {

  private int[] dx = {1, 0, -1, 0};
  private int[] dy = {0, 1, 0, -1};
  private int res = 0;

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
    int res = solution1.islandPerimeter(grid);
  }

  /**
   * 463. 岛屿的周长
   */

  public int islandPerimeter(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        // 只有一个岛屿
        if (grid[i][j] == 1) {
          dfs(grid, i, j);
          return res;
        }
      }
    }
    return 0;
  }

  /**
   * @param grid
   * @param row
   * @param col
   * @return
   */
  public void dfs(int[][] grid, int row, int col) {
    // 与边界相邻 || 与水相邻
    if ((row >= grid.length || col >= grid[0].length || row < 0 || col < 0)
        || grid[row][col] == 0) {
      res += 1;
      return;
    }
    if (grid[row][col] == 2) {
      return;
    }
    grid[row][col] = 2;
    for (int i = 0; i < 4; i++) {
      dfs(grid, row + dx[i], col + dy[i]);
    }
  }
}
