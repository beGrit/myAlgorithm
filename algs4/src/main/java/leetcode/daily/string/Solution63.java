package leetcode.daily.string;

/**
 * Author: lsf Time: 10/21/20-10:08 AM
 */
public class Solution63 {


  public static void main(String[] args) {
    Solution63 solution63 = new Solution63();
    String name = "alex";
    String typed = "leex";
    boolean res = solution63.isLongPressedName(name, typed);
  }

  public boolean function1(String name, String typed) {
    int len1 = name.length();
    int len2 = typed.length();
    int p1 = len1 - 1, p2 = len2 - 1;
    boolean res = true;
    while (p1 >= 0 && p2 >= 0) {
      int count1 = 1;
      int count2 = 1;
      while (true) {
        if (p1 == 0) {
          break;
        } else if (name.charAt(p1) != name.charAt(p1 - 1)) {
          break;
        }
        p1--;
        count1++;
      }
      while (true) {
        if (p2 == 0) {
          break;
        } else if (typed.charAt(p2) != typed.charAt(p2 - 1)) {
          break;
        }
        p2--;
        count2++;
      }
      if (count2 >= count1 && name.charAt(p1) == typed.charAt(p2)) {
        p1--;
        p2--;
      } else {
        res = false;
        break;
      }
    }
    if (p1 >= 0 || p2 >= 0) {
      res = false;
    }
    return res;
  }
  public boolean isLongPressedName(String name, String typed) {
    return function2(name, typed);
  }

  /**
   * 双指针优化版
   *
   * @param name
   * @param typed
   * @return
   */
  public boolean function2(String name, String typed) {
    int p1 = 0, p2 = 0;
    int len1 = name.length(), len2 = typed.length();
    while (true) {
      if (p1 != len1 && p2 != len2 && name.charAt(p1) == typed.charAt(p2)) { //
        p1++;
        p2++;
      } else if (p1 == len1) {
        if (p2 == len2) {
          return true;
        } else if (p2 != 0 && typed.charAt(p2) == typed.charAt(p2 - 1)) {
          p2++;
        } else {
          return false;
        }
      } else if (p2 == len2) {
        return false;
      } else {
        if (p2 != 0 && typed.charAt(p2) == typed.charAt(p2 - 1)) {
          p2++;
        } else {
          return false;
        }
      }
    }
  }
}
