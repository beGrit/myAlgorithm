package leetcode.primary.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 9/19/20-8:55 PM
 */
public class Solution1 {

  /**
   * 题目:
   * 3的倍数,输出Fizz
   * 5的倍数,输出Buzz
   * 3 and 5 的倍数,输出FizzBuzz
   * @param n
   * @return
   */
  public List<String> fizzBuzz(int n) {
    List<String> res = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        res.add(new String("FizzBuzz"));
      } else if (i % 3 == 0) {
        res.add(new String("Fizz"));
      } else if (i % 5 == 0) {
        res.add(new String("Buzz"));
      } else {
        res.add(Integer.toString(i));
      }
    }
    return res;
  }
}
