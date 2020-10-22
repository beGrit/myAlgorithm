package leetcode.daily.string;

import java.util.Stack;

/**
 * Author: lsf Time: 10/19/20-12:28 PM
 */
public class Solution61 {

  public static void main(String[] args) {
    Solution61 solution61 = new Solution61();
    String S = "ab##";
    String T = "c#d#";
    solution61.backspaceCompare(S, T);
  }

  public boolean function1(String S, String T) {
    Stack<Character> stack_1 = new Stack();
    Stack<Character> stack_2 = new Stack();
    for (char c : S.toCharArray()) {
      stack_1.push(c);
      if (c == '#') {
        stack_1.pop();
        if (!stack_1.isEmpty()) {
          stack_1.pop();
        }
      }
    }
    for (char c : T.toCharArray()) {
      stack_2.push(c);
      if (c == '#') {
        stack_2.pop();
        if (!stack_2.isEmpty()) {
          stack_2.pop();
        }
      }
    }
    while (!stack_1.isEmpty() && !stack_2.isEmpty()) {
      char c1 = stack_1.pop();
      char c2 = stack_2.pop();
      if (c1 != c2) {
        return false;
      }
    }
    return stack_1.isEmpty() && stack_2.isEmpty();
  }

  public boolean function2(String S, String T) {
    int index1 = S.length() - 1;
    int index2 = T.length() - 1;
    int count = 0;
    while (true) {
      do {
        if (index1 == -1) {
          break;
        }
        char c = S.charAt(index1);
        if (c == '#') {
          count++;
          index1--;
        } else if (count != 0) {
          count--;
          index1--;
        } else {
          break;
        }
      } while (true);
      do {
        if (index2 == -1) {
          break;
        }
        char c = T.charAt(index2);
        if (c == '#') {
          count++;
          index2--;
        } else if (count != 0) {
          count--;
          index2--;
        } else {
          break;
        }
      } while (true);
      if (index1 == -1 && index2 == -1) {
        return true;
      } else if (index1 == -1 || index2 == -1) {
        return false;
      }
      if (S.charAt(index1) == T.charAt(index2)) {
        index1--;
        index2--;
      } else {
        return false;
      }
    }
  }

  public boolean backspaceCompare(String S, String T) {
    return function2(S, T);
  }
}
