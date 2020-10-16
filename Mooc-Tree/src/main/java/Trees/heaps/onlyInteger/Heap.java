package Trees.heaps.onlyInteger;

/**
 * Author: lsf Time: 5/24/20-11:54 AM
 */
public abstract class Heap<T> {

  protected int capacity;
  protected int currentSize;
  protected int[] elements;
  protected int guard;      // 哨兵



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

  public int[] getElements() {
    return elements;
  }

  public void setElements(int[] elements) {
    this.elements = elements;
  }

  public void setElement(int value,int index) {
    getElements()[index] = value;
  }

  public int getGuard() {
    return guard;
  }

  public void setGuard(int guard) {
    this.guard = guard;
  }

  public Heap init(int capacity,int data) {
    this.setCapacity(capacity);
    this.setCurrentSize(0);
    this.setElements(new int[capacity + 1]);
    this.setGuard(data);
    this.setElement(guard,0);
    return this;
  }

  public boolean isFull() {
    return this.getCurrentSize() == this.getCapacity();
  }

  public boolean isEmpty() {
    return currentSize == 0;
  }

  public abstract boolean insert(int X);

  public abstract int delete();     // 返回堆顶元素并删除,若堆空返回哨兵

  public abstract void preDown(int p);

  public abstract void createByArrays(int[] arrays);
}
