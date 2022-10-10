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
        //Iterative Approach
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode next = head.next;
        while(next!=null)
        {
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }
        head.next = prev;
        prev = head;
        return prev;
    }
}