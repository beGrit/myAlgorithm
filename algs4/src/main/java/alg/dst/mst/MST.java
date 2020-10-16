package alg.dst.mst;

import alg.dst.graph.wgraph.Edge;

/**
 * Author: lsf Time: 6/16/20-11:25 AM
 */
public interface MST {
  public Iterable<Edge> edges();
  public double weight();
}
