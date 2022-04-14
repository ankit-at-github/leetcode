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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        return preOrder(root, val);
    }
    public TreeNode preOrder(TreeNode root, int val)
    {
        if(root == null) return null;
        if(root.val == val) return root;
        if(val < root.val) return preOrder(root.left, val);
        else return preOrder(root.right, val);
    }
}