package leetcode.primary.dp;

/**
 * Author: lsf Time: 9/13/20-12:36 PM
 */
public class Solution2 {

  public int maxProfit(int[] prices) {
    int len = prices.length;
    int min = 0;
    int maxProfit = 0;
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        min = prices[i];
        maxProfit = 0;
      } else {
        min = Math.min(min,prices[i]);
        maxProfit = Math.max(maxProfit,prices[i] - min);
      }
    }
    return maxProfit;
  }
}
