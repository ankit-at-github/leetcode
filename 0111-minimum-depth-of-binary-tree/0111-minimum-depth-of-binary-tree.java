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
    public int minDepth(TreeNode root) {
        return minD(root);
    }
    public int minD(TreeNode root)
    {   
        if(root==null) return 0;
        
        if(root.left == null) return 1 + minD(root.right);
        if(root.right == null) return 1 + minD(root.left);
        
        return 1+Math.min(minD(root.left),minD(root.right));
        
    }
}