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
        
        Node dummy = head;
        //1. Iterate the original list and duplicate each node.
        while(dummy != null){
            Node newNode = new Node(dummy.val);
            newNode.next = dummy.next;
            dummy.next = newNode;
            dummy = newNode.next;
        }
        
        dummy = head;
        
        //2. Link random pointers of the new node created
        while(dummy != null){
            if(dummy.random != null){
                dummy.next.random = dummy.random.next;
            }
            dummy = dummy.next.next;
        }
        
        //3. Restore original list
        Node newHead = head.next;
        Node dummy2 = head.next;
        dummy = head;
        while(dummy != null){
            dummy.next = dummy.next.next;
            dummy2.next = dummy2.next != null ? dummy.next.next : null;
            dummy = dummy.next;
            dummy2 = dummy2.next;
        }
        return newHead;
    }
}