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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        
        int n = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            temp = temp.next;
            n++;
        }
        
        k = k%n;
        
        if(k==0) return head;
        n = n-k;
        
        ListNode start = head;
        while(n > 1)
        {
            start = start.next;
            n--;
        }
        
        ListNode shift = start.next;
        start.next = null;
        
        temp = shift;
        while(temp.next!=null) temp = temp.next;
        
        temp.next = head;
        head = shift;
        
        return head;
    }
}