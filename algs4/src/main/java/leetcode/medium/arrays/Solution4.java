package leetcode.medium.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: lsf Time: 9/26/20-7:03 PM
 */
public class Solution4 {

  public static void main(String[] args) {
    Solution4 solution4 = new Solution4();
    solution4.lengthOfLongestSubstring("pwwkew");
  }


  public int lengthOfLongestSubstring(String s) {
    return function2(s);
  }

  public int funciton(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int len = s.length();
    int[] dp = new int[len];
    int maxCount = 0;
    for (int i = 0; i < len; i++) {
      if (!map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), i);
        if (i == 0) {
          dp[i] = 1;
        } else {
          dp[i] = dp[i - 1] + 1;
        }
        if (dp[i] > maxCount) {
          maxCount = dp[i];
        }
      } else {
        Integer index = map.get(s.charAt(i));
        dp[i] = i - index;
        while (index >= 0) {
          char c = s.charAt(index);
          if (!map.containsKey(c) || map.get(c) != index) {
            break;
          } else {
            map.remove(c);
          }
          index--;
        }
        map.put(s.charAt(i), i);
      }
    }
    return maxCount;
  }

  /**
   * 优化版本:滑动窗口(Sliding Window)
   *
   * @param s
   * @return
   */
  public int function2(String s) {
    Set<Character> set = new HashSet<>();
    int rp = 1;
    int maxWidth = 0;
    int len = s.length();
    for (int lp = 0; lp < len; lp++) {
      if (lp == 0) {
        set.add(s.charAt(lp));
        maxWidth = 1;
      } else {
        set.remove(s.charAt(lp - 1));
      }
      while (rp < len && !set.contains(s.charAt(rp))) {
        set.add(s.charAt(rp));
        rp++;
      }
      maxWidth = Math.max(maxWidth,rp - lp);
    }
    return maxWidth;
  }
}
