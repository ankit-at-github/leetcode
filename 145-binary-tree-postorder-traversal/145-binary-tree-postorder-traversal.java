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
    public List<Integer> postorderTraversal(TreeNode root) {
        //Using 2 Stacks
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st1 = new Stack<>();
        st1.push(root);
        
        while(!st1.isEmpty())
        {
            TreeNode curr = st1.pop();
            ans.add(0, curr.val);
            
            if(curr.left!=null) st1.push(curr.left);
            if(curr.right!=null) st1.push(curr.right);
        }
        
        return ans;
    }
}