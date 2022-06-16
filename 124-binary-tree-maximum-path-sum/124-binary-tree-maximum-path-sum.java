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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxSum;
    }
    public int getSum(TreeNode root)
    {
        if(root == null) return 0;
        
        int left = Math.max(getSum(root.left),0);
        int right = Math.max(getSum(root.right),0);
        
       // System.out.println("Root"+root.val+"Left:"+left+"Right"+right);
        int sum = left+right+root.val;
        //System.out.println("Sum"+sum);
        
        maxSum = Math.max(maxSum, sum);
        
        if(sum > maxSum) return sum;
        
        return root.val+Math.max(left,right);
    }
}