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
    public ListNode deleteMiddle(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp!=null){n++;temp = temp.next;}
        n/=2;
        temp=head;
        while(n > 1){temp=temp.next;n--;}
        if(temp.next == null) return null;
        temp.next = temp.next.next;
        return head;
    }
}