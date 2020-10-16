package leetcode.medium.linkedlist;

/**
 * Author: lsf Time: 9/27/20-9:24 PM
 */
public class Solution2 {
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode h1 = head;
    ListNode h2 = head.next;
    ListNode p = h1;
    ListNode q = h2;
    while (q != null) {
      p.next = q.next;
      if (p == h1 && h1.next != null) {
        h1 = h1.next;
      }
      p = q;
      q = q.next;
    }
    h1.next = h2;
    return head;
  }
}
