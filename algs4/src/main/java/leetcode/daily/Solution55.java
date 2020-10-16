package leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 10/14/20-10:17 AM
 */
public class Solution55 {

  public List<String> commonChars(String[] A) {
    List<String> res = new ArrayList<>();
    int len = A.length;
    int[][] map = new int[len][26];

    // 特殊情况
    if (len == 0) {
      return res;
    }
    if (len == 1) {
      for (int i = 0; i < A[0].length(); i++) {
        String s = String.valueOf(A[0].charAt(i));
        res.add(s);
      }
      return res;
    }

    // 初始化hash表
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < 26; j++) {
        map[i][j] = 0;
      }
      for (int j = 0; j < A[i].length(); j++) {
        map[i][A[i].charAt(j) - 'a'] += 1;
      }
    }

    // 查询hash表
    for (int i = 0; i < A[0].length(); i++) {
      boolean b = helper(map, 1, A[0].charAt(i));
      if (b) res.add(String.valueOf(A[0].charAt(i)));
    }
    return res;
  }
  public boolean helper(int[][] map, int num, char c) {
    if (num >= map.length) {
      return true;
    }
    if (map[num][c - 'a'] > 0) {
      map[num][c - 'a'] -= 1;
      boolean b = true & helper(map, num + 1, c);
      if (!b) {
        map[num][c - 'a'] += 1;
      }
      return b;
    } else {
      return false;
    }
  }
}
