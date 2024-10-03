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
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        mps(root, ans);
        return ans[0];
    }
    public int mps(TreeNode root, int[] ans){
        if(root == null) return 0;
        
        int left = mps(root.left, ans);
        int right = mps(root.right, ans);
        
        //If splitting on a node, calculating path sum
        ans[0] = Math.max(ans[0], root.val + left + right);
        
        return Math.max(root.val + Math.max(left, right), 0);
    }
}