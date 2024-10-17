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
        Node dummyNode = head;
        while(dummyNode != null){
            map.put(dummyNode, new Node(dummyNode.val));
            dummyNode = dummyNode.next;
        }
        dummyNode = map.get(head);
        Node newHead = dummyNode;
        while(head != null){
            dummyNode.next = map.get(head.next);
            dummyNode.random = map.get(head.random);
            dummyNode = dummyNode.next;
            head = head.next;
        }
        return newHead;
    }
}