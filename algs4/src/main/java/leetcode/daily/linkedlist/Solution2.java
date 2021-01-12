package leetcode.daily.linkedlist;

import leetcode.daily.dataobject.ListNode;
import leetcode.daily.util.LinkedListUtil;

/**
 * Author: lsf Time: 11/20/20-8:42 PM
 */
public class Solution2 {
  public static void main(String[] args) {
    Solution2 solution2 = new Solution2();
    int[] nums = {};
    ListNode head = LinkedListUtil.init(nums);
    head = solution2.insertionSortList(head);
  }

  // 147. 对链表进行插入排序
  public ListNode insertionSortList(ListNode head) {
    head = recursive(head);
    return head;
  }

  // 方法一:递归模拟栈
  public ListNode recursive(ListNode cur) {
    if (cur == null) {
      return cur;
    }
    ListNode retNode = cur;
    cur.next = recursive(cur.next);
    ListNode pre = null;
    while (cur.next != null && cur.val > cur.next.val) {
      if (retNode == cur) {
        retNode = cur.next;
      }
      if (pre != null) {
        pre.next = cur.next;
      }
      pre = cur.next;
      cur.next = cur.next.next;
      pre.next = cur;
    }
    return retNode;
  }
}
