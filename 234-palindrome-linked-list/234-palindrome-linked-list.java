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
        //doing it in constatnt time requires 2-3 steps.
        
        //1. getting to middle of the linked list using slow and fast pointer logic
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //2. Reversing the 2nd half
        fast = slow.next;
        slow = reverse(slow, fast);
        
        //Final Check
        
        while(head!=null && slow!=null)
        {
            if(head.val!=slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode slow, ListNode fast)
    {
        ListNode prev = null;
        while(fast!=null)
        {
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }
        slow.next = prev;
        return slow;
    }
}