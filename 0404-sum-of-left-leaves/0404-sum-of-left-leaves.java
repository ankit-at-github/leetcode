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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                TreeNode current = q.poll();
                if(current.left!=null)
                {
                    if(current.left.left == null && current.left.right==null) sum+=current.left.val;
                    q.add(current.left);
                }
                if(current.right!=null) q.add(current.right);
            }
        }
        return sum;
    }
}