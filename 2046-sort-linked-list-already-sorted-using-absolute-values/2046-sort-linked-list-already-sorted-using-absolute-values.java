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
    public ListNode sortLinkedList(ListNode head) {
        
            
        ListNode prev = head;
        ListNode temp = head;
        
        if(temp.val < 0) temp = temp.next;
        
        while(temp!=null)
        {
            if(temp.val < 0)
            {
                prev.next = temp.next;
                temp.next = head;
                head = temp;
                temp = prev;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}