package leetcode.daily;

/**
 * Author: lsf Time: 9/17/20-11:19 AM
 */
public class Solution28 {

  /**
   * 题目: 寻找多余的有向边
   *
   * @param edges
   * @return
   */
  public int[] findRedundantDirectedConnection(int[][] edges) {
    return null;
  }

  /**
   * UF(Union Find 并查集)方法
   *
   * @param edges
   */
  public int[] helper(int[][] edges) {
    int len = edges.length;
    int[] res = new int[2];
    UF uf = new UF(len);
    /**
     * 维护一个数组,记录每个节点的父节点
     */
    int[] parent = new int[len];
    for (int i = 0; i < len; i++) {
      parent[i+1] = i + 1;
    }

    /**
     * 维护俩个变量
     * e1 : 用于记录导致出现入度为2的节点的边
     * e2 : 用于记录导致出现环的边
     */
    int e1 = -1;
    int e2 = -1;

    for (int i = 0; i < len; i++) {
      int node1 = edges[i][0];
      int node2 = edges[i][1];
      if (parent[node2] != node2) {
        e1 = i;
      } else {
        parent[node2] = node1;
        if (uf.find(node1) == uf.find(node2)) {
          e2 = i;
        } else {
          uf.union(node1, node2);
        }
      }
    }

    if (e1 < 0) {
      res[0] = edges[e2][0];
      res[1] = edges[e2][1];
    } else {
      if (e2 > 0) {
        res[0] = edges[e2][0];
        res[1] = edges[e2][1];
      } else {
        res[0] = edges[e1][0];
        res[1] = edges[e1][1];
      }
    }
    return res;
  }
}

class UF {

  private int[] parent;

  public UF(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("[UF init] 非法参数,n = " + n);
    }
    parent = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  /**
   * @param p 指定结点下标
   * @return rootP(p所在集合的根结点的下标)
   */
  public int find(int p) {
    validate(p);

    while (p != parent[p]) {
      parent[p] = parent[parent[p]];
      p = parent[p];
    }

    return p;
  }

  /**
   * union俩个集合(A:p 所在的集合)(B:q 所在的集合)
   */
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    parent[rootP] = rootQ;
  }

  /**
   * 判断俩个结点是否属于同一个集合
   */
  public boolean connected(int p, int q) {
    validate(p);
    validate(q);
    return find(p) == find(q);
  }

  public void validate(int p) {
    int n = parent.length;
    if (p >= n || p < 0) {
      throw new IllegalArgumentException("index p = " + p + " is not between 0 and " + (n - 1));
    }
  }
}

