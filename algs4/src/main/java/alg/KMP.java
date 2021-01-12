package alg;

/**
 * Author: lsf Time: 9/2/20-5:22 PM
 */
public class KMP {

  public static void main(String[] args) {
    KMP kmp = new KMP();
    String temp = "ababababca";
    String tar = "abababca";
    int n = 0;
    while (kmp.KMP(n, temp, tar) != -1) {

    }
    kmp.getNext("abab");
  }

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

  public int KMP(String temp, String tar) {
    int[] next = getNext(tar);
    int i = 0;
    int j = 0;
    while (i < temp.length() && j < tar.length()) {
      if (j == -1 || temp.charAt(i) == tar.charAt(j)) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }

    if (j == tar.length()) { // 匹配成功
      return i - j;
    } else { // 匹配失败
      return -1;
    }
  }

  public int KMP(int bg, String temp, String tar) {
    int[] next = getNext(tar);
    int i = bg;
    int j = 0;
    while (i < temp.length() && j < tar.length()) {
      if (j == -1 || temp.charAt(i) == tar.charAt(j)) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }

    if (j == tar.length()) { // 匹配成功
      return i - j;
    } else { // 匹配失败
      return -1;
    }
  }
}
