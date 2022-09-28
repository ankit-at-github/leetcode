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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;
        while(temp!=null)
        {
            length++;
            temp = temp.next;
        }
        if(length - n == 0) return head.next;
        
        recursion(head, length - n);
        
        return head;
    }
    public void recursion(ListNode head, int remove)
    {
        if(head == null) return;
        
        recursion(head.next, remove-1);
        
        if(remove == 1) head.next = head.next.next;
        
    }
}