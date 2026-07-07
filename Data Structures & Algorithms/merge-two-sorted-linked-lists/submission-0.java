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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;

        if(list1 == null){
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode result = list1.val <= list2.val ? list1 : list2;
        p1 = result;
        p2 = list1.val <= list2.val ? list2 : list1;

        while(p1.next != null) {
            if(p2.val < p1.next.val) {
                ListNode temp = p1.next;
                p1.next = p2;
                p2 = temp;
            }
            p1 = p1.next;
        }
        if(p1.next == null) {
            p1.next = p2;
        }
        return result;
    }
}