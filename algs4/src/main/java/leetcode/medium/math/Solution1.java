package leetcode.medium.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsf Time: 10/28/20-11:23 AM
 */
public class Solution1 {

  public boolean isHappy(int n) {
    Map<Integer,Boolean> map = new HashMap<>();
    while (n != 1 && !map.containsKey(n)) {
      map.put(n,true);
      n = helper(n);
    }
    return n == 1;
  }

  public int helper(int num) {
    int res = 0;
    while (num != 0) {
      int mod = num % 10;
      num /= 10;
      res += Math.pow(mod, 2);
    }
    return res;
  }

  /**
   * 方法二(对时间)
   * @param args
   */

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int n = 19;
    solution1.isHappy(n);
  }
}
