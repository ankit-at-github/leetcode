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
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while(current != null)
        {
            if(current.left != null)
            {
                TreeNode rightMostNode = current.left;
                while(rightMostNode.right != null)
                {
                    rightMostNode = rightMostNode.right;
                }
                rightMostNode.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}