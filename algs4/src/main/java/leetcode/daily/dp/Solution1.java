package leetcode.daily.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: lsf Time: 10/28/20-8:12 PM
 */
public class Solution1 {
  // 139. 单词拆分 I

  private boolean[] memo;

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    String s = "catsandog";
    String[] arrays = {"cats", "dog", "sand", "and", "cat"};
    List<String> list = Arrays.asList(arrays);
    solution1.wordBreak(s, list);
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    this.memo = new boolean[s.length()];
    Set<String> set = new HashSet<>();
    for (String word : wordDict) {
      set.add(word);
    }
    return function1_2(set, s, 0);
  }

  /**
   * 方法一:递归(DFS) (超时)
   *
   * @param wordSet
   * @param s
   * @param bg
   */
  public boolean function1(Set<String> wordSet, String s, Integer bg) {
    if (bg == s.length()) {
      return true;
    }
    for (int i = bg + 1; i <= s.length(); i++) {
      if (wordSet.contains(s.substring(bg, i))) {
        if (function1(wordSet, s, i)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 方法一_2:递归 + 记忆化
   */
  public boolean function1_2(Set<String> wordSet, String s, Integer bg) {
    if (bg == s.length()) {
      return true;
    }
    if (memo[bg]) { // bg位置已经遍历过了,并且后面不会成功
      return false;
    }
    for (int i = bg + 1; i <= s.length(); i++) {
      if (wordSet.contains(s.substring(bg, i))) {
        if (function1_2(wordSet, s, i)) {
          return true;
        }
      }
    }
    memo[bg] = true;
    return false;
  }

  /**
   * 方法二:dp动态规划 dp[i] 表示 s.substring(0,i) {[0,i)} 是否为符合条件 状态转移方程: dp[i] = dp[i - j] &&
   * set.contains(j,i)
   */
  public boolean function2(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    int len = s.length();
    boolean[] dp = new boolean[len];
    dp[0] = true;
    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
        }
      }
    }
    return dp[len - 1];
  }
}
