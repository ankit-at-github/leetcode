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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty())
        {
            while(curr!=null)
            {
                st.push(curr);
                ans.add(curr.val);
                curr = curr.left;
            }
            
            curr = st.pop();
            curr = curr.right;
        }
        return ans;
    }
}