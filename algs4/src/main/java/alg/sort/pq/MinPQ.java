package alg.sort.pq;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author: lsf Time: 6/17/20-11:12 AM
 */
public class MinPQ<Key> implements Iterable<Key> {

  /**
   * @varible n 当前pq队列中的元素数量
   */
  private Key[] pq;
  private int n;
  private Comparator<Key> comparator;
  private Key guard;

  public MinPQ(int capacity, Key guard) {
    this(capacity);
    this.guard = guard;
  }

  public MinPQ(int capacity) {
    pq = (Key[]) new Object[capacity + 1];
    n = 0;
  }

  public MinPQ(int capacity, Comparator<Key> comparator) {
    this.pq = (Key[]) new Object[capacity + 1];
    this.n = 0;
    this.comparator = comparator;
  }

  public MinPQ(Key[] keys) {
    this.n = keys.length;
    this.pq = (Key[]) new Object[keys.length + 1];

    int k;
    for (k = 0; k < this.n; ++k) {
      this.pq[k + 1] = keys[k];
    }

    for (k = this.n / 2; k >= 1; --k) {
      this.sink(k);
    }
  }

  public Key delMin() {
    if (isEmpty()) {
      throw new NoSuchElementException("[delMin] The MinPQ is empty.");
    } else {
      exch(1, n); // n = 1
      Key res = pq[n--];
      if (n == 0 || n == 1) {
        return res;
      } else {
        sink(1);
        return res;
      }
    }
  }

  public Key min() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("Priority queue underflow");
    } else {
      return this.pq[1];
    }
  }

  public void insert(Key k) {
    if ( n == pq.length - 1) {
      resize( 2 * ( pq.length - 1 ) );
    }
    pq[++n] = k;
    swim(n);
  }


  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return this.n;
  }


  private void resize(int capacity) {
    assert capacity > n;
    Key[] temp = (Key[]) new Object[capacity + 1];
    for (int i = 0; i < n + 1; i++) {
      temp[i] = pq[i];
    }
    pq = temp;
  }
  /**
   * 向上走 (Bottom-up reheapify)
   *
   * @param k
   */
  private void swim(int k) {
    while (k > 1 && greater(k / 2, k)) {
      exch(k / 2, k);
      k /= 2;
    }
  }

  /**
   * 向下走 (Top-down heapify)
   *
   * @param k
   */
  private void sink(int k) {
    int parent = k;
    int child = 2 * parent;
    while (parent * 2 < this.n) {     // n = 5 , 1 2 4
      child *= 2;
      if (child < this.n && greater(child, child + 1)) {
        child++;
      }
      if (greater(parent, child)) {
        exch(parent, child);
        parent = child;
        continue;
      } else {
        break;
      }
    }
  }

  /**
   * @param i
   * @param j
   * @return true 选择 j,false 选择 i
   */
  private boolean greater(int i, int j) {
    if (this.comparator == null) {
      return ((Comparable) this.pq[i]).compareTo(this.pq[j]) > 0;
    } else {
      return this.comparator.compare(this.pq[i], this.pq[j]) > 0;
    }
  }

  private void exch(int i, int j) {
    Key swap = this.pq[i];
    this.pq[i] = this.pq[j];
    this.pq[j] = swap;
  }

  public Iterator<Key> iterator() {
    return new MinPQ.HeapIterator();
  }

  private class HeapIterator implements Iterator<Key> {

    private MinPQ<Key> copy;


    public void remove() {

    }

    public boolean hasNext() {
      return false;
    }

    public Key next() {
      return null;
    }
  }
}
