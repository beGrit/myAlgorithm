package leetcode.primary.tree;

/**
 * Author: lsf Time: 9/12/20-7:43 PM
 */
public class Solution4 {
  private TreeNode root;
  public TreeNode sortedArrayToBST(int[] nums) {
    return null;
  }
  public boolean insert(int key) {
    if (root == null) {
      root = new TreeNode(key);
    } else {
      TreeNode n = root;
      TreeNode parent;
      while (true) {
        if (n.val == key) { // 数值重复,返回false
          return false;
        }
        parent = n;
        boolean goLeft = n.val > key;
        n = goLeft ? n.left : n.right;
        if (n == null) {
          if (goLeft) {
            parent.left = new TreeNode(key);
          } else {
            parent.right = new TreeNode(key);
          }
//          reBalance(parent);
          break;
        }
      }    }
    return true;
  }

}
