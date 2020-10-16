package leetcode.daily.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 8/26/20-12:43 PM
 * Leetcode题目: 17. 电话号码的字母组合
 */
public class Solution6 {
  private Map<Integer, Character[]> map = new HashMap();
  private List<String> res = new ArrayList<>();

  public void initMap() {
    map.put(2,new Character[]{'a', 'b', 'c'});
    map.put(3,new Character[]{'d','e','f'});
    map.put(4,new Character[]{'g','h','i'});
    map.put(5,new Character[]{'j','k','l'});
    map.put(6,new Character[]{'m','n','o'});
    map.put(7,new Character[]{'p','q','r','s'});
    map.put(8,new Character[]{'t','u','v'});
    map.put(9,new Character[]{'w','x','y','z'});
  }

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList();
    }
    initMap();
    int[] arrays = new int[digits.length()];
    for (int i = 0; i < digits.length(); i++) {
      arrays[i] = digits.charAt(i) - '0';
    }
    DFS(arrays,0,new StringBuilder());
    return res;
  }

  public void DFS(int[] nums, int target,StringBuilder curSubString) {
    if (target == nums.length) {
      res.add(new String(curSubString));
      return;
    }
    Character[] it = map.get(nums[target]);
    for (Character c : it) {
      curSubString.append(c);
      DFS(nums,target + 1,curSubString);
      curSubString.deleteCharAt(curSubString.length() - 1);
    }
  }
}
