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
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return checkBST(root, min, max);
    }
    public boolean checkBST(TreeNode root, long min, long max)
    {
        if(root == null) return true;
        
        if(root.val <= min || root.val >= max) return false;
        
        boolean left = checkBST(root.left, min, root.val);
        boolean right = checkBST(root.right, root.val, max);
        
        if(left == false || right == false) return false;
        
        return true;
    }
}