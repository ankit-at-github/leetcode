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
        int count = 0;
        while(root!=null || !st.isEmpty())
        {
            if(root!=null)
            {
                st.push(root);
                root = root.left;
            }
            else
            {
                root = st.pop();
                if(--k == 0) return root.val;
                root = root.right;
            }
        }
        return -1;
        
    }
}