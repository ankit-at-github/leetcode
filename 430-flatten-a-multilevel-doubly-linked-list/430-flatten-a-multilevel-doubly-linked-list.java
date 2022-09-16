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
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node p = head;
        while(p!=null)
        {
            if(p.child!=null)
            {
                Node right = p.next;
                p.next = flatten(p.child);
                p.next.prev = p;
                p.child = null;
                
                //take p to last value to connect it with right part
                
                while(p.next!=null) p = p.next;
                
                if(right!=null)
                {
                    p.next = right;
                    p.next.prev = p;
                    p = p.next;
                }
            }
            p = p.next;
        }
        return head;
    }
}