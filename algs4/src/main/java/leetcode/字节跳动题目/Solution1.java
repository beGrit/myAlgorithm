package leetcode.字节跳动题目;

import java.util.Collections;

/**
 * Author: lsf Time: 8/28/20-5:42 PM
 */
public class Solution1 {

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    String s = "aacecaaa";
    solution1.shortestPalindrome(s);
  }

  public String shortestPalindrome(String s) {
    int len = s.length();
    char[] cs1 = s.toCharArray();
    // 找到 最长子回文串 [0,board]
    int board = len - 1;
    for (; board >= 0; board--) {
      int left = 0;
      int right = board;
      if (isHWString(cs1, left, right)) {
        break;
      }
    }
    StringBuilder addHeader = new StringBuilder(s.substring(board + 1,len)).reverse();
    // 拼接 [board + 1,length - 1]
    String ans = addHeader.toString() + s;
    return ans;
  }

  public boolean isHWString(char[] cs, int left, int right) {
    boolean res = true;
    while (left <= right) {
      if (cs[left] != cs[right]) {
        res = false;
        break;
      } else {
        left++;
        right--;
      }
    }
    return res;
  }
}
