package leetcode.daily.dp;

/**
 * Author: lsf Time: 11/11/20-1:30 PM
 */
public class Solution4 {

  private int res = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Solution4 solution4 = new Solution4();
//    String newRing = solution4.getNewRing("godding", 2);
    solution4.findRotateSteps("godding","gd");
  }


  public int findRotateSteps(String ring, String key) {
    // 记录当前字符串的顺序
    dfs(ring, key, 0, 0);
    res += key.length();
    return res;
  }

  public void dfs(String ring, String key, int index, int count) {
    if (index == key.length()) {
      res = Math.min(res, count);
      return;
    }
    char target = key.charAt(index);
    for (int i = 0; i < ring.length(); i++) {
      int n = Math.min(i, ring.length() - i);
      if (ring.charAt(i) == target) {
        dfs(getNewRing(ring, i), key, index + 1, count + n);
      }
    }
  }

  public String getNewRing(String old, int index) {
    String substring1 = old.substring(index);
    String substring2 = old.substring(0, index);
    return substring1.concat(substring2);
  }
}
