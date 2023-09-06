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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int linkedListLength = 0;
        ListNode temp = head;
        while(temp != null)
        {
            linkedListLength++;
            temp = temp.next;
        }
        int partLength = linkedListLength/k;
        int extraNodes = linkedListLength%k;
        ListNode[] ans = new ListNode[k];
        temp = head;
        //This is true for all case - Every part has length/k elements except first length%k parts have an extra one element
        ListNode prev = null;
        for(int i=0; i<ans.length && temp!=null; i++)
        {
            //Starting each part from this node value
            ans[i] = temp;
            for(int j=0; j<partLength + (extraNodes > 0 ? 1 : 0); j++)
            {
                //moving pointer to part-break position
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            extraNodes--;
        }
        return ans;
    }
}