package Trees.heaps.integerPlusObject;

/**
 * Author: lsf Time: 5/30/20-9:52 AM
 */
public class HeapNode<T> {
  private int key;
  private Object value;

  public HeapNode(int key, Object value) {
    this.key = key;
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }
}
