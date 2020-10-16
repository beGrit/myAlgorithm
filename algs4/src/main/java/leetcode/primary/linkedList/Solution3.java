package leetcode.primary.linkedList;

/**
 * Author: lsf Time: 9/14/20-8:29 PM
 */
public class Solution3 {
  public ListNode reverseList(ListNode head) {
    head = function1(head);
    return head;
  }

  /**
   * 方法一:迭代
   * O(n) O(1)
   * @param head
   *
   */
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

  /**
   * 方法二:递归
   * O(n) O(n)
   * @param head
   * @return
   */
  public ListNode function2(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    return p;
  }
}
