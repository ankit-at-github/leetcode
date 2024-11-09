/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        Node current = head;
        while(current.next != head){
                //Value is in between currentNode and nextNode
                if(current.val <= insertVal && insertVal <= current.next.val) break;
                //Value is larger than all node or Value is smaller than all node
                if(current.val > current.next.val && (current.val < insertVal || insertVal < current.next.val)) break;
                current = current.next;
            }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }
}