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
        if(head == null) return head;
        else if(left==right) return head;
        
        int count = 1;
        ListNode prevLeft = null;
        ListNode leftNode = head;
        ListNode rightNode = head;
        while(count!=right)
        {
            if(count<left)
            {
                prevLeft = leftNode;
                leftNode = leftNode.next;
            }
            rightNode = rightNode.next;
            count++;
        }
        
        //Reverse a linkedlist
        ListNode prev = rightNode.next;
        ListNode current = leftNode;
        ListNode nxt = current.next;
        while(nxt!=rightNode.next)
        {
            current.next = prev;
            prev = current;
            current = nxt;
            nxt = nxt.next;
        }
        current.next = prev;
        prev = current;
        
        if(left==1) return prev;
        else
        {
            prevLeft.next = prev;
            return head;
        }  
    }
}