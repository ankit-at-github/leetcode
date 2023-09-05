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
        Map<Node, Node> map = new HashMap<>();
        Node newHead = null;
        Node temp = head;
        int count = 1;
        while(temp != null)
        {
            Node current = new Node(temp.val);
            if(count == 1) newHead = current;
            map.put(temp, current);
            temp = temp.next;
            count++;
        }
        temp = head;
        while(temp != null)
        {
            if(temp.next != null) map.get(temp).next = map.get(temp.next);
            if(temp.random != null) map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return newHead;
    }
}