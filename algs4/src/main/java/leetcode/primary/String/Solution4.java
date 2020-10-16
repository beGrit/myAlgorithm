package leetcode.primary.String;


/**
 * Author: lsf Time: 9/20/20-6:37 PM
 */
public class Solution4 {

  /**
   * 方法一:KMP算法
   * @param haystack
   * @param needle
   * @return
   */
  public int strStr(String haystack, String needle) {
    KMP kmp = new KMP();
    int[] next = kmp.getNext(needle);
    int i = 0;
    int j = 0;
    while (i < haystack.length() && j < needle.length()) {
      if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }
    if (j == needle.length()) {
      return i - j;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    Solution4 solution4 = new Solution4();
    solution4.strStr("mississippi","issip");
  }
}
class KMP {
  public int[] getNext(String s) {
    int len = s.length();
    int next[] = new int[len + 1];
    char[] chars = s.toCharArray();
    int i = 0;
    int j = -1;
    next[0] = -1;
    while (i < len) {
      if (j == -1 || chars[i] == chars[j]) {
        i++;
        j++;
        next[i] = j;
      } else {
        j = next[j];
      }
    }
    return next;
  }
}