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
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode _node, int _index)
    {
        node = _node;
        index = _index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        int maxi = 0;
        
        while(!q.isEmpty())
        {
            int firstIndex = 0;
            int lastIndex = 0;
            int size = q.size();
            for(int i=size; i>0; i--)
            {
                Pair p = q.poll();
                
                //getting firstIndex of the level;
                if(i==size) firstIndex = p.index;
                
                //getting lastIndex of the level;
                if(i==1) lastIndex = p.index;
                
                int j = p.index;
                
                if(p.node.left!=null) q.add(new Pair(p.node.left, 2*j+1));
                if(p.node.right!=null) q.add(new Pair(p.node.right, 2*j+2));
            }
            
            maxi = Math.max(maxi, lastIndex - firstIndex + 1);
        }
        
        return maxi;
    }
}