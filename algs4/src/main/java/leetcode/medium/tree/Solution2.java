package leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: lsf Time: 9/28/20-8:21 PM
 */
public class Solution2 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    Stack<TreeNode> preStack = new Stack<>();
    preStack.push(root);
    boolean tag = false;
    while (!preStack.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      while (!preStack.isEmpty()) {
        TreeNode tn = preStack.pop();
        if (tn == null) {
          continue;
        }
        list.add(tn.val);
        if (tag) {
          stack.push(tn.right);
          stack.push(tn.left);
        } else {
          stack.push(tn.left);
          stack.push(tn.right);
        }
      }
      if (!list.isEmpty()) {
        ans.add(list);
      }
      preStack = stack;
      tag = !tag;
    }
    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtil.init(new Integer[]{3, 9, 20, null, null, 15, 7});
    Solution2 solution2 = new Solution2();
    solution2.zigzagLevelOrder(root);
  }
}
