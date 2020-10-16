package leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: lsf Time: 8/19/20-1:48 PM
 */
public class Solution2 {

  public static void main(String[] args) {
    Solution2 solution2 = new Solution2();
/*
    int[] nums1 = new int[]{4, 9, 5};
    int[] nums2 = new int[]{9, 4, 9, 8, 4};
    solution2.intersect(nums1, nums2);
*/

/*
    solution2.countSubstrings("abcba");
    solution2.plusOne(new int[]{9, 9, 9, 9});
*/
//    solution2.moveZeroes(new int[]{1, 0, 0, 2,3});

    solution2.twoSum(new int[]{1, 4, 4, 15},8);
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int num : nums1) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }
    for (int num : nums2) {
      if (map.containsKey(num) && map.get(num) > 0) {
        map.put(num, map.get(num) - 1);
        list.add(num);
      } else {
        continue;
      }
    }
    int[] res = new int[list.size()];
    int count = 0;
    for (int i : list) {
      res[count] = i;
      count++;
    }
    return res;
  }

  public int countSubstrings(String s) {
    char[] c1 = s.toCharArray();
    int count = 0;
    boolean dp[][] = new boolean[c1.length][c1.length];
    for (int j = 0; j < c1.length; j++) {
      for (int i = 0; i <= j; i++) {
        // 状态转移方程
        if (i == j) {
          dp[i][j] = true;
          count++;
        } else if (j - i == 1 && c1[i] == c1[j]) {
          dp[i][j] = true;
          count++;
        } else if (j - i > 1 && c1[i] == c1[j] && dp[i + 1][j - 1]) {
          dp[i][j] = true;
          count++;
        }
      }
    }
    return count;
  }



  public int[] plusOne(int[] digits) {
    int len = digits.length;
    for (int i = len - 1; i >= 0; i--) {
      if (digits[i] == 9) {
        digits[i] = 0;
        if (i == 0) {
          int[] res = new int[len + 1];
          res[0] = 1;
          return res;
        }
      } else {
        digits[i] += 1;
        break;
      }
    }
    return digits;
  }

  // 0 1 0 3 12
  // 1 0 0 3 12
  /**
   * 快速排序的思想
   */
  public void moveZeroes(int[] nums) {
    int first = 0;
    int last = 0;
    boolean tag = false;
    for (int i = 0; i<nums.length; i++) {
      if (!tag && nums[i] == 0) {
        tag = true;
        first = i;
        last = i;
      } else if ( !tag && nums[i] != 0) {
        continue;
      } else if (tag && nums[i] == 0){
        last = i;
      } else if (tag && nums[i] != 0) {
        swap(nums,first,i);
        first++;
        last++;
      }
    }
  }

  public void swap(int[] nums,int i,int j) {
    assert i <= j;
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
  public int[] twoSum(int[] nums, int target) {


    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

    /**
     * 初始化HashMap
     */
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i],i);
    }
    for (int i = 0; i < nums.length; i++) {
      Integer v = map.get(target - nums[i]);
      if (v != null && i != v) {
        return new int[]{i,v};
      }
    }
    return null;
  }

  public int[] twoSum2(int[] nums, int target) {
    /*
     * 暴力法
     * */
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i,j};
        }
      }
    }
    return null;
  }
}
