package leetcode.daily.util;

import leetcode.daily.dataobject.ListNode;

/**
 * Author: lsf Time: 10/20/20-9:44 AM
 */
public class LinkedListUtil {
  public static ListNode init(int[] nums) {
    ListNode dummyHead = new ListNode(0);
    ListNode ln = dummyHead;
    for (int val : nums) {
      ln.next = new ListNode(val);
      ln = ln.next;
    }
    return dummyHead.next;
  }
}
