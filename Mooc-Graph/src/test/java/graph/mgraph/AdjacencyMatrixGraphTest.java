package graph.mgraph;

import junit.framework.TestCase;

/**
 * Author: lsf Time: 6/4/20-10:30 AM
 */
public class AdjacencyMatrixGraphTest extends TestCase {
  private AdjacencyMatrixGraph mGraph = new AdjacencyMatrixGraph(5);
  public void testAddEdge() {
    mGraph.addEdge(1,2);
    mGraph.removeEdge(1,2);
  }

  public void testRemoveEdge() {
  }
}