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
        TreeNode lca =  LCA(root, p, q);
        if(search(lca, p.val) && search(lca, q.val)) return lca;
        else return null;
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
    public boolean search(TreeNode root, int key){
        if(root == null) return false;
        if(root.val == key) return true;
        boolean left = search(root.left, key);
        boolean right = search(root.right, key);
        return (left || right);
    }
}