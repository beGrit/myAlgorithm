package leetcode.primary.linkedList;

/**
 * Author: lsf Time: 9/14/20-8:34 PM
 */
public class Solution5 {
  public boolean isPalindrome(ListNode head) {
    // 复制

    // 反转

    // 比较

    return false;
  }

  public ListNode function1(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }
}
