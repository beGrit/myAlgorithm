package Trees.heaps.onlyInteger;

/**
 * Author: lsf Time: 5/24/20-11:58 AM
 */
public class MaxHeap extends Heap {

  public MaxHeap init(int capacity, int maxData) {
    super.init(capacity, maxData);
    return this;
  }

  public boolean insert(int X) {
    if (isFull()) {
      System.out.println("最大堆已满");
      return false;
    } else {
      int i = ++this.currentSize;
      for (; this.elements[i / 2] < X; i /= 2) { // i表示 当前流动结点的位置
        this.elements[i] = this.elements[i / 2];
      }
      elements[i] = X;
      return true;
    }
  }

  public int delete() {
    int parent, child;
    int maxItem, temp;
    if (isEmpty()) {
      System.out.println("Heap为空,删除失败");
      return elements[0];
    }
    maxItem = elements[1];
    temp = elements[currentSize--];
    for (parent = 1; parent * 2 <= currentSize; parent = child) {
      child = parent * 2;
      if ((child != currentSize) && (elements[child] < elements[child + 1])) {
        child++;
      }
      if (temp >= elements[child]) {
        break;
      } else {
        elements[parent] = elements[child];
      }
    }
    elements[parent] = temp;
    return maxItem;
  }

  public int getTopMax() {
    return this.delete();
  }

  public void preDown(int p) {
    int parent, child;
    int X;
    X = elements[p];
    for (parent = p; parent * 2 <= currentSize; parent = child) {
      child = parent * 2;
      if ((child != currentSize) && (elements[child] < elements[child++])) {
        child++;
      }
      if ( X >= elements[child] ) break;
      else elements[parent] = elements[child];
    }
    elements[parent] = X;
  }

  public void createByArrays(int[] arrays) {  // 方法1:通过插入操作. 方法二: 1.先建立 完全二叉树 2.再调整各个结点的位置
    for (int i = currentSize / 2; i > 0; i--) {
      preDown(i);
    }
  }
}
