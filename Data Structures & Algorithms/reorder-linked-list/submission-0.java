/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);

        ListNode p1 = head, p2 = head2;

        while(p1 != null && p2 != null) {
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;

            p1.next = p2;
            p2.next = n1;
            p1 = n1;
            p2 = n2;
        }

        
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head, prev = null;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
