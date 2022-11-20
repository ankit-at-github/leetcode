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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        
        count-=n;
        if(count == 0) return head.next;
        
        ListNode remove = head;
        while(count-- > 1) remove = remove.next;
        remove.next = remove.next.next;
        return head;
    }
}