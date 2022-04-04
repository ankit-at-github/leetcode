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
        int totalNode = 0;
        List<Integer> l = new ArrayList<>();
        while(head!=null)
        {
            totalNode++; 
            l.add(head.val);
            head = head.next;
        }
        
        int temp = l.get(k-1);
        int value = l.get(totalNode-k);
        l.set(k-1, value);
        l.set(totalNode-k, temp);
        
        ListNode current = new ListNode(l.get(0));
        head = current;
        ListNode dummy = head;
        for(int i=1; i<l.size(); i++)
        {
            current = new ListNode(l.get(i));
            dummy.next = current;
            dummy = current;
        }
        
        return head;
    }
}