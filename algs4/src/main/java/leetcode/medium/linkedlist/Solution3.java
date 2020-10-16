package leetcode.medium.linkedlist;

/**
 * Author: lsf Time: 9/28/20-7:24 PM
 */
public class Solution3 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    return function1(headA, headB);
  }
  /**
   * 代码优化版本
   */
  public ListNode function1(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }
    return pA;
  }
}
