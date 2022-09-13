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
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while(l1!=null)
        {
            st1.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null)
        {
            st2.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!st1.isEmpty() || !st2.isEmpty())
        {
            int a = st1.isEmpty()?0:st1.pop();
            int b = st2.isEmpty()?0:st2.pop();
            int total = a+b+carry;
            if(total > 9) carry = 1;
            else carry = 0;
            ListNode current = new ListNode(total%10);
            dummy.next = current;
            dummy = current;
        }
        if(carry == 1)
        {
            dummy.next = new ListNode(1);
        }
        return reverse(head.next);
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode current = head.next;
        while(current!=null)
        {
            head.next = prev;
            prev = head;
            head = current;
            current = current.next;
        }
        head.next = prev;
        prev = head;
        return prev;
    }
}