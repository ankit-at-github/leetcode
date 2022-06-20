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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return check(root, targetSum);
    }
    public boolean check(TreeNode root, int target)
    {   
        if(root == null) return false;
        
        if(root.left == null && root.right == null)
        {
            if(target-root.val == 0) return true;
            else return false;
        }
        
        return check(root.left, target-root.val) || check(root.right, target-root.val);
    }
}