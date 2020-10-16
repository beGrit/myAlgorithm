package leetcode.daily;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: lsf Time: 9/26/20-9:16 AM
 */
public class TreeUtil {

  public static TreeNode init(Integer[] integers) {
    List<Integer> list = Arrays.stream(integers).collect(Collectors.toList());
    return init(list);
  }

  public static TreeNode init(List<Integer> list) {
    if (list.size() == 0) {
      return null;
    }
    Deque<TreeNode> dq = new LinkedList<>();
    TreeNode root = new TreeNode(list.remove(0));
    dq.offer(root);
    while (!list.isEmpty()) {
      TreeNode tn = dq.poll();
      Integer leftVal = list.remove(0);
      if (leftVal != null) {
        TreeNode left = new TreeNode(leftVal);
        tn.left = left;
        dq.offer(left);
      } else {
        tn.left = null;
      }
      Integer rightVal = list.remove(0);
      if (rightVal != null) {
        TreeNode right = new TreeNode(rightVal);
        tn.right = right;
        dq.offer(right);
      } else {
        tn.right = null;
      }
    }
    return root;
  }
}
