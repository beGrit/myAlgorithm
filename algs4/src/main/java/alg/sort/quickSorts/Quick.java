package alg.sort.quickSorts;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Author: lsf Time: 10/15/20-10:03 AM
 */
public class Quick {

  private Quick() {
  }

  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);

    assert isSorted(a);

  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi > lo) {
      int j = partition(a, lo, hi);
      sort(a, lo, j - 1);
      sort(a, j + 1, hi);

      assert isSorted(a, lo, hi);

    }
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    Comparable v = a[lo];

    while (true) {
      do {
        ++i;
      } while (less(a[i], v) && i != hi);

      do {
        --j;
      } while (less(v, a[j]) && j != lo);

      if (i >= j) {
        exch(a, lo, j);
        return j;
      }

      exch(a, i, j);
    }
  }

  public static Comparable select(Comparable[] a, int k) {
    if (k >= 0 && k < a.length) {
      StdRandom.shuffle(a);
      int lo = 0;
      int hi = a.length - 1;

      while (hi > lo) {
        int i = partition(a, lo, hi);
        if (i > k) {
          hi = i - 1;
        } else {
          if (i >= k) {
            return a[i];
          }

          lo = i + 1;
        }
      }

      return a[lo];
    } else {
      throw new IndexOutOfBoundsException("Selected element out of bounds");
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static boolean isSorted(Comparable[] a) {
    return isSorted(a, 0, a.length - 1);
  }

  private static boolean isSorted(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; ++i) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }

    return true;
  }

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; ++i) {
      StdOut.println(a[i]);
    }

  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    show(a);

    assert isSorted(a);

    StdRandom.shuffle(a);
    StdOut.println();

    for (int i = 0; i < a.length; ++i) {
      String ith = (String) select(a, i);
      StdOut.println(ith);
    }

  }
}

