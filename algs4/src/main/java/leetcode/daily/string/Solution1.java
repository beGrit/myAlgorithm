package leetcode.daily.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: lsf Time: 11/15/20-11:42 AM
 */
public class Solution1 {

  /**
   * 题目解析
   */

  // 402. 移掉K位数字
  public String removeKdigits(String num, int k) {
    return function1(num, k);
  }

  /*
  方法一: 单调栈 + 贪心算法
   */
  public String function1(String num, int k) {
    // 维护一个满足单调递增性的栈
    Deque<Integer> deque = new LinkedList<>();
    int len = num.length();
    for (int i = 0; i < len; i++) {
      Integer digit = (Integer) (num.charAt(i) - '0');
      while (k > 0 && !deque.isEmpty() && digit < deque.peekLast()) {
        deque.pollLast();
        k--;
      }
      deque.offerLast(digit);
    }
    while (k > 0) {
      deque.pollLast();
      k--;
    }
    // 处理输出
    boolean leadingZero = true;
    StringBuilder rtn = new StringBuilder("");
    while (!deque.isEmpty()) {
      Integer n = deque.pop();
      if (leadingZero && n == 0) {
        continue;
      }
      leadingZero = false;
      rtn.append(n);
    }
    return rtn.length() == 0 ? "0" : rtn.toString();
  }
}
