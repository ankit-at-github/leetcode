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
        if(head == null || head.next == null || left==right) return head;
        
        ListNode temp = head;
        ListNode prevStart = null;
        ListNode start = null;
        ListNode end = null;
        while(temp!=null)
        {
            if(left-- > 0)
            {
                prevStart = start;
                start = temp;
            }
            
            if(right-- > 0) end = temp;
            
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
        ListNode current = start.next;
        while(start!=end)
        {
            start.next = prev;
            prev = start;
            start = current;
            current = current.next;
        }
        start.next = prev;
        return start;
    }
}