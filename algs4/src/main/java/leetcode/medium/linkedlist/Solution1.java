package leetcode.medium.linkedlist;

/**
 * Author: lsf Time: 9/27/20-11:25 AM
 */
public class Solution1 {

  /**
   * @param l1
   * @param l2
   * @return
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return function1(l1, l2);
  }

  public ListNode function1(ListNode l1, ListNode l2) {
    // 进位标识符
    int tag = 0;
    ListNode preHead = new ListNode(0);
    ListNode tn = preHead;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + tag;
      if (sum >= 10) {
        tag = 1;
        sum -= 10;
      } else {
        tag = 0;
      }
      tn.next = new ListNode(sum);
      tn = tn.next;
      l1 = l1.next;
      l2 = l2.next;
    }

    while (l1 != null) {
      int sum = l1.val + tag;
      if (sum >= 10) {
        tag = 1;
        sum -= 10;
      } else {
        tag = 0;
      }
      tn.next = new ListNode(sum);
      tn = tn.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int sum = l2.val + tag;
      if (sum >= 10) {
        tag = 1;
        sum -= 10;
      } else {
        tag = 0;
      }
      tn.next = new ListNode(sum);
      tn = tn.next;
      l2 = l2.next;
    }

    if (tag == 1) {
      tn.next = new ListNode(1);
    }

    return preHead.next;
  }
}
