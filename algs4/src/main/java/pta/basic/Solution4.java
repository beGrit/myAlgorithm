package pta.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: lsf Time: 10/12/20-11:13 AM
 */
public class Solution4 {
  public static void main(String[] args) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    List<String> maxInfo = new ArrayList<>();
    List<String> minInfo = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < N; i++) {
      String s = sc.nextLine();
      String[] strings = s.split(" ");
      if (Integer.parseInt(strings[2]) > max) {
        max = Integer.parseInt(strings[2]);
        maxInfo.clear();
        maxInfo.add(strings[0]);
        maxInfo.add(strings[1]);
      }
      if (Integer.parseInt(strings[2]) < min) {
        min = Integer.parseInt(strings[2]);
        minInfo.clear();
        minInfo.add(strings[0]);
        minInfo.add(strings[1]);
      }
    }
    System.out.println(maxInfo.get(0) + " " + maxInfo.get(1));
    System.out.println(minInfo.get(0) + " " + minInfo.get(1));
  }
}
