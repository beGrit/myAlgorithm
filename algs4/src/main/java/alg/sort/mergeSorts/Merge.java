package alg.sort.mergeSorts;

/**
 * Author: lsf Time: 6/22/20-11:11 AM
 */
public class Merge {

  public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (lo > hi) {
      return;
    }
    int mid = (hi - lo) / 2 + lo;
    sort(a, aux, lo, mid);
    sort(a, aux, mid, hi);
    merge(a, aux, lo, mid, hi);
  }

  /**
   * @param a   目标数组(a[lo...hi] )( [lo,hi])
   * @param aux 工具数组,用于临时存储
   * @param lo
   * @param mid
   * @param hi
   */
  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    // Verify that the sub segments are sorted
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid + 1, hi);

    // copy to aux[]
    for (int i = lo; i <= hi; i++) {
      aux[i] = a[i];
    }

    // copy back to a[]
    int m = lo, n = mid + 1;
    for (int i = lo; i <= hi; i++) {
      if (less(aux[n], aux[m])) {
        a[i] = aux[n++];
      } else if (n > hi) {
        a[i] = aux[m++];
      } else if (m > mid) {
        a[i] = aux[n++];
      }
    }
    assert isSorted(a, lo, hi);
  }

  // is a < b ?
  private static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  private static boolean isSorted(Comparable[] a) {
    return isSorted(a, 0, a.length - 1);
  }

  private static boolean isSorted(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }
}
