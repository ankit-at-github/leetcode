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
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, Integer.MIN_VALUE));
        
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                Pair p = q.poll();
                
                int previous = p.prev;
                
                if(p.node.val >= previous) count++;
                
                if(p.node.left != null) q.add(new Pair(p.node.left, Math.max(previous, p.node.val)));
                if(p.node.right != null) q.add(new Pair(p.node.right, Math.max(previous, p.node.val)));
            }
        }
        
        return count;
    }
}
class Pair{
    TreeNode node;
    int prev;
    Pair(TreeNode _node, int _prev)
    {
        node = _node;
        prev = _prev;
    }
}