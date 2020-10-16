package leetcode.medium.arrays;

/**
 * Author: lsf Time: 9/22/20-10:13 PM
 */
public class Solution2 {
  public void setZeroes(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    boolean rowTag = false;
    boolean colTag = false;
    // 检查第一行和第一列的数据
    for (int row = 0; row < height; row++) {
      if (matrix[row][0] == 0) {
        colTag = true;
      }
    }

    for (int col = 0; col < width; col++) {
      if (matrix[0][col] == 0) {
        rowTag = true;
      }
    }

    for (int row = 0; row < height; row++) {
      for (int col = 0; col <  width; col++) {
        if (matrix[row][col] == 0) {
          matrix[row][0] = 0;
          matrix[0][col] = 0;
        }
      }
    }

    for (int col = 0; col < width; col++) {
      if (matrix[0][col] == 0 && col != 0) {
        for (int row = 1; row < height; row++) {
          matrix[row][col] = 0;
        }
      }
    }
    for (int row = 0; row < height; row++) {
      if (matrix[row][0] == 0 && row != 0) {
        for (int col = 1; col < width; col++) {
          matrix[row][col] = 0;
        }
      }
    }

    if (colTag) {
      for (int i = 0; i < height; i++) {
        matrix[i][0] = 0;
      }
    }
    if (rowTag) {
      for (int i = 0; i < width; i++) {
        matrix[0][i] = 0;
      }
    }
  }
}
