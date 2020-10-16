package leetcode.primary.linkedList;

/**
 * Author: lsf Time: 9/14/20-3:35 PM
 */
public class Solution2 {

  /**
   * 方法一:一趟遍历(双指针法)
   *
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // 哨兵
    ListNode head_head = new ListNode(head.val);
    head_head.next = head;
    ListNode pre = head_head;
    ListNode slow = head;
    ListNode fast = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next;
    }

    // 删除节点
    if (slow == head) {
      head = head.next;
      return head;
    } else {
      pre.next = slow.next;
      return head;
    }
  }
}
