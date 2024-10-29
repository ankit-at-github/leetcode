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
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node dummy = head;
        while(dummy != null){
            Node node = new Node(dummy.val);
            map.put(dummy, node);
            dummy = dummy.next;
        }
        Node newHead = map.get(head);
        dummy = newHead;
        while(head != null){
            dummy.next = map.get(head.next);
            dummy.random = map.get(head.random);
            dummy = dummy.next;
            head = head.next;
        }
        return newHead;
    }
}