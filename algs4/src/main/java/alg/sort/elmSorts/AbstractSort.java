package alg.sort.elmSorts;

import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;

/**
 * Author: lsf Time: 6/16/20-6:48 PM
 */
public abstract class AbstractSort { // 升序排序

  protected static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
  protected static void exch(int[] a, int i, int j) {
    int swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  protected static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  // is v < w ?
  protected static boolean less(Comparator comparator, Object v, Object w) {
    return comparator.compare(v,w) < 0;
  }

  protected static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (less(comparator,a[i],a[i-1])) {
        return false;
      }
    }
    return true;
  }
  protected static boolean isSorted(Object[] a,Comparator comparator) {
    return isSorted(a, comparator, 0, a.length - 1);
  }
  protected static boolean isSorted(Comparable[] a) {
    return isSorted(a, 0, a.length - 1);
  }
  protected static boolean isSorted(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++)
      if (less(a[i], a[i-1])) return false;
    return true;
  }

  protected static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.println(a[i]);
    }
  }

}
