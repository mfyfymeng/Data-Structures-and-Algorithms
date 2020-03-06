package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */

public class _203_移除链表元素 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode sentinel = new ListNode(0);
            sentinel.next = head;

            ListNode prev = sentinel;
            ListNode curr = head;

            while (curr != null) {
                if (curr.val == val)
                    prev.next = curr.next;
                else
                    prev = curr;

                curr = curr.next;
            }

            return sentinel.next;
        }
    }
}
