package leetcode.daily;

/**
 * Author: lsf Time: 10/9/20-8:24 AM
 */
public class Solution50 {
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (true) {
      if (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      } else {
        return false;
      }
      if (fast == slow) {
        return true;
      }
    }
  }
}
