package leetcode.daily.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsf Time: 10/28/20-10:11 AM
 */
public class Solution70 {

  public static void main(String[] args) {
    Solution70 solution70 = new Solution70();
    int[] arr = {};
    solution70.uniqueOccurrences(arr);
  }

  public boolean uniqueOccurrences(int[] arr) {
    return function1(arr);
  }

  public boolean function1(int[] arr) {
    int len = arr.length;
    boolean res = true;
    Arrays.sort(arr);
    Map<Integer, Boolean> map = new HashMap<>();
    int count = 1;
    for (int i = 1; i <= len; i++) {
      if (i == len || arr[i] != arr[i - 1]) {
        if (map.containsKey(count)) {
          res = false;
          break;
        } else {
          map.put(count, true);
        }
        count = 1;
      } else {
        count++;
      }
    }
    return res;
  }
}
