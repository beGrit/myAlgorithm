package leetcode.primary.String;

/**
 * Author: lsf Time: 9/21/20-3:03 PM
 */
public class Solution5 {
  public String longestCommonPrefix(String[] strs) {
    int index = 0;
    try {
      while (true) {
        char c = strs[0].charAt(index);
        int i;
        for (i = 1; i < strs.length; i++) {
          if (strs[i].charAt(index) != c) {
            break;
          }
        }
        if (i != strs.length) {
          break;
        } else {
          index++;
        }
      }
      return strs[0].substring(0,index);
    } catch (StringIndexOutOfBoundsException e) {
      return strs[0].substring(0,index - 1);
    } catch (ArrayIndexOutOfBoundsException e) {
      return "";
    }
  }
}
