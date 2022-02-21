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
    public int getHeight(TreeNode root)
    {
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    public boolean check(TreeNode root)
    {
        if(root==null) return true;
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        if(Math.abs(left-right) > 1) return false;
        
        boolean l = check(root.left);
        boolean r = check(root.right);
        
        if(l==false || r==false) return false;
        
        return true;
        
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return check(root);
    }
}