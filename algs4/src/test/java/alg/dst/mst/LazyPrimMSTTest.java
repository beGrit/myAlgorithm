package alg.dst.mst;

import alg.dst.graph.wgraph.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Author: lsf Time: 6/16/20-2:19 PM
 */
public class LazyPrimMSTTest extends TestCase {
  private LazyPrimMST lazyPrimMST;

  @Test
  public void test() {
    In in = new In("tinyEWD.txt");
    EdgeWeightedGraph G = new EdgeWeightedGraph(in);
    lazyPrimMST = new LazyPrimMST(G);
    System.out.println();
  }
}