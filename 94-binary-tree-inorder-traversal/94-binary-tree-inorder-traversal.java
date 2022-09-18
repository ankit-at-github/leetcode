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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        TreeNode current = root;
        while(current != null)
        {
            if(current.left == null)
            {
                ans.add(current.val);
                current = current.right;
            }
            else
            {
                TreeNode rightMostNode = current.left;
                while(rightMostNode.right != null && rightMostNode.right != current)
                {
                    rightMostNode = rightMostNode.right;
                }
                if(rightMostNode.right == null)
                {
                    rightMostNode.right = current;
                    current = current.left;
                }
                else
                {
                    rightMostNode.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }
        return ans;
    }
}