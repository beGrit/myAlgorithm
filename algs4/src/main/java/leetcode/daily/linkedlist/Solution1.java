package leetcode.daily.linkedlist;

import leetcode.daily.dataobject.ListNode;
import leetcode.daily.util.ListUtil;

/**
 * Author: lsf Time: 11/15/20-10:24 AM
 */
public class Solution1 {
  // 328. 奇偶链表

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int[] nums = {1, 2, 3, 4};
    ListNode head = ListUtil.init(nums);
    solution1.oddEvenList(head);
  }

  // 双指针
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode head1 = head, ln1 = head;
    ListNode head2 = head.next, ln2 = head.next;
    boolean b = false;
    while (ln1 != null && ln2 != null) {
      if (!b) {
        ln1.next = ln2.next;
        ln1 = ln1.next;
      } else {
        ln2.next = ln1.next;
        ln2 = ln2.next;
      }
      b = !b;
    }
    return null;
  }


  public ListNode function(ListNode head){
    if (head == null) {
      return null;
    }
    ListNode h1 = head;
    ListNode h2 = head.next;
    ListNode p = h1;
    ListNode q = h2;
    while (q != null) {
      p.next = q.next;
      if (p == h1 && h1.next != null) {
        h1 = h1.next;
      }
      p = q;
      q = q.next;
    }
    h1.next = h2;
    return head;
  }
}
