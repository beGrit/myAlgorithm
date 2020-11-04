package leetcode.daily.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: lsf Time: 11/3/20-11:08 AM
 */
public class Solution2 {
  // 140. 单词拆分 II

  public static void main(String[] args) {
    Solution2 solution2 = new Solution2();
    String s = "pineapplepenapple";
    List<String> list = Arrays
        .asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"});
    solution2.wordBreak(s, list);
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> res = new ArrayList<>();
    Set<String> set = new HashSet<>();
    for (String word : wordDict) {
      set.add(word);
    }
    List<List<String>> lists = function1(s, set, 0, new HashMap<>());
    for (List<String> list : lists) {
      String s1 = new String("");
      for (String subString : list) {
        s1 = s1.concat(subString + " ");
      }
      res.add(s1.trim());
    }
    return res;
  }

  /**
   * 方法一:记忆化递归(DFS)
   * @param s
   * @param wordSet
   * @param bg
   * @param map 某个位置的记忆
   * @return 当前bg位置后符合条件的字符串组
   */
  public List<List<String>> function1(String s, Set<String> wordSet, int bg,
      Map<Integer, List<List<String>>> map) {
    if (!map.containsKey(bg)) {
      List<List<String>> wordBreaks = new LinkedList<List<String>>();
      if (bg == s.length()) {
        wordBreaks.add(new LinkedList<String>());
      }
      for (int i = bg + 1; i <= s.length(); i++) {
        String word = s.substring(bg, i);
        if (wordSet.contains(word)) {
          List<List<String>> nextWordBreaks = function1(s, wordSet, i, map);
          for (List<String> nextWordBreak : nextWordBreaks) {
            LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
            wordBreak.offerFirst(word);
            wordBreaks.add(wordBreak);
          }
        }
      }
      map.put(bg, wordBreaks);
    }
    return map.get(bg);
  }
}
