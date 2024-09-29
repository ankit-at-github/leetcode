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
    //do tree traversal and see if value is same for that node in both trees
    //null check
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }
    public boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}