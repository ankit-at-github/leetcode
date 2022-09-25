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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode prev = null;
        ListNode first = head;
        ListNode second = first.next;
        head = head.next;
        while(first!=null && second!=null)
        {
            first.next = second.next;
            second.next = first;
            if(prev!=null) prev.next = second;
            prev = first;
            first = first.next;
            if(first!=null) second = first.next;
        }
        return head;
    }
}