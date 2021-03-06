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
    int vertical;
    Pair(TreeNode _node, int _vertical)
    {
        node = _node;
        vertical = _vertical;
    }
}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        TreeMap<Integer, ArrayList<Integer>> res = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty())
        {
            for(int i = q.size(); i>0; i--)
            {
                Pair p = q.poll();
                
                if(!res.containsKey(p.vertical)) res.put(p.vertical, new ArrayList<>());
                
                res.get(p.vertical).add(p.node.val);
                
                if(p.node.left!=null) q.add(new Pair(p.node.left, p.vertical-1));
                if(p.node.right!=null) q.add(new Pair(p.node.right, p.vertical+1));
            }
        }
        
        for(ArrayList<Integer> nodes : res.values()) ans.add(nodes);
        
        return ans;
    }
}