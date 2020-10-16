package leetcode.daily;

/**
 * Author: lsf Time: 10/8/20-4:16 PM
 */
public class Solution49 {

  public void reverseString(char[] s) {
    int len = s.length;
    int left = 0;
    int right = len - 1;
    while (right > left) {
      char tmp = s[left];
      s[left] = s[right];
      s[right] = tmp;
      left++;
      right--;
    }
  }
}
