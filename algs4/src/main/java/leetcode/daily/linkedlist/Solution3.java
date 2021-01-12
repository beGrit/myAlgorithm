package leetcode.daily.linkedlist;

import leetcode.daily.dataobject.ListNode;

/**
 * Author: lsf Time: 11/22/20-12:28 PM
 */
public class Solution3 {

  // 148. 排序链表
  public ListNode sortList(ListNode head) {
    return null;
  }


  // 合并俩个有序链表
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    return helper(l1,l2);
  }
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
