package leetcode.daily.linkedlist;

import leetcode.daily.dataobject.ListNode;
import leetcode.daily.util.LinkedListUtil;

/**
 * Author: lsf Time: 10/23/20-8:29 AM
 */
public class Solution65 {
  public boolean isPalindrome(ListNode head) {
    return function2(head);
  }

  /**
   * 方法一:反转链表,并且比较
   * @param head
   * @return
   */
  public boolean function1(ListNode head) {
    ListNode ln = head;
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();
    while (ln != null) {
      s1.append(ln.val + "#");
      ln = ln.next;
    }
    head = reverse(head);
    ln = head;
    while (ln != null) {
      s2.append(ln.val + "#");
      ln = ln.next;
    }
    return new String(s1).equals(new String(s2));
  }

  public ListNode reverse(ListNode head) {
    ListNode pre = null,ln = head;
    while (ln != null) {
      ListNode tmp = ln.next;
      ln.next = pre;
      pre = ln;
      ln = tmp;
    }
    return pre;
  }

  /**
   * 方法二:快慢指针 + 反转后半段 + 比较
   * @param head
   * @return
   */
  public boolean function2(ListNode head) {
    if (head == null) {
      return true;
    }
    boolean res = true;
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    slow.next = reverse(slow.next);
    fast = slow.next;
    slow = head;
    while (fast != null) {
      if (slow.val != fast.val) {
        res = false;
        break;
      }
      slow = slow.next;
      fast = fast.next;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution65 solution65 = new Solution65();
    int[] nums = {1,2,2,1};
    ListNode head = LinkedListUtil.init(nums);
    boolean res = solution65.isPalindrome(head);
  }
}
