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
        int count = 0;
        ListNode temp = head;
        while(count < k && temp!=null)
        {
            temp = temp.next;
            count++;
        }
        
        if(count == k)
        {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;
            int count2 = 0;
            while(curr!=null && count2 < k)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count2++;
            }
            
            head.next = reverseKGroup(next, k);
            
            return prev;
            
        }
        
        return head;
        
    }
}