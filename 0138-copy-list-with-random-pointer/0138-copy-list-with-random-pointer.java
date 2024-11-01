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
        Node oldNode = head;
        //mapping oldNode with newNode in hashmap
        while(oldNode != null){
            Node newNode = new Node(oldNode.val);
            map.put(oldNode, newNode);
            oldNode = oldNode.next;
        }
        Node newHead = map.get(head);
        oldNode = newHead;
        while(head != null){
            oldNode.next = map.get(head.next);
            oldNode.random = map.get(head.random);
            oldNode = oldNode.next;
            head = head.next;
        }
        return newHead;
    }
}