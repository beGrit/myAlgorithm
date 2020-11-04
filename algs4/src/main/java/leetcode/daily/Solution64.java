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
    // 第一遍遍历,统计 S 中各个字符出现的频率
    for (int i = 0; i < len; i++) {
      map[chars[i] - 'a']++;
    }
    Map<Character, Boolean> path = new HashMap<>();
    // count 记录 path 路径中的所有字符在后续还会出现多少次的总和
    int count = 0;
    int n = 0;
    path.put(chars[0],true);
    count += map[chars[0] - 'a'] - 1;
    n += map[chars[0] - 'a'];
    for (int i = 1; i < len + 1; i++) {
      if (count > 0) {
        if (path.containsKey(chars[i])) {
          count--;
        } else {
          path.put(chars[i],true);
          count += map[chars[i] - 'a'] - 1;
          n += map[chars[i] - 'a'];
        }
      } else if (count == 0) { // 若 count 为 0, 则 表示[i - 1]位置后不会再出现path中的任何字符
        // 切片(清理维护的变量,进入下一轮)
        res.add(n);
        path.clear();
        n = 0;
        if (i != len) {
          path.put(chars[i],true);
          count += map[chars[i] - 'a'] - 1;
          n += map[chars[i] - 'a'];
        }
      }
    }
    return res;
  }


}
