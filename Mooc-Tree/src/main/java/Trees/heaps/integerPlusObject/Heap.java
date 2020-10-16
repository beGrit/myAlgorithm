package Trees.heaps.integerPlusObject;

import java.util.List;

/**
 * Author: lsf Time: 5/30/20-9:52 AM
 */
public abstract class Heap<T> {
  protected int capacity;
  protected int currentSize;
  protected List<HeapNode> elements;
  protected HeapNode guard;

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getCurrentSize() {
    return currentSize;
  }

  public void setCurrentSize(int currentSize) {
    this.currentSize = currentSize;
  }

  public boolean isFull() {
    return this.getCurrentSize() == this.getCapacity();
  }

  public boolean isEmpty() {
    return currentSize == 0;
  }

  public Heap() {
  }

  public Heap(int capacity, int currentSize, HeapNode guard) {
    this.capacity = capacity;
    this.currentSize = currentSize;
    this.guard = guard;
  }

  public abstract void create(List<HeapNode> list);

  public abstract boolean insert(HeapNode hn);

  public abstract HeapNode delete();     // 返回堆顶元素并删除,若堆空返回哨兵

  public abstract void preDown(HeapNode p);

}
