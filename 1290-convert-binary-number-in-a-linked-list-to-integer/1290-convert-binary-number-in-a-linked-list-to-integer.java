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
    public int getDecimalValue(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while(head!=null)
        {
            l.add(head.val);
            head = head.next;
        }
        
        int size = l.size()-1;
        int sum = 0;
        for(int i=0; i<l.size(); i++)
        {
            sum+=(l.get(i)*Math.pow(2,size));
            size--;
        }
        return sum;
    }
}