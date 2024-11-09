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
    public Node insert(Node head, int val) {
    Node node = new Node(val);
    if (head == null) {
        node.next = node;
        return node;
    }
	
    Node cur = head;
    while (cur.next != head) {
        if (cur.val <= val && val <= cur.next.val) break;
        if (cur.val > cur.next.val && (cur.val < val || val < cur.next.val)) break;
        cur = cur.next;
    }

    node.next = cur.next;
    cur.next = node;
    return head;
}
}

