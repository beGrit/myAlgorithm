package graph.mgraph;

import graph.mgraph.exception.MGraphException;
import lombok.Data;

/**
 * Author: lsf Time: 6/4/20-9:44 AM
 */
@Data
public class AdjacencyMatrixGraph { // 邻接矩阵表示图(有向无权值图)

  static final int EDGE_EXIST = 1;
  static final int EDGE_NONE = -1;
  private int _numberOfVertices;  // 顶点的数量
  private int _numberOfEdges;     // 边的数量
  private int[][] _adjacency;     // 邻接矩阵 , -1代表无边,正值代表权值

  public AdjacencyMatrixGraph() {
  }

  public AdjacencyMatrixGraph(int _numberOfVertices) {
    init(_numberOfVertices);
  }

  // 构建相关操作集
  private void init(int _numberOfVertices) {
    this._numberOfVertices = _numberOfVertices;
    this._adjacency = new int[_numberOfVertices][_numberOfVertices];
    for (int i = 0; i < _numberOfVertices; i++) {
      for (int j = 0; j < _numberOfVertices; j++) {
        this._adjacency[i][j] = AdjacencyMatrixGraph.EDGE_NONE;
      }
    }
  }

  public boolean vertexDoesExist(int aVertex) {
    if (aVertex >= 0 && aVertex < this.get_numberOfVertices()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean adjacencyOfEdgeDoesExist(int from,int end) {
    return _adjacency[from][end] == AdjacencyMatrixGraph.EDGE_EXIST;
  }

  public void addEdge(int from, int end) {
    if (vertexDoesExist(from) && vertexDoesExist(end)) {
      if (!adjacencyOfEdgeDoesExist(from, end)) {
        // 修改邻接矩阵
        _adjacency[from][end] = AdjacencyMatrixGraph.EDGE_EXIST;
        // 修改边的总数量
        set_numberOfEdges(get_numberOfEdges() + 1);
      } else {
        throw new MGraphException("Edge does exist");
      }
    } else {
      throw new MGraphException("Vertex dose not exist");
    }
  }

  public void removeEdge(int from, int end) {
    if (vertexDoesExist(from) && vertexDoesExist(end)) {
      if (adjacencyOfEdgeDoesExist(from, end)) {
        // 修改邻接矩阵
        _adjacency[from][end] = AdjacencyMatrixGraph.EDGE_NONE;
        // 修改边的总数量
        set_numberOfEdges(get_numberOfEdges() - 1);
      } else {
        throw new MGraphException("Edge does not exist");
      }
    } else {
      throw new MGraphException("Vertex dose not exist");
    }
  }



}
