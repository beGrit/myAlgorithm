package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: lsf Time: 8/21/20-8:18 PM
 */
class Solution4 {

  private static final double EPSILON = 1e-6;
  private static final double target = 24;
  private static final int add = 0;
  private static final int multiply = 1;
  private static final int subtract = 2;
  private static final int divide = 3;

  public static void main(String[] args) {
    Solution4 solution4 = new Solution4();
    solution4.judgePoint24(new int[]{4, 1, 8, 7});
  }

  public boolean judgePoint24(int[] nums) {
    // 转int为double
    Double[] a = new Double[nums.length];
    for (int i = 0; i < nums.length; i++) {
      a[i] = (double) nums[i];
    }
    return subJudge(Arrays.asList(a));
  }

  /**
   * 递归回溯法 将每一次状态都存储起来,以便回溯
   */
  public boolean subJudge(List<Double> list) {
    if (list.size() == 0) {
      return false;
    }
    if (list.size() == 1) {
      return (Math.abs(list.get(0) - target)) < EPSILON;
    }
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.size(); j++) {
        if (i != j) {
          // 存储下个状态,用于回溯
          List<Double> newList = new ArrayList<Double>();
          for (int k = 0; k < list.size(); k++) {
            if (k != i && k != j) {
              newList.add(list.get(k));
            }
          }
          Double iV = list.get(i);
          Double jV = list.get(j);
          for (int k = 0; k < 4; k++) {
            // 加法和乘法的交换律 优化次数
            if (k < 2 && i > j) {
              continue;
            }
            if (k == add) {
              newList.add(iV + jV);
            } else if (k == multiply) {
              newList.add(iV * jV);
            } else if (k == subtract) {
              newList.add(iV - jV);
            } else if (k == divide) {
              if (Math.abs(list.get(j)) < EPSILON) {
                continue;
              } else {
                newList.add(iV / jV);
              }
            }
            if (subJudge(newList)) {
              return true;
            }
            newList.remove(newList.size() - 1);
          }
        }
      }
    }
    return false;
  }
}