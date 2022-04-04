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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(k-1 > 0)
        {
            fast = fast.next;
            k--;
        }
        
        ListNode left = fast;
        
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        swap(left, slow);
        
        return head;
    }
    
    public void swap(ListNode node1, ListNode node2)
    {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    
}