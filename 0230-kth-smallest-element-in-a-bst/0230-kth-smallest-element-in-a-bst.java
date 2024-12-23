/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
       //iterative in-order traversal
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        while(!st.isEmpty() || current != null){
            while(current != null){
                st.push(current);
                current = current.left;
            }
            current = st.pop();
            if(k-- == 1) return current.val;
            current = current.right;
        }
        return -1;
    }
}