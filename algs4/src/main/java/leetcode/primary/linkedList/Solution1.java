package leetcode.primary.linkedList;

import java.util.LinkedList;

/**
 * Author: lsf Time: 9/14/20-10:16 AM
 */
public class Solution1 {
  LinkedList<ListNode> head;
  public void deleteNode(ListNode node) {
    ListNode t = head.get(0);
    // 空节点 or 单节点
    if (t == null || t.next == null) {
      if (node == t) {
        t = null;
      }
      return;
    }
    ListNode pre = t;
    ListNode target = pre.next;
    while (target != null) {
      if (target == node) {
        pre.next = target.next;
      } else {
        pre = target;
        target = target.next;
      }
    }
  }
}
