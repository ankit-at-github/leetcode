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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        
        if(root == null) return zigzag;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 1;
        while(!q.isEmpty())
        {
            List<Integer> l = new ArrayList<>();
            for(int i=q.size(); i>0; i--)
            {
                TreeNode current = q.poll();
                
                if(level%2==0) l.add(0, current.val);
                else l.add(current.val);
                
                if(current.left!=null) q.add(current.left);
                if(current.right!=null) q.add(current.right);
            }
            zigzag.add(l);
            level++;
        }
        return zigzag;
    }
}