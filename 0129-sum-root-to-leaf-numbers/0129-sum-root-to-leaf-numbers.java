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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        getSum(root, 0);
        return total;
    }
    public void getSum(TreeNode root, int currentVal){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            currentVal = currentVal*10 + root.val;
            total+=currentVal;
        }
        
        getSum(root.left, currentVal*10 + root.val);
        getSum(root.right, currentVal*10 + root.val);
        
    }
}