package Trees.node;

/**
 * Author: lsf Time: 5/24/20-11:53 AM
 */
public class HeapNode {
  private int value;
  private HeapNode left,right,parent;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public HeapNode getLeft() {
    return left;
  }

  public void setLeft(HeapNode left) {
    this.left = left;
  }

  public HeapNode getRight() {
    return right;
  }

  public void setRight(HeapNode right) {
    this.right = right;
  }

  public HeapNode getParent() {
    return parent;
  }

  public void setParent(HeapNode parent) {
    this.parent = parent;
  }
}
