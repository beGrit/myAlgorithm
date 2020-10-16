package leetcode.daily;

/**
 * Author: lsf Time: 9/13/20-9:04 AM
 */
public class Solution24 {

  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};
  boolean tag = false;

  public static void main(String[] args) {
    Solution24 solution24 = new Solution24();
    char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    String target = "EESCE";
    solution24.exist(board,target);
  }

  public boolean exist(char[][] board, String word) {
    char[] target = word.toCharArray();
    boolean[][] visited = new boolean[board.length][board[0].length];
    if (target.length == 0) {
      return tag;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (target[0] == board[i][j]) {
          visited[i][j] = true;
          helper(board, target, 1, i, j, visited);
          visited[i][j] = false;
        }
      }
    }
    return tag;
  }

  public void helper(char[][] board, char[] target, int count, int x1, int y1, boolean[][] visited) {
    if (count == target.length) {
      tag = true;
      return;
    }
    int height = board.length;
    int width = board[0].length;
    char c = target[count];
    for (int i = 0; i < 4; i++) {
      int x2 = x1 + dx[i];
      int y2 = y1 + dy[i];
      // 剪枝
      if (x2 < 0 || x2 >= height || y2 < 0 || y2 >= width) {
        continue;
      }
      if (visited[x2][y2]) {
        continue;
      }
      if (tag) {
        return;
      }
      if (board[x2][y2] == c) {
        visited[x2][y2] = true;
        helper(board, target, count + 1, x2, y2, visited);
        // 回溯
        visited[x2][y2] = false;
      }
    }
  }
}
