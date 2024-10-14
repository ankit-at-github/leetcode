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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        diameter(root, d);
        return d[0];
    }
    public void diameter(TreeNode root, int[] d){
        if(root == null) return;
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        d[0] = Math.max(d[0], left+right);
        
        diameter(root.left, d);
        diameter(root.right, d);
        
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}