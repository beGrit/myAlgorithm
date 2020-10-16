package leetcode.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Author: lsf Time: 8/27/20-8:46 PM
 */
public class Solution9 {
  private Map<String, PriorityQueue<String>> map = new HashMap<>();
  private Stack<String> stack = new Stack<>();
  public List<String> findItinerary(List<List<String>> tickets) {
    // 1. 构造图
    for (List<String> ticket : tickets) {
      String src = ticket.get(0);
      String des = ticket.get(1);
      if (!map.containsKey(src)) {
        map.put(src,new PriorityQueue<>());
      }
      map.get(src).offer(des);
    }

    // 2. 利用Hierholzer算法求解欧拉队列
    DFS("JFK");
    Collections.reverse(stack);
    return stack;
  }

  public void DFS(String curCity) {
    while (map.containsKey(curCity) && map.get(curCity).size() > 0) {
      String newDes = map.get(curCity).poll();
      DFS(newDes);
    }
    stack.push(curCity);
  }

  public static void main(String[] args) {
    Solution9 solution9 = new Solution9();
    List<List<String>> tickets = new ArrayList<>();

    solution9.findItinerary(tickets);
  }
}
