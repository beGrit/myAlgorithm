package leetcode.daily.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Author: lsf Time: 11/5/20-10:39 PM
 */
class Solution2 {

  Map<String, Integer> wordId = new HashMap<String, Integer>();
  List<List<Integer>> edge = new ArrayList<List<Integer>>();
  int nodeNum = 0;

  public static void main(String[] args) {
    Solution2 solution2 = new Solution2();
    String beginWord = "hit";
    String endWord = "cog";
    String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    int res = solution2.ladderLength(beginWord, endWord, Arrays.asList(words));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    for (String word : wordList) {
      addEdge(word);
    }
    addEdge(beginWord);
    if (!wordId.containsKey(endWord)) {
      return 0;
    }
    int[] dis = new int[nodeNum];
    Arrays.fill(dis, Integer.MAX_VALUE);
    int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
    dis[beginId] = 0;

    Queue<Integer> que = new LinkedList<Integer>();
    que.offer(beginId);
    while (!que.isEmpty()) {
      int x = que.poll();
      if (x == endId) {
        return dis[endId] / 2 + 1;
      }
      for (int it : edge.get(x)) {
        if (dis[it] == Integer.MAX_VALUE) { // 未被遍历
          dis[it] = dis[x] + 1;
          que.offer(it);
        }
      }
    }
    return 0;
  }

  public void addEdge(String word) {
    addWord(word);
    int id1 = wordId.get(word);
    char[] array = word.toCharArray();
    int length = array.length;
    for (int i = 0; i < length; ++i) {
      char tmp = array[i];
      array[i] = '*';
      String newWord = new String(array);
      addWord(newWord);
      int id2 = wordId.get(newWord);
      edge.get(id1).add(id2);
      edge.get(id2).add(id1);
      array[i] = tmp;
    }
  }

  public void addWord(String word) {
    if (!wordId.containsKey(word)) {
      wordId.put(word, nodeNum++);
      edge.add(new ArrayList<Integer>());
    }
  }
}