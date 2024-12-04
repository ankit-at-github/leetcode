/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == p || root == q || root == null) return root;
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}