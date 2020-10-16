package alg.sort.elmSorts;

/**
 * Author: lsf Time: 6/17/20-9:59 AM
 */
public class Shell extends AbstractSort {

  private Shell() {
  }

  /**
   * 增量序列 h = 3x + 1
   * */
  public static void sort(Comparable[] a) {
    int n = a.length;

    // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
    int h = 1;
    while (h < n/3) h = 3*h + 1;

    while (h >= 1) {
      // h-alg.sort the array
      // 插入排序
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
          exch(a, j, j-h);
        }
      }
      assert isHsorted(a, h);
      h /= 3;
    }
    assert isSorted(a);
  }

  public static boolean isHsorted(Comparable[] a, int h) {
    for (int i = h; i < a.length; i++) {
      if (less(a[i], a[i - h])) {
        return false;
      }
    }
    return true;
  }
}
