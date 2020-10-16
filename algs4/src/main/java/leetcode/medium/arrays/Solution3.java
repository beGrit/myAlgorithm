package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 9/23/20-6:33 PM
 */
public class Solution3 {

  private List<List<String>> res = new LinkedList<>();
  private Map<String, List<String>> hash2 = new HashMap<>();
  private Map<Long, List<String>> hash3 = new HashMap<>();

  public List<List<String>> groupAnagrams(String[] strs) {
    function3(strs);
    return new ArrayList<>(hash3.values());
  }

  /**
   * 方法一: 迭代 + Hash表比较
   *
   * @param strs
   */
  public void function1(String[] strs) {
    int len = strs.length;
    boolean[] hasGroup = new boolean[len];

    /**
     * 迭代并且通过比较Hash表来判断是否是同一组
     */
    for (int i = 0; i < strs.length; i++) {
      if (hasGroup[i]) {
        continue;
      }
      hasGroup[i] = true;
      List<String> curGroup = new ArrayList<>();
      curGroup.add(strs[i]);
      int[] counter = new int[27];
      for (int j = i + 1; j < strs.length; j++) { // n
        if (hasGroup[j]) {
          continue;
        }
        if (strs[i].length() != strs[j].length()) {
          continue;
        }
        if (isSameGroup(strs[i], strs[j])) {
          hasGroup[j] = true;
          curGroup.add(strs[j]);
        }
      }
      res.add(curGroup);
    }
  }

  public boolean isSameGroup(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
      table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      table[t.charAt(i) - 'a']--;
      if (table[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Hash法优化版
   *
   * @param strs
   */
  public void function2(String[] strs) {
    int[] count = new int[26];
    for (String s : strs) {
      Arrays.fill(count, 0);
      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }
      StringBuilder sb = new StringBuilder("");
      for (int i = 0; i < 26; i++) {
        sb.append("#");
        sb.append(count[i]);
      }
      String key = sb.toString();
      if (!hash2.containsKey(key)) {
        hash2.put(key, new ArrayList<>());
      }
      hash2.get(key).add(s);
    }
  }

  /**
   * Hash法再优化:质数相乘
   */
  public void function3(String[] strs) {
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
        83, 89, 97, 101, 103};
    for (String s : strs) {
      long key = 1;
      for (char c : s.toCharArray()) {
        key *= prime[c - 'a'];
      }
      if (!hash3.containsKey(key)) {
        hash3.put(key, new ArrayList<>());
      }
      hash3.get(key).add(s);
    }
  }
}

