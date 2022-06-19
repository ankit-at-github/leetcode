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
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(l1!=null && l2!=null)
        {
            int sum = l1.val + l2.val + carry;
            
            ListNode current = new ListNode(sum%10);
            dummy.next = current;
            dummy = current;
            
            if(sum > 9) carry = 1;
            else carry = 0;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null)
        {
            if(l1.val == 9 && carry == 1)
            {
                l1.val = 0;
                dummy.next = l1;
                dummy = l1;
            }
            else
            {
                l1.val = l1.val+carry;
                dummy.next = l1;
                carry = 0;
                break;
            }
            l1 = l1.next;
        }
        while(l2!=null)
        {
            if(l2.val == 9 && carry == 1)
            {
                l2.val = 0;
                dummy.next = l2;
                dummy = l2;
            }
            else
            {
                l2.val = l2.val+carry;
                dummy.next = l2;
                carry = 0;
                break;
            }
            l2 = l2.next;
        }
        if(carry != 0)
        {
            ListNode current = new ListNode(1);
            dummy.next = current;
            return temp.next;
        }
        return temp.next;
    }
}