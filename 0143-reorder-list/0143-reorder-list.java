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
    public void reorderList(ListNode head) {
        //3 Concepts
        
        //1. Finding mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //2. Reverse right half(slow)
        ListNode p = reverse(slow);
        
        //3. Merge two sorted list
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        while(p != null && temp != p){
            dummy.next = temp;
            temp = temp.next;
            dummy = dummy.next;
            dummy.next = p;
            dummy = dummy.next;
            p = p.next;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode nxt = head;
        while(head != null){
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }
}