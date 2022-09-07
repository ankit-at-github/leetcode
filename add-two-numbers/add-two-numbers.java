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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        int carry = 0;
        while(l1!=null || l2!=null)
        {
            int a = l1==null?0:l1.val;
            int b = l2==null?0:l2.val;
            
            int total = a + b + carry;
            ListNode current = new ListNode(total%10);
            dummy.next = current;
            dummy = current;
            
            if(total > 9) carry = 1;
            else carry = 0;
            
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry!=0) dummy.next = new ListNode(1);
        return head.next;
    }
}