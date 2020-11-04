package pta.basic;

import java.util.Scanner;

/**
 * Author: lsf Time: 10/12/20-9:51 AM
 */
public class Solution1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int count = new Solution1().resolveSteps(N);
    System.out.println(count);
  }

  public int resolveSteps(int N) {
    int count = 0;
    while (N != 1) {
      if (N % 2 == 0) {
        N /= 2;
      } else {
        N = (3 * N + 1) / 2;
      }
      count++;
    }
    return count;
  }
}
