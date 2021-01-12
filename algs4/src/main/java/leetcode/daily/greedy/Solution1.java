package leetcode.daily.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: lsf Time: 11/16/20-10:30 AM
 */
public class Solution1 {
  // 406. 根据身高重建队列

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//    solution1.function1(people);
//    solution1.swap(1, 2, people);
    solution1.reconstructQueue(people);
    System.out.println();
  }

  public int[][] reconstructQueue(int[][] people) {
    return function1(people);
  }

  public int[][] function1(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] nums1, int[] nums2) {
        if (nums1[0] == nums2[0]) {
          return nums1[1] - nums2[1];
        } else {
          return nums2[0] - nums1[0];
        }
      }
    });

    int len = people.length;
    for (int i = 0; i < len; i++) {
      int index = i;
      int count = i - people[i][1];
      for (int j = 0; j < count; j++) {
        swap(index, index - 1, people);
        index--;
      }
    }

    return people;
  }

  private void swap(int i, int j, int[][] people) {
    int[] tmp = people[i];
    people[i] = people[j];
    people[j] = tmp;
  }
}
