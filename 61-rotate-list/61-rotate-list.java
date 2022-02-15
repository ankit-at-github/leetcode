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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int n = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            n++;
            temp = temp.next;
        }
        
        
        k = k%n;
        
        if(k==0) return head;
        
        k = n - k;
        
        temp = head;
        ListNode prev = head;
        //System.out.println(k);
        while(k!=0)
        {
            prev = temp;
            temp = temp.next;
            k--;
        }
        
        prev.next = null;
        prev = temp;
        
        while(temp.next!=null) temp = temp.next;
        
        temp.next = head;
        
        return prev;
        
    }
}