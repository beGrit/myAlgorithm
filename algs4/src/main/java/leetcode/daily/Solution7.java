package leetcode.daily;

import edu.princeton.cs.algs4.MaxPQ;
import java.util.Arrays;

/**
 * Author: lsf Time: 8/26/20-3:24 PM
 */
public class Solution7 {

  MaxPQ<Integer> maxPQ;

  public static void main(String[] args) {
    Solution7 solution7 = new Solution7();
    int[] piles = {2,4,1,2,7,8};
    solution7.maxCoins(piles);
  }

  public int maxCoins(int[] piles) {
    int sum = 0;
/*    IntStream stream = Arrays.stream(piles);
    Stream<Integer> integerStream = stream.boxed();
    Integer[] piles2 = integerStream.toArray(Integer[]::new);
    maxPQ = new MaxPQ(piles2);
    for (int c = 0; c < piles.length / 3; c++) {
      maxPQ.delMax();
      sum += maxPQ.delMax();
    }*/
    Arrays.sort(piles);
    int index = piles.length - 2;
    for (int c = 0; c < piles.length / 3; c++) {
      sum += piles[index];
      index -= 2;
    }
    return sum;
  }
}