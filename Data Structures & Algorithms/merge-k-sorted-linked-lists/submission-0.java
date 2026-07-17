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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        //create inital heap
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(int i = 0 ; i < lists.length ; i++) {
            heap.offer(lists[i]);
        }

        //merge
        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummy.next;
    }
}
