package leetcode.primary.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Author: lsf Time: 8/23/20-10:24 AM
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
/*
    int reverse = solution.reverse(-1220);
    System.out.println(reverse);
    String s = solution.countAndSay(4);
    System.out.println(s);
    String s1 = new String("ababababab");
    solution.repeatedSubstringPattern(s1);*/
    int[] nums = {4, 6, 7, 7};
    solution.findSubsequences(nums);
  }

  public int reverse(int x) {
    char[] s = (Integer.toString(x)).toCharArray();
    reverseString(s);
    int first = 0;
    int last = s.length;
    int tag = 1;
    for (int i = 0; i < s.length; i++) {
      if (s[i] != '0') {
        first = i;
        break;
      }
    }
    if (s[s.length - 1] == '-') {
      last--;
      tag = -1;
    }
    try {
      return tag * Integer.parseInt(String.valueOf(Arrays.copyOfRange(s, first, last)));
    } catch(NumberFormatException e) {
      return 0;
    }
  }

  public void reverseString(char[] s) {
    int i = 0;
    int j = s.length - 1;
    while (i <= j) {
      char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
      i++;
      j--;
    }
  }

  // 2遍HashMap
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> hm = new HashMap<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      hm.put(chars[i],hm.getOrDefault(chars[i],0) + 1);
    }
    for (int i = 0; i < chars.length; i++) {
      if (hm.get(chars[i]) == 1) {
        return i;
      }
    }
    return -1;
  }

  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    if (n == 2) {
      return "11";
    }
    String s = countAndSay(n - 1);
    StringBuilder ans = new StringBuilder();
    int count = 0;
    int slow = 0;
    int fast = 0;
    while (fast < s.length()) {
      char c1 = s.charAt(slow);
      char c2 = s.charAt(fast);
      if (c1 == c2) {
        fast++;
        count++;
      }
      if (c1 != c2 || fast == s.length() ) {
        ans = ans.append( (char) (count + 48) );
        ans = ans.append(c1);
        slow = fast;
        count = 0;
      }
    }
    return ans.toString();
  }
  public boolean repeatedSubstringPattern(String s) {
    int len = s.length();
    boolean ans = false;
/*
    if (len % 2 == 0) { // 偶数

    } else { // 奇数
      ans = true;
      for (int i = 0; i < len; i++) {
        if (s.charAt(i) != s.charAt(0)) {
          ans = false;
        }
      }
    }
*/
    for (int tic = len / 2; tic >= 1; tic--) {
      if (len % tic != 0) {
        continue;
      }
      boolean b = true;
      for (int k = 0; k < len - tic; k += tic) {
        b &= stringCompare(s.substring(k, k + tic), s.substring(k + tic, k + 2 * tic));
      }
      if (b == true) {
        ans = true;
        break;
      }
    }
    return ans;
  }

  public boolean stringCompare(String s1,String s2) {
    if (s1.equals(s2)) {
      return true;
    }
    return false;
  }
  private List<List<Integer>> ans = new LinkedList<>();
  private List<List<Integer>> nums2 = new LinkedList<>();
  private int[] nums;
  public List<List<Integer>> findSubsequences(int[] nums) {
    this.nums = nums;
    // 1
    for (int i = 0; i < nums.length; i++) {
      nums2.add(new LinkedList<>());
    }
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] >= nums[j]) {
          nums2.get(i).add(j);
        }
      }
    }

    // 2
    for (int i = 0; i < nums.length; i++) {
      LinkedList<Integer> l = new LinkedList<>();
      l.add(nums[i]);
      dfs(l,i);
    }
    return ans;
  }
  public void dfs(List<Integer> oldList,int target) {
    int len = nums2.get(target).size();
    if (len == 0) {
      return;
    }
    Set<Integer> set = new HashSet();
    for (int k = 0; k < len; k++) {
      LinkedList<Integer> newList = new LinkedList<>(oldList);
      int index = nums2.get(target).get(k);
      if (set.contains(nums[index])) {
        continue;
      }
      set.add(nums[index]);
      newList.addFirst(nums[index]);
      ans.add(newList);
      dfs(newList,k);
    }
  }
}
