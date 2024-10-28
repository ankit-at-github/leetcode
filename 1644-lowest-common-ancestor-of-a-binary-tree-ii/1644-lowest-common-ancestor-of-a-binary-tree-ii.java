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
        TreeNode lca = LCA(root, p, q);
        if(lca == p){
            //looking for q only
            return LCA(p, q, q) == q ? lca : null;
        }
        else if(lca == q){
            //looking for p only
            return LCA(q, p, p) == p ? lca : null;
        }
        else return lca;
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}