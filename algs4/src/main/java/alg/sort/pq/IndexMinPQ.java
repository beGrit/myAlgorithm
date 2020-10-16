package alg.sort.pq;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author: lsf Time: 6/17/20-1:10 PM
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Key> {

  // Illegal [0,maxN - 1]
  // valid [0,n - 1]

  private int maxN;
  private int n;
  /**
   * 元素所在数组的下标(唯一标识)
   */
  private int[] pq;
  /**
   *
   */
  private int[] qp;
  /**
   * 元素所在的数组
   */
  private Key[] keys;

  public IndexMinPQ(int maxN) {
    if (maxN < 0) {
      throw new IllegalArgumentException("[Constructor] maxN < 0, [maxN] = " + maxN);
    } else {
      this.maxN = maxN;
      this.n = 0;
      this.pq = new int[maxN + 1];
      this.qp = new int[maxN + 1];
      this.keys = (Key[]) new Comparable[maxN + 1];
      for (int i = 0; i < maxN; i++) {
        this.qp[i] = -1;
      }
    }
  }

  public void insert(int i, Key key) {
    if (i >= 0 && i < this.maxN) {
      if (this.contains(i)) {
        throw new IllegalArgumentException("index is already in the priority queue");
      } else {
        ++this.n;
        this.qp[i] = this.n;
        this.pq[this.n] = i;
        this.keys[i] = key;
        this.swim(this.n);
      }
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public void delete(int i) {
    if (i >= 0 && i < this.maxN) {
      if (!this.contains(i)) {
        throw new NoSuchElementException("index is not in the priority queue");
      } else {
        int index = this.qp[i];
        this.exch(index, this.n--);
        this.swim(index);
        this.sink(index);
        this.keys[i] = null;
        this.qp[i] = -1;
      }
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public void increaseKey(int i, Key key) {
    validateIndex(i);
    if (!this.contains(i)) {
      throw new NoSuchElementException("index is not in the priority queue");
    } else if (this.keys[i].compareTo(key) >= 0) {
      throw new IllegalArgumentException(
          "Calling increaseKey() with given argument would not strictly increase the key");
    } else {
      this.keys[i] = key;
      this.sink(this.qp[i]);
    }
  }

  public void decreaseKey(int i, Key key) {
    if (i >= 0 && i < this.maxN) {
      if (!this.contains(i)) {
        throw new NoSuchElementException("index is not in the priority queue");
      } else if (this.keys[i].compareTo(key) <= 0) {
        throw new IllegalArgumentException(
            "Calling decreaseKey() with given argument would not strictly decrease the key");
      } else {
        this.keys[i] = key;
        this.swim(this.qp[i]);
      }
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  private void swim(int k) {
    while (k > 1 && this.greater(k / 2, k)) {
      this.exch(k, k / 2);
      k /= 2;
    }
  }

  private void sink(int k) {
    while (true) {
      if (2 * k <= this.n) {
        int j = 2 * k;
        if (j < this.n && this.greater(j, j + 1)) {
          ++j;
        }

        if (this.greater(k, j)) {
          this.exch(k, j);
          k = j;
          continue;
        }
      }
      return;
    }
  }

  private void exch(int i, int j) {
    int swap = this.pq[i];
    this.pq[i] = this.pq[j];
    this.pq[j] = swap;
    this.qp[this.pq[i]] = i;
    this.qp[this.pq[j]] = j;
  }

  private boolean greater(int i, int j) {
    return this.keys[this.pq[i]].compareTo(this.keys[this.pq[j]]) > 0;
  }


  /**
   * 用 key 替换 i 位置上的元素
   *
   * @param i
   * @param key
   */
  public void changeKey(int i, Key key) {
    validateIndex(i);
    if (contains(i)) {
      keys[i] = key;
      sink(i);
    } else {
      throw new NoSuchElementException("index i = {" + i + "} is not in the priority queue");
    }
  }

  public boolean contains(int i) {
    if (i < 0 && i > maxN - 1) {
      throw new IllegalArgumentException("[contains()] IllegalArgument i = " + i);
    } else {
      return qp[i] != -1;
    }
  }

  /**
   * @return 最小的元素(不删除)
   */
  public Key min() {
    if (n == 0) {
      throw new NoSuchElementException("[min()] Priority queue underflow");
    } else {
      return keys[pq[1]];
    }
  }

  public Key keyOf(int i) {
    if (i >= 0 && i <= maxN - 1) {
      if (contains(i)) {
        return keys[pq[i]];
      } else {
        throw new NoSuchElementException("index i = {" + i + "} is not in the priority queue");
      }
    } else {
      throw new IllegalArgumentException("i = {" + i + "} is illegal");
    }
  }

  public int minIndex() {
    if (isEmpty()) {
      throw new NoSuchElementException("[minIndex()] n = 0");
    }
    return pq[1];
  }

  public boolean isEmpty() {
    return this.n == 0;
  }

  public void validateIndex(int i) {
    if (i < 0 && i > maxN - 1) {
      throw new NoSuchElementException("index i = {" + i + "} is not in the priority queue");
    }
  }

  public int size() {
    return n;
  }

  public Iterator<Key> iterator() {
    return new IndexMinPQ.HeapIterator();
  }

  private class HeapIterator implements Iterator<Integer> {

    private IndexMinPQ<Key> copy;

    public boolean hasNext() {
      return false;
    }

    public Integer next() {
      return null;
    }

    public void remove() {

    }
  }
}
