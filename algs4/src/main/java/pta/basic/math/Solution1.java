package pta.basic.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Author: lsf Time: 10/29/20-10:27 AM
 */
public class Solution1 {

  private Map<Integer, Boolean> map = new HashMap<>();
  private int[] nums;

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int[] nums = {3, 5, 6, 7, 8, 11};
    solution1.findKeyNum(nums);
  }

  public void input() {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    this.nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
  }

  public void output() {

  }

  /**
   * 题目: 1005.继续(3n + 1)猜想
   */
  public Integer[] findKeyNum(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int num : nums) {
      if (resolveSteps(num)) {
        res.add(num);
      }
    }
    return (Integer[]) res.toArray();
  }

  public boolean resolveSteps(int N) {
    if (map.containsKey(N)) {
      return false;
    } else {
      map.put(N, true);
    }
    while (N != 1) {
      if (N % 2 == 0) {
        N /= 2;
      } else {
        N = (3 * N + 1) / 2;
      }
    }
    return true;
  }
}
