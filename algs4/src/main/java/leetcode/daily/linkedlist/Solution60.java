package leetcode.daily.linkedlist;

import leetcode.daily.dataobject.ListNode;

/**
 * Author: lsf Time: 10/18/20-1:48 PM
 */
public class Solution60 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode slow = head;
    ListNode fast = head;
    ListNode pre = dummyHead;
    for (int i = 0; i < n; i++) {
      if (fast != null) {
        fast = fast.next;
      }
    }
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      pre = pre.next;
    }
    pre.next = slow.next;
    return dummyHead.next;
  }
}
