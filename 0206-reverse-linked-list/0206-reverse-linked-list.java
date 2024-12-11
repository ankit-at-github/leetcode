/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        
        ListNode prev = null;
        ListNode current = head;
        ListNode nxt = current;
        while(current != null){
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }
        return prev;
    }
}