package leetcode.medium.sortandsearch;

/**
 * Author: lsf Time: 10/28/20-10:56 AM
 */
public class Solution8 {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }
    boolean res = false;
    int row = 0;
    int col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] > target) {
        col--;
      } else if (matrix[row][col] < target) {
        row++;
      } else {
        res = true;
        break;
      }
    }
    return res;
  }
}
