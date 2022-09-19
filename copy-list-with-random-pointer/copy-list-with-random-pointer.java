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
        return COPY(head, new HashMap<>());
    }
    public Node COPY(Node head, Map<Node, Node> visitedNode)
    {
        if(head == null) return null;
        
        if(visitedNode.containsKey(head)) return visitedNode.get(head);
        
        Node current = new Node(head.val);
        
        visitedNode.put(head, current);
        
        current.next = COPY(head.next, visitedNode);
        current.random = COPY(head.random, visitedNode);
        
        return current;
    }
}