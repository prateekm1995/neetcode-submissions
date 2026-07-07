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
    public ListNode reverseList(ListNode head) {
        return reverse(head);

    }

    private ListNode reverse(ListNode cur) {
        if(cur == null || cur.next == null ){
            return cur;
        }
        ListNode h = reverse(cur.next);
        cur.next.next = cur;
        cur.next = null;
        return h;        
    }
}
