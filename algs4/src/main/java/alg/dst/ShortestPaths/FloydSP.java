package alg.dst.ShortestPaths;

import alg.dst.graph.wdgraph.DirectedEdge;
import alg.dst.graph.wdgraph.EdgeWeightedDigraph;

/**
 * Author: lsf Time: 6/10/20-12:24 PM
 */
public class FloydSP implements MultiSourceSP {

  private boolean hasNegativeCycle;
  private double[][] distTo;         // distTo[v][w] = length of shortest v->w path
  private DirectedEdge[][] edgeTo;   // edgeTo[v][w] = last edge on shortest v->w path

  public FloydSP(EdgeWeightedDigraph G) {
    int V = G.V();
    distTo = new double[V][V];
    edgeTo = new DirectedEdge[V][V];

    /**
     * 1) 若 结点与结点之间有边(直接连接)则修改distTo为该边权值 , 非则初始化为 无穷大
     */
    for (int v = 0; v < V; v++) {
      for (int w = 0; w < V; w++) {
        distTo[v][w] = Double.POSITIVE_INFINITY;
      }
    }
    for (int v = 0; v < V; v++) {
      for (DirectedEdge e : G.adj(v)) {
        distTo[e.from()][e.to()] = e.weight();
        edgeTo[e.from()][e.to()] = e;
        // in case of self-loops
        if (distTo[v][v] >= 0.0) {
          distTo[v][v] = 0.0;
          edgeTo[v][v] = null;
        }
      }
    }

    /**
     * 考虑经过中间结点后的路径更短
     */
    for (int i = 0; i < V; i++) { // 所有结点都充当一次中间结点
      /**
       *
       */
      for (int v = 0; v < V; v++) {
        for (int w = 0; w < V; w++) {
          if (distTo[v][w] > distTo[v][i] + distTo[i][w]) {
            distTo[v][w] = distTo[v][i] + distTo[i][w];
            edgeTo[v][w] = edgeTo[i][w];
            // check for negative cycle
            if (distTo[v][v] < 0.0) {
              hasNegativeCycle = true;
              return;
            }
          }
        }
      }
    }

  }


  public double dist(int s,int v) {
    validateVertex(s);
    validateVertex(v);
    return distTo[s][v];
  }

  public boolean hasPath(int s, int t) {
    validateVertex(s);
    validateVertex(t);
    return distTo[s][t] < Double.POSITIVE_INFINITY;
  }

  public Iterable<DirectedEdge> path(int s, int t) {
    return null;
  }

  public void validateVertex(int v) {
    int V = distTo.length;
    if (v < 0 || v >= V) {
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
  }
}
