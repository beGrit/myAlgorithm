package leetcode.primary.linkedList;

/**
 * Author: lsf Time: 9/15/20-6:35 PM
 */
public class Solution6 {

  public boolean hasCycle(ListNode head) {
    return function1(head);
  }

  /**
   * 方法一:双指针法 O(n) O(1)
   *
   * @param head
   * @return
   */
  public boolean function1(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    // 只有单个节点,直接判断是否有环
    if (head == null || head.next == null) {
      return false;
    }
    while (true) {

      // 慢指针每次移动一步
      slow = slow.next;
      // 快指针每次移动俩步
      if (fast.next == null || fast.next.next == null) {
        return false;
      } else {
        fast = fast.next.next;
      }

      // 有环,快慢指针会相遇
      if (slow == fast) {
        return true;
      }
    }
  }
}
