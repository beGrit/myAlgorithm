package alg.dst.mst;

import alg.dst.graph.wgraph.Edge;
import alg.dst.graph.wgraph.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * Author: lsf Time: 6/16/20-2:50 PM
 */
public class KruskalMST implements MST{
  private static final double FLOATING_POINT_EPSILON = 1E-12;
  private MinPQ<Edge> pq;
  private Queue<Edge> mst;
  private UF uf;
  private double weight;

  public KruskalMST(EdgeWeightedGraph G) {
    mst = new Queue<Edge>();
    pq = new MinPQ<Edge>();
    uf = new UF(G.V());
    weight = 0;
    for (Edge e : G.edges()) {
      pq.insert(e);
    }
    while (!pq.isEmpty() && mst.size() < G.V() - 1) {
      Edge e = pq.delMin();
      int v = e.either();
      int w = e.other(v);
      if (!uf.connected(v,w)) {
        uf.union(v,w);
        mst.enqueue(e);
        weight += e.weight();
      }
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  public double weight() {
    return weight;
  }

  public boolean check(EdgeWeightedGraph G) {
    // check total weight
    double total = 0.0;
    for (Edge e : edges()) {
      total += e.weight();
    }
    if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
      System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
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
