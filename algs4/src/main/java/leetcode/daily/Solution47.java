package leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lsf Time: 10/6/20-10:25 AM
 */
class Solution47 {

  // 邻接表
  private List<List<Integer>> graph = new ArrayList<>();
  private int[] nodes;
  private int[] distSum;
  private int N;

  public int[] sumOfDistancesInTree(int N, int[][] edges) {
    // 初始化
    this.nodes = new int[N];
    this.distSum = new int[N];
    this.N = N;
    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }
    int len = edges.length;
    for (int i = 0; i < len; i++) {
      int src = edges[i][0];
      int des = edges[i][1];
      graph.get(src).add(des);
      graph.get(des).add(src);
    }
    postOrder(0, -1);
    preOrder(0, -1);
    return distSum;
  }


  // 计算子树的distSum
  public void postOrder(int root, int parent) {
    List<Integer> list = graph.get(root);
    nodes[root] += 1;
    if (list.size() == 0) { // 叶子节点
      distSum[root] = 0;
      return;
    }
    for (Integer nextRoot : list) {
      if (parent == nextRoot) {
        continue;
      }
      postOrder(nextRoot, root);
      distSum[root] += distSum[nextRoot] + nodes[nextRoot];
      nodes[root] += nodes[nextRoot];
    }
  }

  // 计算root的distSum
  public void preOrder(int root, int parent) {
    List<Integer> list = graph.get(root);
    for (Integer nextRoot : list) {
      if (parent == nextRoot) {
        continue;
      }
      distSum[nextRoot] = distSum[root] - nodes[nextRoot] + (N - nodes[nextRoot]);
      preOrder(nextRoot, root);
    }
  }
}
