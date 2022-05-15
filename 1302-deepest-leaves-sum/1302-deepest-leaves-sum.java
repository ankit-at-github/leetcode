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
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        
        if(root.left == null && root.right == null) return root.val;
        
        int maxDepth = getHeight(root);
        
        getSum(root, maxDepth);
        
        return sum;
    }
    public int getHeight(TreeNode root)
    {
        if(root == null) return 0;
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
    }
    public void getSum(TreeNode root, int d)
    {
        if(root == null) return;
        
        if(root.left == null && root.right == null && d==1) sum+=root.val;
        getSum(root.left, d-1);
        getSum(root.right, d-1);
    }
}