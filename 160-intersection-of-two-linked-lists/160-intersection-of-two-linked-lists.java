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
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        while(ptrA!=ptrB)
        {
            ptrA = ptrA==null?headA:ptrA.next;
            ptrB = ptrB==null?headB:ptrB.next;
        }
        return ptrA;
    }
}