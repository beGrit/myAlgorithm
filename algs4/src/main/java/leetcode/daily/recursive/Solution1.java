package leetcode.daily.recursive;

import java.util.Arrays;

/**
 * Author: lsf Time: 11/15/20-11:18 AM
 */
public class Solution1 {

  private int[][] memo;

  // 514. 自由之路
  public int findRotateSteps(String ring, String key) {
    this.memo = new int[ring.length()][key.length()];
    for (int i = 0; i < ring.length(); i++) {
      for (int j = 0; j < key.length(); j++) {
        memo[i][j] = -1;
      }
    }
    return dfs(ring, key, 0, 0) + key.length();
  }

  /**
   * @param ring
   * @param key
   * @param ringI 此子层中button对准的字母的下标
   * @param keyI  此子层中需要哪个字母
   * @return
   */
  public int dfs(String ring, String key, int ringI, int keyI) {
    if (keyI == key.length()) { // 递归终止条件: 已经拼写好所有的字母
      return 0;
    }
    int minCount = Integer.MAX_VALUE;
    char tarChar = key.charAt(keyI);

    // 记忆化剪枝
    if (memo[ringI][keyI] != -1) {
      return memo[ringI][keyI];
    }

    for (int i = 0; i < ring.length(); i++) {
      if (tarChar == ring.charAt(i)) {
        int nextRtn = dfs(ring, key, i, keyI + 1);
        int curRtn = nextRtn + Math.min(Math.abs(ringI - i), ring.length() - Math.abs(ringI - i));
        minCount = Math.min(minCount, curRtn);
      }
    }
    memo[ringI][keyI] = minCount;
    return minCount;
  }
}
