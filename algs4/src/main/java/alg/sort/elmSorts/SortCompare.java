package alg.sort.elmSorts;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Author: lsf Time: 6/16/20-7:59 PM
 */
public class SortCompare {

  public static double time(String alg, Double[] a) {
    Stopwatch stopwatch = new Stopwatch();
    if (alg.equals("Insertion")) {
      Insertion.sort(a);
    } else if (alg.equals("Selection")){
      Selection.sort(a);
    } else {
      throw new IllegalArgumentException("[SortCompare:time()]Invalid algorithm: " + alg);
    }
    return stopwatch.elapsedTime();
  }

  public static void main(String[] args) {
    Double[] a = new Double[10];
    for (int n = 0; n < a.length; n++) {
//      a[n] = StdRandom
    }
//    time("Insertion",);
  }

}
