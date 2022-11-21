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
    public int diameterOfBinaryTree(TreeNode root) {
        //diameter may or may not pass from root
        int[] diameter = new int[1];
        maxDiameter(root, diameter);
        return diameter[0];
    }
    public int maxDiameter(TreeNode root, int[] diameter)
    {
        if(root == null) return 0;
        
        int left = maxDiameter(root.left, diameter);
        int right = maxDiameter(root.right, diameter);
        
        diameter[0] = Math.max(diameter[0], left+right);
        
        return 1+Math.max(left, right);
    }
}