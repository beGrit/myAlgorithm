package leetcode.medium.tree;

/**
 * Author: lsf Time: 10/10/20-3:31 PM
 */
public class Solution6 {

  int[] dx = {1, 0, 0, -1};
  int[] dy = {0, 1, -1, 0};
  private int height;
  private int width;

  public int numIslands(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    int height = grid.length;
    int width = grid[0].length;
    this.height = height;
    this.width = width;
    int res = 0;
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (grid[row][col] == '1') {
          dfs(row, col, grid);
          res++;
        }
      }
    }
    return res;
  }

  /**
   * @param row
   * @param col
   * @param grid
   */
  public void dfs(int row, int col, char[][] grid) {
    if (row >= height || col >= width || row < 0 || col < 0 || grid[row][col] == '0' ) {
      return;
    }
    grid[row][col] = '0';
    for (int i = 0; i < dx.length; i++) {
      dfs(row + dx[i], col + dy[i], grid);
    }
  }
}
