package leetcode.daily.util;

import leetcode.daily.dataobject.ListNode;

/**
 * Author: lsf Time: 10/10/20-9:25 AM
 */
public class ListUtil {
  public static ListNode init(int[] nums, int pos) {
    ListNode head = null;
    ListNode t = null;
    ListNode ln = new ListNode(-1);
    int count = -1;
    for (int i : nums) {
      ln.next = new ListNode(i);
      ln = ln.next;
      count++;
      if (count == pos) {
        t = ln;
      }
      if (head == null) {
        head = ln;
      }
    }
    ln.next = t;
    return head;
  }
}
