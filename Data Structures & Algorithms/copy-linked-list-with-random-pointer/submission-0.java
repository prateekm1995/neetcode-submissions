/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node old = head, chead = null, p=null;

        HashMap<Node, Node> map = new HashMap();

        while( old  != null) {
            Node copy = new Node(old.val);

            if(chead == null) {
                chead = copy;
            }

            if(p != null) {
                p.next = copy;
            }

            p = copy;
            map.put(old, copy);
            old = old.next;
        }

        map.entrySet().forEach(entry -> {
            if(entry.getKey().random == null) {
                entry.getValue().random = null;
            } else {
                entry.getValue().random = map.get(entry.getKey().random);
            }
        });
        return chead;

    }
}
