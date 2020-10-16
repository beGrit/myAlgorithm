package alg.sort.elmSorts;

/**
 * Author: lsf Time: 6/16/20-8:04 PM
 */
public class Client {

  public static void main(String[] args) {
//    String[] a = StdIn.readLine().split(" ");
    String[] a = args;
    Insertion.sort(a);
    Insertion.show(a);
  }
}
