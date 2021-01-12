package leetcode.daily.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 11/5/20-1:42 PM
 */
public class Solution1 {

  // 127. 单词接龙

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    String beginWord = "hit";
    String endWord = "cog";
    String[] words = {"hot", "dot", "dog", "lot", "log","cog"};
    int res = solution1.ladderLength(beginWord, endWord, Arrays.asList(words));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //
    if (beginWord.length() != endWord.length()) {
      return -1;
    } else if (beginWord.equals(endWord)) {
      return 0;
    }
    Map<String, Boolean> map = new HashMap<>();
    for (String word : wordList) {
      map.put(word, false);
    }
    int count = dfs(beginWord, endWord, -1, map);
    return count == Integer.MAX_VALUE ? 0 : count;
  }


  public int dfs(String curWord, String endWord, int preIndex, Map<String, Boolean> wordList) {
    if (curWord.equals(endWord)) {
      return 1;
    }
    int count = Integer.MAX_VALUE;
    for (int i = 0; i < curWord.length(); i++) {
      if (i != preIndex) {
        char[] chars = curWord.toCharArray();
        for (int j = 0; j < 26; j++) {
          chars[i] = (char) ('a' + j);
          String s = new String(chars);
          if (wordList.containsKey(s)) { // 有这个单词
            if (!wordList.get(s)) { // 单词没被遍历过
              wordList.put(s, true);
              int nextCount = dfs(s, endWord, i, wordList);
              if (nextCount != Integer.MAX_VALUE) {
                count = Math.min(count, nextCount + 1);
              }
              wordList.put(s, false);
            }
          }
        }
      }
    }
    return count;
  }
}
