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
        Map<Node, Node> hmap = new HashMap<>();
        Node temp = head;
        Node newHead = null;
        int count = 1;
        while(temp!=null)
        {
            Node current = new Node(temp.val);
            if(count == 1) newHead = current;
            hmap.put(temp, current);
            temp = temp.next;
            count++;
        }
        temp = head;
        while(temp!=null)
        {
            if(temp.next!=null) hmap.get(temp).next = hmap.get(temp.next);
            if(temp.random!=null) hmap.get(temp).random = hmap.get(temp.random);
            temp = temp.next;
        }
        return newHead;
    }
}