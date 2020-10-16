package Trees;

import Trees.heaps.onlyInteger.MaxHeap;
import org.junit.Test;

/**
 * Author: lsf Time: 5/24/20-12:42 PM
 */
public class MaxHeapTest {

  @Test
  public void init() {
    MaxHeap maxHeap = new MaxHeap().init(6,99999);
    maxHeap.insert(3);
    maxHeap.insert(7);
    maxHeap.insert(4);
    maxHeap.insert(9);
  }

  @Test
  public void insert() {
  }

  @Test
  public void delete() {
  }

  @Test
  public void getTopMax() {
  }
}