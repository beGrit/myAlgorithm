package leetcode.daily.linkedlist;

import leetcode.daily.ListNode;
import leetcode.daily.ListUtil;

/**
 * Author: lsf Time: 10/10/20-9:10 AM`
 */
public class Solution51 {

  public static void main(String[] args) {
    Solution51 solution51 = new Solution51();
    int[] nums = {3,2,0,-4};
    int pos = 2;
    ListNode head = ListUtil.init(nums, pos);
    solution51.detectCycle(head);
  }

  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    int index1 = 0;
    int index2 = 0;
    boolean tag = false;
    do {
      if (fast == null || fast.next == null || fast.next.next == null) {
        tag = true;
        break;
      }
      slow = slow.next;
      fast = fast.next.next;
      index1++;
      index2 += 2;
    } while (slow != fast);

    // 寻找回路起点
    slow = head;
    fast = head;
    if (tag) {
      return null;
    }
    for (int i = 0; i < index2 - index1; i++) {
      fast = fast.next;
    }
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
