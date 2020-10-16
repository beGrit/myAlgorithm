package leetcode.daily;

/**
 * Author: lsf Time: 9/18/20-11:40 PM
 */
class Solution30 {

  public int[] findRedundantDirectedConnection(int[][] edges) {
    int nodesCount = edges.length;
    UnionFind uf = new UnionFind(nodesCount + 1);
    int[] parent = new int[nodesCount + 1];
    for (int i = 1; i <= nodesCount; ++i) {
      parent[i] = i;
    }
    // 标识最后一条产生 入度为2的节点 的边
    int conflict = -1;
    // 标识最后一条产生 回路 的边
    int cycle = -1;

    // 遍历每一条边
    for (int i = 0; i < nodesCount; ++i) {
      int[] edge = edges[i];
      // node1 为起点 , node2 为终点
      int node1 = edge[0], node2 = edge[1];

      if (parent[node2] != node2) { // 检查 node2(终点) 是不是已经有过parent
        // 记录该冲突边(node2入度为2)
        conflict = i;
      } else {
        parent[node2] = node1;
        if (uf.find(node1) == uf.find(node2)) {
          cycle = i;
        } else {
          uf.union(node1, node2);
        }
      }
    }
    if (conflict < 0) {
      int[] redundant = {edges[cycle][0], edges[cycle][1]};
      return redundant;
    } else {
      int[] conflictEdge = edges[conflict];
      if (cycle >= 0) {
        int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
        return redundant;
      } else {
        int[] redundant = {conflictEdge[0], conflictEdge[1]};
        return redundant;
      }
    }
  }
}

class UnionFind {

  int[] ancestor;

  public UnionFind(int n) {
    ancestor = new int[n];
    for (int i = 0; i < n; ++i) {
      ancestor[i] = i;
    }
  }

  public void union(int index1, int index2) {
    ancestor[find(index1)] = find(index2);
  }

  public int find(int index) {
    if (ancestor[index] != index) {
      ancestor[index] = find(ancestor[index]);
    }
    return ancestor[index];
  }
}