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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k==1) return head;
        
        int count = 0;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev= dummy;
        ListNode curr = dummy;
        ListNode next = dummy;
        
        while(curr.next!=null)
        {
            curr = curr.next;
            count++;
        }
    
       while(count>=k)
       {
           curr = prev.next;
           next = curr.next;
           for(int i=1; i<k; i++)
           {
               curr.next = next.next;
               next.next = prev.next;
               prev.next = next;
               next = curr.next;
           }
           count-=k;
           prev = curr;
       }
        return dummy.next;
    }
}