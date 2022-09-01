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
    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }
    public int count(TreeNode root, int maxi)
    {
        if(root == null) return 0;
        
        int res = root.val>=maxi?1:0;
        res+=count(root.left, Math.max(maxi, root.val));
        res+=count(root.right, Math.max(maxi, root.val));
        return res;
    }
}