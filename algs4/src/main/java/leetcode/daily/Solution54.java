package leetcode.daily;

/**
 * Author: lsf Time: 10/13/20-2:18 PM
 */
public class Solution54 {

  public ListNode swapPairs(ListNode head) {
    return function1(head);
  }

  /**
   * 方法一:双指针
   *
   * @param head
   * @return
   */
  public ListNode function1(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode l1 = head;
    ListNode l2 = head.next;
    ListNode pre = null;
    while (l2 != null && l1 != null) {
      l1.next = l2.next;
      l2.next = l1;
      if (pre == null) {
        head = l2;
        pre = l1;
      } else {
        pre.next = l2;
        pre = l1;
      }
      l1 = l1.next;
      if (l1 != null) {
        l2 = l1.next;
      }
    }
    return head;
  }

  /**
   * 指针迭代优化版
   *
   * @param head
   * @return
   */
  public ListNode function2(ListNode head) {
    // 空节点
    if (head == null) {
      return null;
    }
    // 单个节点
    if (head.next == null) {
      return head;
    }
    // 哨兵(虚的头指针)
    ListNode dummyHead = new ListNode(-1);
    ListNode pre = dummyHead;
    ListNode l1 = head;
    ListNode l2 = head.next;
    while (l1 != null && l2 != null) {
      pre.next = l2;
      l1.next = l2.next;
      l2.next = l1;
      pre = l1;
      l1 = pre.next;
      if (l1 != null) {
        l2 = l1.next;
      }
    }
    return dummyHead.next;
  }

  /**
   * 方法二:递归解法
   * @param head
   * @return
   */
  public ListNode function3(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = head.next;
    head.next = function3(newHead.next);
    newHead.next = head;
    return newHead;
  }
}