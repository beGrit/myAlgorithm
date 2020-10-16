package alg;

/**
 * Author: lsf Time: 9/2/20-5:22 PM
 */
public class KMP {

  public int[] getNext(String s) {
    int len = s.length();
    int next[] = new int[len + 1];
    char[] chars = s.toCharArray();
    int i = 0;
    int j = -1;
    next[0] = -1;
    /**
     * i = 3
     *
     */
    while (i < len) {
      if (j == -1 || chars[i] == chars[j]) {
        i++;
        j++;
        next[i] = j;
      } else {
        j = next[j];
      }
    }
    return next;
  }

  public static void main(String[] args) {
    KMP kmp = new KMP();
    kmp.getNext("abab");
  }
}
