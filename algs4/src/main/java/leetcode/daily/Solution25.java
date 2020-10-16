package leetcode.daily;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: lsf Time: 9/14/20-8:53 AM
 */
public class Solution25 {

  Queue<Integer> queue = new LinkedList<>();

  public List<Integer> inorderTraversal(TreeNode root) {
    helper1(root);
    return (List<Integer>) queue;
  }

  /**
   * 方法一:递归
   *
   * @param root
   */
  public void helper1(TreeNode root) {
    if (root == null) {
      return;
    } else {
      helper1(root.left);
      queue.offer(root.val);
      helper1(root.right);
    }
  }

  /**
   * 方法二:非递归遍历,维护一个栈用来记录节点访问次数
   * @param root
   */
  public void helper2(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode tn = root;
    while (tn != null || !stack.isEmpty()) {
      // step1.左子树入栈
      while (tn != null) {
        stack.push(tn);
        tn = tn.left;
      }
      if (!stack.isEmpty()) {
        // step2.节点出栈并收录节点(第二次遇到)
        tn = stack.pop();
        queue.offer(tn.val);

        // step3.右子树入栈
        tn = tn.right;
      }
    }
  }
}
