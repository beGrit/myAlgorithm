package leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 10/3/20-10:20 PM 题目:LC 括号生成
 */
public class Solution1 {

  private List<String> res = new ArrayList<>();
  private int n;

  public List<String> generateParenthesis(int n) {
    this.n = n;
    helper(0, 0, true, new ArrayList<>());
    return res;
  }

  public void helper(int leftCount, int rightCount, boolean flag, List<Character> path) {
    if (leftCount > n) {
      return;
    }
    if (!flag && rightCount > leftCount) {
      return;
    }
    if (path.size() == 2 * n) {
      StringBuilder stringBuilder = new StringBuilder();
      for (Character c : path) {
        stringBuilder.append(c);
      }
      res.add(String.valueOf(stringBuilder));
      return;
    }
    path.add('(');
    helper(leftCount + 1, rightCount, true, path);
    path.remove(path.size() - 1);
    path.add(')');
    helper(leftCount, rightCount + 1, false, path);
    path.remove(path.size() - 1);
  }
}
