package leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsf Time: 9/15/20-12:05 PM
 */
public class Solution26 {

  private Map<Integer, Boolean>[] rows = new HashMap[9];
  private Map<Integer, Boolean>[] cols = new HashMap[9];
  private Map<Integer, Boolean>[] boxes = new HashMap[9];
  private Boolean res = false;

  public static void main(String[] args) {
    Solution26 solution26 = new Solution26();
    String[][] strings = {
        {"5", "3", ".", ".", "7", ".", ".", ".", "."},
        {"6", ".", ".", "1", "9", "5", ".", ".", "."},
        {".", "9", "8", ".", ".", ".", ".", "6", "."},
        {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
        {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
        {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
        {".", "6", ".", ".", ".", ".", "2", "8", "."},
        {".", ".", ".", "4", "1", "9", ".", ".", "5"},
        {".", ".", ".", ".", "8", ".", ".", "7", "9"}
    };
    char[][] board = solution26.parse(strings);
    solution26.solveSudoku(board);
  }

  public char[][] parse(String[][] strings) {
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = strings[i][j].charAt(0);
      }
    }
    return board;
  }

  public void solveSudoku(char[][] board) {
    // 初始化
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashMap<>();
      cols[i] = new HashMap<>();
      boxes[i] = new HashMap<>();
    }
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char num = board[i][j];
        if (num == '.') {
          continue;
        } else {
          int boxIndex = (i / 3) * 3 + j / 3;
          int n = (int) (num - '0');
          rows[i].put(n, true);
          cols[j].put(n, true);
          boxes[boxIndex].put(n, true);
        }
      }
    }

    // 递归回溯
    helper(board, 0, 0);
  }

  public void helper(char[][] board, int row, int col) {
    // 递归结束条件
    if (row == board.length) { // 全部空位都被填好了
      res = true;
      return;
    }

    // 非空位置,直接进入下个位置
    if (board[row][col] != '.') {
      if (col + 1 != board[0].length) { // 不换行
        helper(board, row, col + 1);
      } else { // 换行
        helper(board, row + 1, 0);
      }
      // 剪枝
      if (res == true) {
        return;
      }
    } else {
      // 寻找合适的k填入
      for (int k = 1; k < 10; k++) {
        int boxIndex = (row / 3) * 3 + col / 3;
        if (!check(row, col, boxIndex, k)) {
          continue;
        } else {
          rows[row].put(k, true);
          cols[col].put(k, true);
          boxes[boxIndex].put(k, true);
          board[row][col] = (char) (k + '0');

          // 继续计算下一个位置
          if (col + 1 != board[0].length) { // 不换行
            helper(board, row, col + 1);
          } else { // 换行
            helper(board, row + 1, 0);
          }

          // 剪枝
          if (res == true) {
            return;
          }

          // 回溯
          rows[row].remove(k);
          cols[col].remove(k);
          boxes[boxIndex].remove(k);
          board[row][col] = '.';
        }
      }
    }
  }

  // k是否能填入
  public boolean check(int row, int col, int boxIndex, int k) {
    if (rows[row].containsKey(k) || cols[col].containsKey(k) || boxes[boxIndex].containsKey(k)) {
      return false;
    } else {
      return true;
    }
  }
}
