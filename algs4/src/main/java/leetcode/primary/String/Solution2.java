package leetcode.primary.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsf Time: 9/20/20-11:58 AM
 */
public class Solution2 {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] hash = new int[26];
    for (int i = 0; i < s.length(); i++) {
      hash[s.charAt(i) - 'a']++;
      hash[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (hash[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
