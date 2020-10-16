package graph.qustion;

import graph.lgraph.AdjacencyListGraph;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author: lsf Time: 6/9/20-9:06 AM
 */
public class Solution01 { // 列出连通集
  AdjacencyListGraph<Integer> graph;
  public void input() {
    AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<Integer>();
    int numOfVertices;
    int numOfEdges;
    Scanner sc = new Scanner(System.in);
    numOfVertices = sc.nextInt();
    numOfEdges = sc.nextInt();
    for (int i = 0; i < numOfEdges; i++) {
      graph.addEdge(sc.nextInt(),sc.nextInt());
    }
    this.graph = graph;
  }

  public void calculate(AdjacencyListGraph<Integer> graph) {
    Map<Integer, Boolean> map = graph.initMap(new HashMap<Integer, Boolean>());

      graph.BFS(map);
  }

  public void output(int[] arrays) {
    for (int i = 0; i < graph.size(); i++) {
      System.out.println(i + ":" + arrays[i] + "%");
    }
  }

  public static void main(String[] args) {
    Solution01 solution01 = new Solution01();

  }
}
