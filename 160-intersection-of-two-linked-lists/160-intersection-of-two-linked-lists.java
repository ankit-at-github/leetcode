/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> address = new HashSet<>();
        
        while(headA!=null)
        {
            address.add(headA);
            headA = headA.next;
        }
        
        while(headB!=null)
        {
            if(address.contains(headB)) return headB;
            else address.add(headB);
            headB = headB.next;
        }
        return null;
    }
}