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
        ListNode temp = head;
        while(temp!=null)
        {
            temp = temp.next;
            count++;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev= dummy;
        ListNode curr = head;
        ListNode next = head.next;
        
       while(count>=k)
       {
           for(int i=1; i<k; i++)
           {
               curr.next = next.next;
               next.next = prev.next;
               prev.next = next;
               next = curr.next;
           }
           count-=k;
           prev = curr;
           curr = next;
           if(next!=null) next = next.next;
       }
        return dummy.next;
    }
}