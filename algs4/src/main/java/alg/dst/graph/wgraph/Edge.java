package alg.dst.graph.wgraph;

/**
 * Author: lsf Time: 6/16/20-11:30 AM
 */
public class Edge implements Comparable<Edge>{

  private final int v;
  private final int w;
  private final double weight;

  public Edge(int v, int w, double weight) {
    if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
    if (w < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
    if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  /**
   * 返回边的权重
   * */
  public double weight() {
    return weight;
  }

  /**
   * 返回其中一个顶点
   * */
  public int either() {
    return v;
  }

  /**
   * 返回另一个顶点
   * */
  public int other(int vertex) {
    if      (vertex == v) return w;
    else if (vertex == w) return v;
    else throw new IllegalArgumentException("Illegal endpoint");
  }

  /**
   * 静态方法:用于比较俩条边的权重
   * */
  public int compareTo(Edge that) {
    return Double.compare(this.weight,that.weight);
  }


  public String toString() {
    return String.format("%d-%d %.5f", v, w, weight);
  }

}
