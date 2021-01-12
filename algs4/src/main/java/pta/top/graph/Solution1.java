package pta.top.graph;

import java.util.List;

/**
 * Author: lsf Time: 11/16/20-10:53 AM
 */
public class Solution1 {

  public class AdjacencyGraph {
    private List<Vertex> vertices;

    // 顶点
    public class Vertex {

      private Integer data;
      private List<Vertex> adjacentVertices;

      public Integer getData() {
        return data;
      }

      public void setData(Integer data) {
        this.data = data;
      }

      public List<Vertex> getAdjacentVertices() {
        return adjacentVertices;
      }

      public void setAdjacentVertices(
          List<Vertex> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
      }

      public void addAdjacentVertex(Vertex vertex) throws Exception {
        Integer data = vertex.getData();
        for (Vertex v : adjacentVertices) {
          if (data.equals(vertex.getData())) {
            throw new Exception();
          }
        }
        adjacentVertices.add(vertex);
      }

      public void removeAdjacentVertex(Vertex vertex) throws Exception {
        if (adjacentVertices.contains(vertex)) {
          adjacentVertices.remove(vertex);
        } else {
          throw new Exception();
        }
      }
    }

  }
}
