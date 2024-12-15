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
        //interleaving of old node and new node [A->A'->B->B'->null]
        //1. Copy and interleaving of old nodes with new nodes
        Node oldNode = head;
        while(oldNode != null){
            Node copyNode = new Node(oldNode.val);
            copyNode.next = oldNode.next;
            oldNode.next = copyNode;
            oldNode = copyNode.next;
        }
        //2. Link Random Pointer of new node created
        oldNode = head;
        while(oldNode != null){
            if(oldNode.random != null){
                oldNode.next.random = oldNode.random.next;
            }
            oldNode = oldNode.next.next;
        }
        //3. Restore Original List
        Node head2 = head.next;
        Node dummy = head2;
        oldNode = head;
        while(head2.next != null){
            oldNode.next = head2.next;
            oldNode = oldNode.next;
            head2.next = head2.next.next;
            head2 = head2.next;
        }
        oldNode.next = null;
        return dummy;
    }
}