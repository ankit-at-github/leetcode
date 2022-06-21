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
        
        int n = 1;
        ListNode tail = head;
        while(tail.next!=null)
        {
            tail = tail.next;
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
        
        tail.next = head;
        head = start.next;
        start.next = null;
        
        return head;
    }
}