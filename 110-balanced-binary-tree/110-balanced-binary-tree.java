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
    public int heightHelper(TreeNode root)
    {
        if(root == null) return 0;
        
        int left = heightHelper(root.left);
        int right = heightHelper(root.right);
        
        if(left == -1 || right == -1) return -1;
        
        if(Math.abs(left-right) > 1) return -1;
        
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return heightHelper(root) != -1;
    }
}