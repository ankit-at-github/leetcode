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
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 1;
        int maxi = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty())
        {
            int sum = 0;
            for(int i=q.size(); i>0; i--)
            {
                TreeNode current = q.poll();
                sum+=current.val;
                if(current.left!=null) q.add(current.left);
                if(current.right!=null) q.add(current.right);
            }
            if(sum > maxi)
            {
                maxi = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}