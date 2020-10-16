package alg.trees.uf;

/**
 * Author: lsf Time: 6/16/20-3:56 PM
 */
public class UF {

  private int[] parent;
  private byte[] rank;
  private int count;    // 当前集合的数量

  public UF(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("[UF init] 非法参数,n = " + n);
    }
    parent = new int[n];
    count = n;

    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 0;
    }
  }

  /**
   * @param p 指定结点下标
   * @return rootP(p所在集合的根结点的下标)
   * */
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
   * */
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP != rootQ) {
      if (this.rank[rootP] < this.rank[rootQ]) {
        this.parent[rootP] = rootQ;
      } else if (this.rank[rootP] > this.rank[rootQ]) {
        this.parent[rootQ] = rootP;
      } else {
        this.parent[rootQ] = rootP;
        ++this.rank[rootP];
      }
      --this.count;
    }
  }

  /**
   * 判断俩个结点是否属于同一个集合
   * */
  public boolean connected(int p, int q) {
    validate(p);
    validate(q);
    return find(p) == find(q);
  }

  public int count() {
    return count;
  }

  public void validate(int p) {
    int n = parent.length;
    if (p >= n || p < 0) {
      throw new IllegalArgumentException("index p = " + p + " is not between 0 and " + (n - 1));
    }
  }
}
