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
    public boolean isSame(TreeNode p, TreeNode q){
        
        if(p==null && q==null) return true;
        
        if(p==null || q==null) return false;
        else
        {
            return (p.val==q.val) && isSame(p.left, q.left) && isSame(p.right, q.right);
        }
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }
}