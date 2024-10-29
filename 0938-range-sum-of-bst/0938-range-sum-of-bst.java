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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int[] total = new int[1];
        getRangeSum(root, low, high, total);
        return total[0];
    }
    public void getRangeSum(TreeNode root, int low, int high, int[] total){
        if(root == null) return;
        
        if(root.val >= low && root.val <= high) total[0]+=root.val;
        
        if(root.val >= low)
            getRangeSum(root.left, low, high, total);
        if(root.val <= high)
            getRangeSum(root.right, low, high, total);
    }
}