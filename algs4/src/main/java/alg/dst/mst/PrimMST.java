package alg.dst.mst;

import alg.dst.graph.wgraph.Edge;
import alg.dst.graph.wgraph.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * Author: lsf Time: 6/16/20-2:58 PM
 */
public class PrimMST implements MST {

  private Edge[] edgeTo;
  private double[] distTo;
  private boolean[] marked;
  private IndexMinPQ<Double> pq;

  public PrimMST(EdgeWeightedGraph G) {
    edgeTo = new Edge[G.V()];
    distTo = new double[G.V()];
    marked = new boolean[G.V()];
    pq = new IndexMinPQ<Double>(G.V());

    for (int v = 0; v < G.V(); v++) {
      distTo[v] = Double.POSITIVE_INFINITY;
    }
    for (int v = 0; v < G.V(); v++) {
      if (!marked[v]) {
        prim(G,v);
      }
    }
  }

  public void prim(EdgeWeightedGraph G, int s) {
    distTo[s] = 0.0;
    pq.insert(s, distTo[s]);
    while (!pq.isEmpty()) {
      int v = pq.delMin();
      scan(G, v);
    }
  }

  public void scan(EdgeWeightedGraph G, int v) {
    marked[v] = true;
    for (Edge e : G.adj(v)) {
      int w = e.other(v);
      if (marked[w]) {
        continue;
      }
      if (e.weight() < distTo[w]) {
        distTo[w] = e.weight();
        edgeTo[w] = e;
        if (pq.contains(w)) {
          pq.decreaseKey(w, distTo[w]);
        } else {
          pq.insert(w, distTo[w]);
        }
      }
    }
  }

  public Iterable<Edge> edges() {
    return null;
  }

  public double weight() {
    return 0;
  }
}
