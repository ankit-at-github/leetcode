/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node head1 = new Node(-1);
    Node dummy = head1;
    public Node flatten(Node head) {
        //Node dummy = head;
        if(head == null) return head;
        flat(head);
        Node temp = dummy.next;
        dummy.next.prev = null;
        return temp;
    }
    public Node flat(Node head)
    {
        if(head == null) return null;
        
        //Node prev = head1;
        Node current = new Node(head.val);
        head1.next = current;
        current.prev = head1;
        head1 = current;
        
        if(head.child!=null)
        {
            Node temp = head.next;
            head.next = flat(head.child);
            head.child = null;
            head.next = temp;
        }
        head.next = flat(head.next);
        return head;
    }
}