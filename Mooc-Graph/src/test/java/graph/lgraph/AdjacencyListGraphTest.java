package graph.lgraph;

import java.util.Arrays;
import java.util.HashMap;
import junit.framework.TestCase;

/**
 * Author: lsf Time: 6/6/20-4:58 PM
 */
public class AdjacencyListGraphTest extends TestCase {

  AdjacencyListGraph<Integer> adjacencyListGraph = new AdjacencyListGraph<Integer>();

  public void init() {
    Integer[] arrays = new Integer[10];
    for (int i = 0; i < 10; i++) {
      arrays[i] = i * 10 + 2;
    }
    adjacencyListGraph.setVertices(Arrays.asList(arrays));
    adjacencyListGraph.addEdge(arrays[0],arrays[3]);
    adjacencyListGraph.addEdge(arrays[0],arrays[4]);
    adjacencyListGraph.addEdge(arrays[1],arrays[3]);
    adjacencyListGraph.addEdge(arrays[4],arrays[1]);
  }

  public void testRemoveEdge() {
  }

  public void testAddEdge() {
    Integer[] arrays = new Integer[10];
    for (int i = 0; i < 10; i++) {
      arrays[i] = i * 10 + 2;
    }
    adjacencyListGraph.setVertices(Arrays.asList(arrays));
    adjacencyListGraph.addEdge(arrays[0],arrays[3]);
    adjacencyListGraph.addEdge(arrays[0],arrays[4]);
    adjacencyListGraph.addEdge(arrays[1],arrays[3]);
    adjacencyListGraph.addEdge(arrays[4],arrays[1]);
  }

  public void testDFS() {

    init();
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    map = (HashMap<Integer, Boolean>) adjacencyListGraph.initMap(map);
    adjacencyListGraph.DFS(map);
  }

  public void testBFS() {
    init();
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    map = (HashMap<Integer, Boolean>) adjacencyListGraph.initMap(map);
    adjacencyListGraph.BFS(map);
  }
}