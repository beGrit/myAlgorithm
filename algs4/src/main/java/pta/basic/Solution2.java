package pta.basic;

import java.util.Scanner;

/**
 * Author: lsf Time: 10/12/20-9:59 AM
 */
public class Solution2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    if (input.equals("")) {
      System.out.println("");
      System.exit(0);
    }
    int sum = 0;
    for (Character c : input.toCharArray()) {
      sum += (Integer) (c - '0');
    }
    System.out.println(output(sum));
  }

  public static String output(int sum) {
    String[] strings = {"lin", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
    StringBuilder stringBuilder = new StringBuilder("");
    do {
      int tmp = sum % 10;
      stringBuilder.insert(0, strings[tmp] + " ");
      sum /= 10;
    } while (sum != 0);
    return stringBuilder.toString().trim();
  }
}
