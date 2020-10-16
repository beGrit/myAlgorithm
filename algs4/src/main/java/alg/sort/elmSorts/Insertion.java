package alg.sort.elmSorts;

import java.util.Comparator;

/**
 * Author: lsf Time: 6/16/20-6:39 PM
 */
public class Insertion extends AbstractSort {

  private Insertion() {
  }

  public static void sort(Comparable[] a) { // input:n
//    int n = a.length;
//    for (int i = 0; i < n; i++) {
//      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
//        exch(a, j, j - 1);
//      }
//      assert isSorted(a,0,i);
//    }
//    assert isSorted(a);
    sort(a, 0, a.length);
  }

  /**
   * Rearranges the subarray a[lo..hi) in ascending order, using the natural order.
   *
   * @param a  the array to be sorted
   * @param lo left endpoint (inclusive)
   * @param hi right endpoint (exclusive)
   */
  public static void sort(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i < hi; i++) {
      for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
    assert isSorted(a, lo, hi);
  }

  public static void sort(Object[] a, Comparator comparator) {
    sort(a,0,a.length,comparator);
  }

  public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
    for (int i = lo + 1; i < hi; i++) {
      for (int j = i; j > lo && less(comparator, a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
    assert isSorted(a, comparator, lo, hi);
  }

  /**
   * 对数组排序,不改变数组,返回下标的排序
   * @param a 给定的需要排序的数据
   * @return
   */
  public static int[] indexSort(Comparable[] a) {
    int n = a.length;
    int[] index = new int[n];
    for (int i = 0; i < n; i++)
      index[i] = i;

    for (int i = 1; i < n; i++)
      for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--)
        exch(index, j, j-1);
    return index;
  }
}
