package leetcode.daily.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: lsf Time: 11/6/20-10:13 PM
 */
public class Solution1 {

  // 127.单词接龙

  // Word(单词)映射成Integer(ID)
  public Map<String, Integer> map = new HashMap<>();
  // 邻接表
  private List<List<Integer>> adjacency = new ArrayList<>();
  // 当前节点数
  private int curNodeNum;

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    String beginWord = "hit";
    String endWord = "cog";
    String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    int res = solution1.ladderLength(beginWord, endWord, Arrays.asList(words));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // 搭建无向图
    for (String word : wordList) {
      addEdge(word);
    }
    addEdge(beginWord);
    if (!map.containsKey(endWord)) {
      return 0;
    }

    // BFS 找出最短路径
    int[] dist = new int[curNodeNum];
    Arrays.fill(dist, Integer.MAX_VALUE);
    int beginId = map.get(beginWord);
    int endId = map.get(endWord);
    dist[beginId] = 0;
    Deque<Integer> dq = new LinkedList<>();
    dq.offer(beginId);
    while (!dq.isEmpty()) {
      Integer id = dq.poll();
      if (id == endId) {
        return dist[id] / 2  + 1;
      }
      for (int id2 : adjacency.get(id)) {
        if (dist[id2] == Integer.MAX_VALUE) {
          dist[id2] = dist[id] + 1;
          dq.offer(id2);
        }
      }
    }
    return 0;
  }

  private void addEdge(String word) {
    addWord(word);
    Integer id1 = map.get(word);
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char tmp = chars[i];
      chars[i] = '*';
      String newWord = new String(chars);
      addWord(newWord);
      int id2 = map.get(newWord);
      adjacency.get(id1).add(id2);
      adjacency.get(id2).add(id1);
      chars[i] = tmp;
    }
  }

  public void addWord(String word) {
    if (!map.containsKey(word)) {
      map.put(word, curNodeNum++);
      adjacency.add(new LinkedList<>());
    }
  }
}
