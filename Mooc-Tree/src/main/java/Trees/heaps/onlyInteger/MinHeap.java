package Trees.heaps.onlyInteger;

/**
 * Author: lsf Time: 5/24/20-11:58 AM
 */
public class MinHeap extends Heap {

  public MinHeap init(int capacity, int minData) {
    super.init(capacity, minData);
    return this;
  }

  public boolean insert(int X) {
    if (isFull()) {
      System.out.println("最小堆已满");
      return false;
    } else {
      int i = ++this.currentSize;
      for (; this.elements[i / 2] > X; i /= 2) {
        this.elements[i] = this.elements[i / 2];
      }
      this.elements[i] = X;
      return true;
    }
  }

  public int delete() {
    int parent, child;
    int temp, minItem;
    if (isEmpty()) {
      System.out.println("MinHeap为空");
      return elements[0];
    }
    minItem = elements[1];
    temp = elements[currentSize--];
    for (parent = 1; parent * 2 <= currentSize; parent = child) {
      child = parent * 2;
      if ((child != currentSize) && (elements[child] > elements[child + 1])) {// 有右孩子,且右孩子较小
        child++;
      }
      if (temp < elements[child]) {
        break;
      } else {
        elements[parent] = elements[child];
      }
    }
    elements[parent] = temp;
    return minItem;
  }

  public void preDown(int p) {
    int parent, child;
    int X;
    X = elements[p];
    for (parent = p; parent * 2 <= currentSize; parent = child) {
      child = parent * 2;
      if ((child != currentSize) && (elements[child] > elements[child++])) { // 右孩子较小
        child++;
      }
      if ( X <= elements[child] ) break;
      else elements[parent] = elements[child];
    }
    elements[parent] = X;
  }

  public void createByArrays(int[] arrays) {
    for (int i = currentSize / 2; i > 0; i--) {
      preDown(i);
    }
  }

}
