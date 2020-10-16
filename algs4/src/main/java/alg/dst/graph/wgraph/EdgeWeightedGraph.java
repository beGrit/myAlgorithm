package alg.dst.graph.wgraph;

import alg.dst.ShortestPaths.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;

/**
 * Author: lsf Time: 6/16/20-11:30 AM
 */
public class EdgeWeightedGraph {
  private final int V;                // number of vertices in this digraph
  private int E;                      // number of edges in this digraph
  private Bag<Edge>[] adj;    // adj[v] = adjacency list for vertex v

  public EdgeWeightedGraph(int v) {
    if (v < 0) {
      throw new IllegalArgumentException("[EdgeWeightedGraph] 初始化顶点个数失败,非法参数 v = " + v);
    }
    this.V = v;
    this.E = 0;
    adj = (Bag<Edge>[])new Bag[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new Bag<Edge>();
    }
  }

  public EdgeWeightedGraph(int V, int E) {
    this(V);
    if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
    for (int i = 0; i < E; i++) {
      int v = StdRandom.uniform(V);
      int w = StdRandom.uniform(V);
      double weight = Math.round(100 * StdRandom.uniform()) / 100.0;
      Edge e = new Edge(v, w, weight);
      addEdge(e);
    }
  }

  public EdgeWeightedGraph(In in) {
    if (in == null) throw new IllegalArgumentException("argument is null");

    try {
      V = in.readInt();
      adj = (Bag<Edge>[]) new Bag[V];
      for (int v = 0; v < V; v++) {
        adj[v] = new Bag<Edge>();
      }

      int E = in.readInt();
      if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
      for (int i = 0; i < E; i++) {
        int v = in.readInt();
        int w = in.readInt();
        validateVertex(v);
        validateVertex(w);
        double weight = in.readDouble();
        Edge e = new Edge(v, w, weight);
        addEdge(e);
      }
    }
    catch (NoSuchElementException e) {
      throw new IllegalArgumentException("invalid input format in EdgeWeightedGraph constructor", e);
    }

  }

  public EdgeWeightedGraph(EdgeWeightedGraph G) {
    this(G.V());
    this.E = G.E();
    for (int v = 0; v < G.V(); v++) {
      // reverse so that adjacency list is in same order as original
      Stack<Edge> reverse = new Stack<Edge>();
      for (Edge e : G.adj[v]) {
        reverse.push(e);
      }
      for (Edge e : reverse) {
        adj[v].add(e);
      }
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public int degree(int v) {
    validateVertex(v);
    return adj[v].size();
  }

  public Iterable<Edge> adj(int v) {
    validateVertex(v);
    return adj[v];
  }

  public Iterable<Edge> edges() {
    Bag<Edge> list = new Bag<Edge>();
    for (int v = 0; v < V; v++) {
      int selfLoops = 0;
      for (Edge e : adj(v)) {
        if (e.other(v) > v) {
          list.add(e);
        }
        // add only one copy of each self loop (self loops will be consecutive)
        else if (e.other(v) == v) {
          if (selfLoops % 2 == 0) list.add(e);
          selfLoops++;
        }
      }
    }
    return list;
  }

  public void addEdge(Edge e) {
    int v = e.either();
    int w = e.other(v);
    validateVertex(v);
    validateVertex(w);
    adj[v].add(e);
    adj[w].add(e);
    E++;
  }

  private void validateVertex(int v) {
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
  }

}
