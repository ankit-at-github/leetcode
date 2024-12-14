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
        Node temp = head;
        while(temp != null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        Node head2 = map.get(head);
        temp = head2;
        while(head != null){
            if(map.containsKey(head.next)){
                head2.next = map.get(head.next);
            }
            if(map.containsKey(head.random)){
                head2.random = map.get(head.random);
            }
            head = head.next;
            head2 = head2.next;
        }
        return temp;
    }
}