package graph.lgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Author: lsf Time: 6/4/20-10:35 AM
 */
public class AdjacencyListGraph<E extends Comparable<E>> {

  private List<Vertex> vertices;

  public List<Vertex> getVertices() {
    return vertices;
  }

  public void setVertices(List<E> list) {
    ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    for (E e : list) {
      vertices.add(new Vertex(e));
    }
    this.vertices = vertices;
  }

  public boolean removeEdge(E from, E to) {
    Vertex fromV = null;
    for (Vertex v : vertices) {
      if (from.compareTo(v.data) == 0) {
        fromV = v;
        break;
      }
    }
    if (fromV == null) {
      return false;
    }
    return fromV.removeAdjacentVertex(to);
  }

  public boolean addEdge(E from, E to) {
    Vertex fromV = null, toV = null;
    for (Vertex v : vertices) {
      if (from.compareTo(v.data) == 0) {
        fromV = v;
      } else if (to.compareTo(v.data) == 0) {
        toV = v;
      }
      if (fromV != null && toV != null) {
        break;
      }
    }
    if (fromV == null) {
      fromV = new Vertex(from);
      vertices.add(fromV);
    }
    if (toV == null) {
      toV = new Vertex(to);
      vertices.add(toV);
    }
    return fromV.addAdjacentVertex(toV);
  }

  public Map<E, Boolean> initMap(Map<E, Boolean> visited) {
    for (Vertex v : vertices) {
      visited.put(v.getData(), false);
    }
    return visited;
  }

  public void DFS(Map<E, Boolean> visited) {
    this.DFS(vertices.get(0), visited);
  }

  public void DFS(Vertex v, Map<E, Boolean> visited) {
    visited.put(v.data, true);
    System.out.print(v.data + " ");
    for (Vertex tmp : v.getAdjacentVertices()) {
      if (!visited.get(tmp.data)) {
        DFS(tmp, visited);
      }
    }
  }

  public void BFS(Map<E, Boolean> visited) {
    this.BFS(vertices.get(0), visited);
  }

  public void BFS(Vertex v, Map<E, Boolean> visited) {
    Queue<Vertex> queue = new LinkedList<Vertex>();
//    Vertex v = vertices.get(0);
    visited.put(v.getData(), true);
    System.out.print(v.data + " ");
    queue.offer(v);
    while (!queue.isEmpty()) {
      Vertex s = queue.poll();
      for (Vertex tmp : s.getAdjacentVertices()) {
        if (!visited.get(tmp.data)) {
          visited.put(tmp.data, true);
          System.out.print(tmp.data + " ");
          queue.offer(tmp);
        }
      }
    }
  }

  public int BFS_02(Vertex v, Map<E, Boolean> visited) { // 返回 结点距离不超过6的结点数
    int num = 0;
    int p = 0;
    Vertex last, tail;
    Queue<Vertex> queue = new LinkedList<Vertex>();
    visited.put(v.getData(), true);
    System.out.print(v.data + " ");
    queue.offer(v);
    last = v;
    tail = v;
    while (!queue.isEmpty() && p < 6) {
      Vertex s = queue.poll();
      for (Vertex tmp : s.getAdjacentVertices()) {
        if (!visited.get(tmp.data)) {
          visited.put(tmp.data, true);
          queue.offer(tmp);
          num++;
          tail = tmp;
        }
      }
      if (last == s) {
        p++;
        last = tail;
      }
    }
    return num;
  }

  public void showConnectedSet(Map<E, Boolean> visited) { // DFS
    for (Vertex v : vertices) {
      if (!visited.get(v)) {
        DFS(v, visited);
      }
    }
  }

  public int size() {
    return vertices.size();
  }

  private class Vertex { // 顶点

    E data;
    ArrayList<Vertex> adjacentVertices;

    public Vertex(E data) {
      adjacentVertices = new ArrayList<Vertex>();
      this.data = data;
    }

    public E getData() {
      return data;
    }

    public void setData(E data) {
      this.data = data;
    }

    public boolean addAdjacentVertex(Vertex to) {
      for (Vertex v : adjacentVertices) {
        if (v.data.compareTo(to.data) == 0) {
          return false; // 结点已存在
        }
      }
      return adjacentVertices.add(to);
    }

    public boolean removeAdjacentVertex(E to) {
      for (int i = 0; i < adjacentVertices.size(); i++) {
        if (adjacentVertices.get(i).data.compareTo(to) == 0) {
          adjacentVertices.remove(i);
          return true;
        }
      }
      return false;
    }

    public ArrayList<Vertex> getAdjacentVertices() {
      return adjacentVertices;
    }
  }
}
