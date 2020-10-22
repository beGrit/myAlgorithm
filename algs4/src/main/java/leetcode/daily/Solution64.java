package leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 10/22/20-3:06 PM
 */
public class Solution64 {

  public static void main(String[] args) {
    Solution64 solution64 = new Solution64();
    String s = "ababcbacadefegdehijhklijo";
    solution64.partitionLabels(s);
  }

  public List<Integer> partitionLabels(String S) {
    int len = S.length();
    int[] map = new int[26];
    List<Integer> res = new ArrayList<>();
    char[] chars = S.toCharArray();
    for (int i = 0; i < len; i++) {
      map[chars[i] - 'a']++;
      // a --> 0
    }
    Map<Character, Boolean> subMap = new HashMap<>();
    int count = 0;
    int n = 0;
    subMap.put(chars[0],true);
    count += map[chars[0] - 'a'] - 1;
    n += map[chars[0] - 'a'];
    for (int i = 1; i < len + 1; i++) {
      if (count > 0) {
        if (subMap.containsKey(chars[i])) {
          count--;
        } else {
          count += map[chars[i] - 'a'] - 1;
          subMap.put(chars[i],true);
          n += map[chars[i] - 'a'];
        }
      } else if (count == 0) {
        res.add(n);
        subMap.clear();
        n = 0;
        if (i != len) {
          subMap.put(chars[i],true);
          count += map[chars[i] - 'a'] - 1;
          n += map[chars[i] - 'a'];
        }
      }
    }
    return res;
  }


}
