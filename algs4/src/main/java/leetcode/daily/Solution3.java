package leetcode.daily;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: lsf Time: 8/20/20-1:28 PM
 */
class Solution3 {

  /**
   * 定义8个移动方向 x += dx[]; y += dy[];
   */
  int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
  int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};

  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    solution3.isValidSudoku(new char[][]{});
  }

  /**
   * 1.点击的位置为地雷（M） 2.点击的位置为
   */
  public char[][] updateBoard(char[][] board, int[] click) {
    assert click.length == 2;
    assert click[0] >= 0;
    assert click[1] >= 0;
    int m = click[0];
    int n = click[1];
    if (board[m][n] == 'M') { // 触雷
      board[m][n] = 'X';
    } else {  // 没触雷
      dfs(board, m, n);
    }
    return board;
  }

  /**
   * DFS算法实现
   *
   * @param board
   * @param i
   * @param j
   */
  public void dfs(char[][] board, int i, int j) {
    /**
     * 1.附近有雷
     *    修改该位置为雷数，终止该位置的遍历
     * */
    int count = 0;
    for (int k = 0; k < 8; k++) {
      int x = i + dx[k];
      int y = j + dy[k];
      if (board[x][y] == 'M') {
        count++;
      }
    }
    if (count > 0) {
      board[i][j] = (char) (count + '0');
      return;
    }
    /**
     * 2.附近无雷
     *    标记该位置为 暴露区
     *    开始深度遍历周围的位置
     * */
    board[i][j] = 'B';
    for (int k = 0; k < 8; k++) {
      int x = i + dx[k];
      int y = j + dy[k];
      // 判断 深度遍历到达的位置是否越界 && 该位置是 非'E' 状态
      if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') {
        continue;
      }
      dfs(board,x,y);
    }
  }

  public void bfs(char[][] board, int i, int j) {
    boolean[][] visited = new boolean[board.length][board.length];
    Queue<int[]> queue = new LinkedList<>();
  }

  public boolean isValidSudoku(char[][] board) {
    int rowLength = board.length;
    int colLength = board[0].length;
    HashMap<Integer, Integer>[] rows = new HashMap[rowLength];
    HashMap<Integer, Integer>[] cols = new HashMap[colLength];
    HashMap<Integer, Integer>[] boxes = new HashMap[rowLength];
    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < colLength; j++) {
        char num = board[i][j];
        if (num != '.') {
          int boxIndex = (i / 3) * 3 + j / 3;
          int n = (int) num;
          rows[i].put(n, rows[i].get(n) + 1);
          cols[j].put(n, cols[j].get(n) + 1);
          boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);
          if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[boxIndex].get(n) > 1) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * 转置+翻转 策略
   * */
  public void rotate(int[][] matrix) {
    // 转置矩阵(行向量 -> 列向量)
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix.length; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
    // 按中线左右翻转矩阵
    for (int k = 0; k < matrix.length; k++) {
      int i = 0;
      int j = matrix.length - 1;
      while (i <= j) {
        int tmp = matrix[k][i];
        matrix[k][i] = matrix[k][j];
        matrix[k][j] = tmp;
        i++;
        j--;
      }
    }
  }

  public int reverse(int x) {
    return 0;
  }
}