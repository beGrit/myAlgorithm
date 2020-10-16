package alg.dst.mst;

import alg.dst.graph.wgraph.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import junit.framework.TestCase;

/**
 * Author: lsf Time: 6/16/20-6:17 PM
 */
public class KruskalMSTTest extends TestCase {
  private KruskalMST kruskalMST;
  public void test() {
    In in = new In("tinyEWD.txt");
    EdgeWeightedGraph G = new EdgeWeightedGraph(in);
    kruskalMST = new KruskalMST(G);
    System.out.println();
  }
}