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
    private int sum;
    public void preorder(TreeNode root, boolean isLeft)
    {
        if(root==null) return;
        
        if(isLeft && root.left==null && root.right==null)
            sum+=root.val;
       
        
        preorder(root.left, true);
        preorder(root.right, false);
        
    }
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        preorder(root, false);
        return sum;
    }
}