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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f=head, s=head, prev = null;
        for(int i=1; i<n;i++) {
            f = f.next;
        }

        while( f.next != null) {
            prev = s;
            s = s.next;
            f = f.next;
        }


        if(s == head) {
            head = head.next;
        } else {
            prev.next = s.next;
        }
        return head;


        
    }
}
