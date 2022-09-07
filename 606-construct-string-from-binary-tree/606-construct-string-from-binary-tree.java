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
    public String tree2str(TreeNode root) {
        return preOrder(root);
    }
    public String preOrder(TreeNode root)
    {
        if(root == null) return "";
        
        if(root.left == null && root.right == null) return root.val+"";
        
        if(root.right == null) return root.val+"("+preOrder(root.left)+")";
        
        return root.val+"("+preOrder(root.left)+")("+preOrder(root.right)+")";
    }
}