package alg.dst.ShortestPaths;

import alg.dst.graph.wdgraph.DirectedEdge;
import alg.dst.graph.wdgraph.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Author: lsf Time: 6/9/20-2:06 PM
 */
public class DijkstraSP implements SingeSourceSP{ // Dijkstra 算法 计算最短路径 的实现

  private double[] distTo;     // the length of the shortest path from s to v
  private DirectedEdge[] edgeTo;     // the the last edge on a shortest path from s to v
  private IndexMinPQ<Double> pq;    // priority queue of vertices 优先队列,用于记录

  public DijkstraSP(EdgeWeightedDigraph G, int s) {   // s为指定的Source
    /**
     * 初始化操作
     * 1) 判断每一条边的权值(Weight)是否有负值(Negative) ,保证非负性
     * 2) 将未遍历过的边初始化为 正无穷(Double.POSITIVE_INFINITY)
     */
    for (DirectedEdge e : G.edges()) {
      if (e.weight() < 0) {
        throw new IllegalArgumentException("edge " + e + " has negative weight");
      }
    }
    distTo = new double[G.V()];
    edgeTo = new DirectedEdge[G.V()];
    validateVertex(s);
    for (int v = 0; v < G.V(); v++) {
      distTo[v] = Double.POSITIVE_INFINITY;
    }
    distTo[s] = 0.0;
    pq = new IndexMinPQ<Double>(G.V());

    pq.insert(s, distTo[s]);
    while (!pq.isEmpty()) {
      int v = pq.delMin();
      for (DirectedEdge e : G.adj(v)) { // 遍历 结点的边
        relax(e);
      }
    }
//    assert check(G, s);
  }

  // relax edge e and update pq if changed
  private void relax(DirectedEdge e) {
    int v = e.from(), w = e.to();
    if (distTo[w] > distTo[v] + e.weight()) {
      distTo[w] = distTo[v] + e.weight();
      edgeTo[w] = e;
      if (pq.contains(w)) {
        pq.decreaseKey(w, distTo[w]);
      } else {
        pq.insert(w, distTo[w]);
      }
    }
  }

  private void validateVertex(int v) {
    int V = distTo.length;
    if (v < 0 || v >= V) {
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
  }

  public double distTo(int v) {
    validateVertex(v);
    return distTo[v];
  }

  public boolean hasPathTo(int v) {
    validateVertex(v);
    return distTo[v] < Double.POSITIVE_INFINITY;
  }

  public Iterable<DirectedEdge> pathTo(int v) {
    validateVertex(v);
    Stack<DirectedEdge> path = new Stack<DirectedEdge>();
    for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
      path.push(e);
    }
    return path;
  }

  private boolean check(EdgeWeightedDigraph G, int s) {

    // check that edge weights are nonnegative
    for (DirectedEdge e : G.edges()) {
      if (e.weight() < 0) {
        System.err.println("negative edge weight detected");
        return false;
      }
    }

    // check that distTo[v] and edgeTo[v] are consistent
    if (distTo[s] != 0.0 || edgeTo[s] != null) {
      System.err.println("distTo[s] and edgeTo[s] inconsistent");
      return false;
    }
    for (int v = 0; v < G.V(); v++) {
      if (v == s) continue;
      if (edgeTo[v] == null && distTo[v] != Double.POSITIVE_INFINITY) {
        System.err.println("distTo[] and edgeTo[] inconsistent");
        return false;
      }
    }

    // check that all edges e = v->w satisfy distTo[w] <= distTo[v] + e.weight()
    for (int v = 0; v < G.V(); v++) {
      for (DirectedEdge e : G.adj(v)) {
        int w = e.to();
        if (distTo[v] + e.weight() < distTo[w]) {
          System.err.println("edge " + e + " not relaxed");
          return false;
        }
      }
    }

    // check that all edges e = v->w on SPT satisfy distTo[w] == distTo[v] + e.weight()
    for (int w = 0; w < G.V(); w++) {
      if (edgeTo[w] == null) continue;
      DirectedEdge e = edgeTo[w];
      int v = e.from();
      if (w != e.to()) return false;
      if (distTo[v] + e.weight() != distTo[w]) {
        System.err.println("edge " + e + " on shortest path not tight");
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    args[0] = "tinyEWD.txt";
    In in = new In(args[0]);
    EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
    int s = Integer.parseInt(args[1]);

    // compute shortest paths
    DijkstraSP sp = new DijkstraSP(G, s);
    // print shortest path
    for (int t = 0; t < G.V(); t++) {
      if (sp.hasPathTo(t)) {
        StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
        for (DirectedEdge e : sp.pathTo(t)) {
          StdOut.print(e + "   ");
        }
        StdOut.println();
      }
      else {
        StdOut.printf("%d to %d         no path\n", s, t);
      }
    }
  }
}
