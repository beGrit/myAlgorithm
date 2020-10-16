package leetcode.primary.linkedList;

/**
 * Author: lsf Time: 9/14/20-8:09 PM
 */
public class Solution4 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

//    return function1(l1, l2);
    return helper(l1, l2);
  }

  /**
   * 方法一:迭代
   *
   * @param l1
   * @param l2
   */
  public ListNode function1(ListNode l1, ListNode l2) {
    ListNode preHead = new ListNode(-1);
    ListNode prev = preHead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }

    // 直接连接剩下的链表
    if (l1 == null) {
      prev.next = l2;
    } else {
      prev.next = l1;
    }
    return preHead.next;
  }

  /**
   * 方法二:递归
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode helper(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else {
      if (l1.val <= l2.val) {
        l1.next = helper(l1.next, l2);
        return l1;
      } else {
        l2.next = helper(l1, l2.next);
        return l2;
      }
    }
  }

}