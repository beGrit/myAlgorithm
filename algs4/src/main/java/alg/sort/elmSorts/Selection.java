package alg.sort.elmSorts;

import java.util.Comparator;

/**
 * Author: lsf Time: 6/16/20-6:22 PM
 */
public class Selection extends AbstractSort{
  private Selection() {}

  public static void sort(Comparable[] a) {
    int n = a.length;
    // 贪心：每一步都从局部中选择出最优的解（最小值）
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i+1; j < n; j++) {
        if (less(a[j], a[min])) min = j;
      }
      exch(a, i, min);
      assert isSorted(a, 0, i);
    }
    assert isSorted(a);
  }

  public static void sort(Object[] a, Comparator comparator) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i+1; j < n; j++) {
        if (less(comparator, a[j], a[min])) min = j;
      }
      exch(a, i, min);
      assert isSorted(a, comparator, 0, i);
    }
    assert isSorted(a, comparator);
  }

  public static void main(String[] args) {

  }
}
