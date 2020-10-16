package alg.dst.mst;

import alg.dst.graph.wgraph.Edge;
import alg.dst.graph.wgraph.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * Author: lsf Time: 6/16/20-1:14 PM
 *
 * <p>Prime算法获取到无向有权图的最小生成树</p>
 */
public class LazyPrimMST implements MST {

  private static final double FLOATING_POINT_EPSILON = 1E-12;

  private double weight;       // total weight of MST
  private Queue<Edge> mst;     // edges in the MST
  private boolean[] marked;    // marked[v] = true iff v on tree
  private MinPQ<Edge> pq;      // edges with one endpoint in tree

  public LazyPrimMST(EdgeWeightedGraph G) {
    mst = new Queue<Edge>();
    pq = new MinPQ<Edge>();
    marked = new boolean[G.V()];
    for (int v = 0; v < G.V(); v++)     // run Prim from all vertices to
    {
      if (!marked[v]) {
        prim(G, v);     // get a minimum spanning forest
      }
    }

    assert check(G);
  }

  /**
   * prim算法实现
   *
   * @param G 无向有权图;
   * @param s 给定的初始结点(起点)
   * */
  private void prim(EdgeWeightedGraph G, int s) {
    scan(G, s);
    while (!pq.isEmpty()) {
      Edge e = pq.delMin();
      int v = e.either();
      int w = e.other(v);
      if (marked[v] && marked[w]) {
        continue;
      } else {
        mst.enqueue(e);
        weight += e.weight();
        if (!marked[v]) {
          scan(G,v);
        }
        if (!marked[w]) {
          scan(G,w);
        }
      }
    }
  }
  /**
   * 给指定结点v服务
   * 1) 标记v结点为已访问过 (marked[v] = true)
   * 2) 收录v结点的边 (pq.insert(e))
   * */
  private void scan(EdgeWeightedGraph G, int v) {
    assert !marked[v];
    marked[v] = true;
    for (Edge e : G.adj(v)) {
      if (!marked[e.other(v)]) { // 保证收录的边不会构成回路
        pq.insert(e);
      }
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  public double weight() {
    return weight;
  }

  private boolean check(EdgeWeightedGraph G) {

    // check weight
    double totalWeight = 0.0;
    for (Edge e : edges()) {
      totalWeight += e.weight();
    }
    if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON) {
      System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
      return false;
    }

    // check that it is acyclic
    UF uf = new UF(G.V());
    for (Edge e : edges()) {
      int v = e.either(), w = e.other(v);
      if (uf.find(v) == uf.find(w)) {
        System.err.println("Not a forest");
        return false;
      }
      uf.union(v, w);
    }

    // check that it is a spanning forest
    for (Edge e : G.edges()) {
      int v = e.either(), w = e.other(v);
      if (uf.find(v) != uf.find(w)) {
        System.err.println("Not a spanning forest");
        return false;
      }
    }

    // check that it is a minimal spanning forest (cut optimality conditions)
    for (Edge e : edges()) {

      // all edges in MST except e
      uf = new UF(G.V());
      for (Edge f : mst) {
        int x = f.either(), y = f.other(x);
        if (f != e) uf.union(x, y);
      }

      // check that e is min weight edge in crossing cut
      for (Edge f : G.edges()) {
        int x = f.either(), y = f.other(x);
        if (uf.find(x) != uf.find(y)) {
          if (f.weight() < e.weight()) {
            System.err.println("Edge " + f + " violates cut optimality conditions");
            return false;
          }
        }
      }

    }

    return true;
  }
}
