package leetcode.daily;

/**
 * Author: lsf Time: 8/28/20-4:19 PM
 */
public class Solution10 {

  public boolean judgeCircle(String moves) {
    int[] tmp = new int[4];
    for (int i = 0; i < 4; i++) {
      tmp[i] = 0;
    }
    for (int i = 0; i < moves.length(); i++) {
      switch (moves.charAt(i)) {
        case 'R':tmp[0] += 1;break;
        case 'L':tmp[1] += 1;break;
        case 'U':tmp[2] += 1;break;
        case 'D':tmp[3] += 1;break;
      }
    }
    return tmp[0] == tmp[1] && tmp[2] == tmp[3];
  }

  public static void main(String[] args) {
    new Solution10();
  }
}
