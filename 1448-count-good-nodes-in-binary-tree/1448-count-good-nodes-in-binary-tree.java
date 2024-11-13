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
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        good(root, root.val, ans);
        return ans[0];
    }
    public void good(TreeNode root, int prevVal, int[] ans){
        if(root == null) return;
        
        if(root.val >= prevVal) ans[0]++;
        
        prevVal = Math.max(prevVal, root.val);
        
        good(root.left, prevVal, ans);
        good(root.right, prevVal, ans);
    }
}