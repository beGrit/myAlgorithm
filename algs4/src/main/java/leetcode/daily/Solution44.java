package leetcode.daily;

/**
 * Author: lsf Time: 10/2/20-10:19 PM
 */
public class Solution44 {
  public int numJewelsInStones(String J, String S) {
    int sum = 0;
    for (char c1 : S.toCharArray()) {
      for (char c2 : J.toCharArray()) {
        if (c2 == c1) {
          sum++;
        }
      }
    }
    return sum;
  }
}
