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
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        int carry = 0;
        while(ptr1!=null || ptr2!=null)
        {
            //basically of one of them reaches end there is nothing to add from that list so add 0 won't make difference.
            int a = ptr1==null?0:ptr1.val;
            int b = ptr2==null?0:ptr2.val;
            
            int sum = a+b+carry;
            
            ListNode current = new ListNode(sum%10);
            dummy.next = current;
            dummy = current;
            
            if(sum > 9) carry = 1;
            else carry = 0;
            
            if(ptr1!=null) ptr1 = ptr1.next;
            if(ptr2!=null) ptr2 = ptr2.next;
        }
        
        if(carry == 1) dummy.next = new ListNode(1);
        
        return temp.next;
    }
}