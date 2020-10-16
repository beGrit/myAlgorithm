package alg.dst.ShortestPaths;

import alg.dst.graph.wdgraph.DirectedEdge;

/**
 * Author: lsf Time: 6/10/20-12:27 PM
 */
public interface SingeSourceSP {
  double distTo(int v);
  boolean hasPathTo(int v);
  Iterable<DirectedEdge> pathTo(int v);
}
