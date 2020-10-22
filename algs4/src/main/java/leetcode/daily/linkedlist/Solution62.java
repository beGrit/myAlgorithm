package leetcode.daily.linkedlist;

import java.util.Deque;
import java.util.LinkedList;
import leetcode.daily.dataobject.ListNode;
import leetcode.daily.util.LinkedListUtil;

/**
 * Author: lsf Time: 10/20/20-9:06 AM
 */
public class Solution62 {

  public static void main(String[] args) {
    Solution62 solution62 = new Solution62();
    int[] nums = {1, 2, 3, 4};
    ListNode head = LinkedListUtil.init(nums);
    solution62.reorderList(head);
  }

  public void reorderList(ListNode head) {
    function1(head);
  }

  /**
   * 方法一: 栈
   *
   * @param head
   */
  public void function1(ListNode head) {
    Deque<ListNode> dq = new LinkedList<>();
    ListNode ln = head;
    while (ln != null) {
      dq.push(ln);
      ln = ln.next;
    }
    ListNode dummyHead = new ListNode(0);
    ListNode pre = dummyHead;
    ListNode ln1, ln2;
    while (!dq.isEmpty()) {
      ln1 = dq.removeLast();
      if (!dq.isEmpty()) {
        ln2 = dq.removeFirst();
        ln1.next = ln2;
        pre.next = ln1;
        pre = ln2;
      } else {
        pre.next = ln1;
        pre = ln1;
      }
      pre.next = null;
    }
  }
}
