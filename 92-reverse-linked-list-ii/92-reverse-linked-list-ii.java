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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        
        ListNode prevStart = null;
        ListNode start = null;
        ListNode end = null;
        
        ListNode temp = head;
        while(temp!=null)
        {
            if(left > 0)
            {
                prevStart = start;
                start = temp;
                left--;
            }
            if(right > 0)
            {
                end = temp;
                right--;
            }
            temp = temp.next;
        }
        ListNode newHead = reverse(start, end);
        if(prevStart!=null)
        {
            prevStart.next = newHead;
            return head;
        }
        
        return newHead;
    }
    public ListNode reverse(ListNode start, ListNode end)
    {
        ListNode prev = end.next;
        ListNode next = start;
        while(start!=end)
        {
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        start.next = prev;
        return start;
    }
}