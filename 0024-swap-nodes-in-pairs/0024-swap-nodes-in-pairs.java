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
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(head!=null && head.next!=null)
        {
            ListNode first = head;
            ListNode second = head.next;
            
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }
}