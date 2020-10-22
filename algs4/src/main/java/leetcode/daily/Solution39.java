package leetcode.daily;

import leetcode.daily.dataobject.TreeNode;

/**
 * Author: lsf Time: 9/27/20-8:52 AM
 */
public class Solution39 {

  /**
   * Question: Lowest Common Ancestor(LCA) of a Binary Search Tree(BST)
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return function1(root, p, q);
  }

  public TreeNode function1(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode tn = root;
    while (true) {
      int tnVal = tn.val;
      int pVal = p.val;
      int qVal = q.val;
      if (pVal < qVal) {
        if (tnVal >= pVal && tnVal <= qVal) {
          return tn;
        } else if (tnVal > pVal) {
          tn = tn.left;
        } else {
          tn = tn.right;
        }
      } else {
        if (tnVal >= qVal && tnVal <= pVal) {
          return tn;
        } else if (tnVal > qVal) {
          tn = tn.left;
        } else {
          tn = tn.right;
        }
      }
    }
  }
}
