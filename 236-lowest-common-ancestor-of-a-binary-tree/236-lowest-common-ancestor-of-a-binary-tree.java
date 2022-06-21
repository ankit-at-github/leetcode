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
        return getLCA(root, p, q);
    }
    public TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return null;
        
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = getLCA(root.left, p, q);
        TreeNode right = getLCA(root.right, p, q);
        
        if(left == null) return right;
        if(right == null) return left;
        
        return root;
    }
}