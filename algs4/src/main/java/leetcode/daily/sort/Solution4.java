package leetcode.daily.sort;

import java.util.Map;

/**
 * Author: lsf Time: 11/15/20-10:11 AM
 */
public class Solution4 {


  // 1122. 数组的相对排序
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    return function1(arr1, arr2);
  }

  // 方法一: Hash表
  public int[] function1(int[] arr1, int[] arr2) {
    int maxVal = 0;
    for (int num : arr1) {
      maxVal = Math.max(maxVal, num);
    }
    int[] map = new int[maxVal + 1];
    for (int num : arr1) {
      map[num]++;
    }
    int index = 0;
    int[] rtn = new int[arr1.length];
    for (int num : arr2) {
      for (int i = 0; i < map[num]; i++) {
        rtn[index] = num;
        index++;
      }
    }
    for (int i = 0; i < maxVal; i++) {
      for (int j = 0; j < map[i]; j++) {
        rtn[index] = i;
        index++;
      }
    }
    return rtn;
  }

  public static void main(String[] args) {
    int[] nums = new int[10];
    int index = 0;
    for (int i = 0; i < 3; i++) {
      nums[index++] = i;
    }
    System.out.println();
  }
}
