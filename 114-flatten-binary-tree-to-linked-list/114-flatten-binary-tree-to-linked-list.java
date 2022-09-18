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
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(root!=null && !st.isEmpty())
        {
            TreeNode current = st.pop();
            
            if(current.right!=null) st.push(current.right);
            if(current.left!=null) st.push(current.left);
            
            if(st.isEmpty()) break;
            
            current.right = st.peek();
            current.left = null;
        }
    }
}