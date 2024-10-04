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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        insert(null, root, val, -1);
        return root;
    }                 
    public void insert(TreeNode prev, TreeNode root, int val, int dir){ 
        if(root == null){
            if(dir == 1) prev.right = new TreeNode(val);
            else prev.left = new TreeNode(val);
            return;
        }
        if(val < root.val) insert(root, root.left, val, 0);
        else insert(root, root.right, val, 1);
    }
}