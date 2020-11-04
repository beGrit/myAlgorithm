package pta.basic;

import java.util.Scanner;

/**
 * Author: lsf Time: 10/29/20-9:49 PM
 */
public class Solution6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    intToString(num);
  }
  public static String intToString(int num) {
    if (num > 999) {
      return null;
    }
    String res = "";
    int a = num / 100;
    num = num % 100;
    int b = num / 10;
    num = num % 10;
    int c = num;
    int d = 1;
    while (a + b + c != 0) {
      if (a != 0) {
        res = res.concat("B");
        a--;
      } else if (b != 0) {
        res = res.concat("S");
        b--;
      } else {
        res = res.concat(String.valueOf(d));
        d++;
        c--;
      }
    }
    return res;
  }
}
