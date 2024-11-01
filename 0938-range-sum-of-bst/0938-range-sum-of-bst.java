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
        int[] total = new int[1];
        getSum(root, low, high, total);
        return total[0];
    }
    public void getSum(TreeNode root, int low, int high, int[] total){
        if(root == null) return;
        
        if(root.val >= low && root.val <= high) total[0]+=root.val;
        
        if(root.val > low)
            getSum(root.left, low, high, total);
        if(root.val < high)
            getSum(root.right, low, high, total);
    }
}