package leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 9/4/20-9:07 AM
 */
public class Solution16 {

  private List<String> res = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    DFS(root,"");
    return res;
  }

  public void DFS(TreeNode root, String s) {
    s += "->" + Integer.toString(root.val);
    if (root.left == null && root.right == null) {
      String substring = s.substring(2, s.length());
      res.add(substring);
      return;
    } else {
      if (root.left != null) {
        DFS(root.left, s);
      }
      if (root.right != null) {
        DFS(root.right, s);
      }
    }
    s = s.substring(s.length() - 3);
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public static void main(String[] args) {

  }
}
