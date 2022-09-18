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
        Map<Node, Node> map = new HashMap<>();
        Node dummy = head;
        while(dummy!=null)
        {
            map.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }
        dummy = map.get(head);
        Node newHead = dummy;
        while(head!=null)
        {
            dummy.next = map.get(head.next);
            dummy.random = map.get(head.random);
            dummy = dummy.next;
            head = head.next;
        }
        return newHead;
    }
}