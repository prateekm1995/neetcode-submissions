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
       if(head == null || head.next == null) {
        return;
       } 
       // find mid
       ListNode slow=head, fast = head.next;
       while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
       }
        //reverse second half
       ListNode l1 = head, l2 = slow.next;
       slow.next = null;
       l2 = reverse(l2);

       while(l2 != null) {
        ListNode n1 = l1.next;
        ListNode n2 = l2.next;
        l1.next = l2;
        l2.next = n1;
        l1 = n1;
        l2 = n2;
       }

    }

    private ListNode reverse(ListNode head) {
        ListNode prev=null, cur= head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
