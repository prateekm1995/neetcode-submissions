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
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> heads = new ArrayList<>();
        ListNode cur = head, prev = null;
        int n=0;
        for(ListNode p = head; p != null ; p = p.next) {
            n++;
        }
        int gc = n/k;

        for(int i=1 ; i <= gc ; i++) {
            for(int j=1; j <= k ; j++) {
                ListNode next= cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            heads.add(prev);
            prev = null;
        }
        heads.add(cur);

        for(int i=0 ; i< heads.size()-1 ; i++) {
            ListNode p = heads.get(i);
            while(p.next != null) {
                p = p.next;
            }
            p.next = heads.get(i+1);
        }

        return heads.get(0);

        
    }
}
