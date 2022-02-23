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
    public int getMaxSum(TreeNode root, int[] pathSum)
    {
        if(root == null) return 0;
        
        int left = Math.max(0, getMaxSum(root.left, pathSum));
        int right = Math.max(0, getMaxSum(root.right, pathSum));
        
        pathSum[0] = Math.max(pathSum[0], left+root.val+right);
        
        return root.val + Math.max(left, right);
        
    }
    public int maxPathSum(TreeNode root) {
        int[] pathSum = new int[1];
        
        pathSum[0] = Integer.MIN_VALUE;
        getMaxSum(root, pathSum);
        
        return pathSum[0];
    }
}