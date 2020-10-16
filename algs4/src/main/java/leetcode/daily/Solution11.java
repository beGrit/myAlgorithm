package leetcode.daily;

import java.util.List;

/**
 * Author: lsf Time: 8/31/20-1:31 PM
 */
public class Solution11 {

  private boolean visited[];

  public static void main(String[] args) {
    Solution11 solution11 = new Solution11();
    String res = solution11.reverseWords("Let's take LeetCode contest");
  }

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    DFS(0, rooms);
    return check();
  }

  public void DFS(int target, List<List<Integer>> rooms) {
    visited[target] = true;
    List<Integer> keys = rooms.get(target);
    for (int key : keys) {
      if (!visited[key]) {
        DFS(key, rooms);
      }
    }
  }

  public boolean check() {
    for (boolean b : visited) {
      if (!b) {
        return false;
      }
    }
    return true;
  }

  public String reverseWords(String s) {
    String[] s1 = s.split(" ");
    String res = new String();
    for (String s2 : s1) {
      s2 = reverseWord(s2);
      res = res + s2 + " ";
    }
    return res.trim();
  }

  public String reverseWord(String s) {
    StringBuilder reverse = new StringBuilder(s).reverse();
    return reverse.toString();
  }
}
