package leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 9/6/20-8:49 AM
 */
public class Solution18 {

  private List<List<Integer>> res = new ArrayList<>();
  private Map<Integer, List<Integer>> map = new HashMap<>();
  private int maxTier;
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    helper(root,0);
    int i = 0;
    while (maxTier > 0) {
      res.add(map.get(maxTier - 1));
      maxTier--;
    }
    return res;
  }

  public void helper(TreeNode root, Integer tier) {
    if (root == null) {
      maxTier = Math.max(tier, maxTier);
      return;
    }
    if (map.containsKey(tier)) {
      map.get(tier).add(root.val);
    } else {
      ArrayList<Integer> arrayList = new ArrayList<>();
      arrayList.add(root.val);
      map.put(tier, arrayList);
    }
    helper(root.left, tier + 1);
    helper(root.right, tier + 1);
  }
}
