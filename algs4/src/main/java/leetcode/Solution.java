package leetcode;

/**
 * Author: lsf Time: 12/15/20-5:45 PM
 */
public class Solution {


  public int monotoneIncreasingDigits(int N) {

    /**
     * 最大整数,位数 ---> 单调递增
     * Input Case:
     *  1. N = 10 : 9
     *  2. N = 1234 : 1234
     *      N = 1232 : 1199 1229
     *  3. N = 332 : 299 329  == > , <
     *  4. N = 3322 : 3299
     *  5. N = 3433 :
     */
    int[] dp = new int[digitOfN(N)];
    #1#2#4#5
    return 0;
  }

  public int digitOfN(int N) {
    int count = 0;
    while (N > 0) { // 12
      N /= 10;
      count++;
    }
    return count == 0 ? 1 : count;
  }
}
