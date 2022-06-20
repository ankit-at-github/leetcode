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
    public boolean isPalindrome(ListNode head) {
        //Find middle
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //Reverse Mid
        ListNode prev = null;
        ListNode next = null;
        while(slow!=null)
        {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        //Check
        while(prev!=null && head!=null)
        {
            if(head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }
        
        return true;
    }
    
}