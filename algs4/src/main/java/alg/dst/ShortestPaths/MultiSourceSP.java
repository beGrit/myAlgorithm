package alg.dst.ShortestPaths;

import alg.dst.graph.wdgraph.DirectedEdge;

/**
 * Author: lsf Time: 6/10/20-12:29 PM
 */
public interface MultiSourceSP {
  double dist(int s,int t);
  boolean hasPath(int s,int t);
  Iterable<DirectedEdge> path(int s,int t);
  void validateVertex(int v);
}
