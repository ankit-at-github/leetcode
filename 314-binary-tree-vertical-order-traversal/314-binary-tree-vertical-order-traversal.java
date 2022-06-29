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
    int level;
    Pair(TreeNode _node, int _vertical, int _level)
    {
        node = _node;
        vertical = _vertical;
        level = _level;
    }
}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> res = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        
        while(!q.isEmpty())
        {
            for(int i = q.size(); i>0; i--)
            {
                Pair p = q.poll();
                
                if(!res.containsKey(p.vertical)) res.put(p.vertical, new TreeMap<>());
                if(!res.get(p.vertical).containsKey(p.level)) res.get(p.vertical).put(p.level, new ArrayList<>());
                
                res.get(p.vertical).get(p.level).add(p.node.val);
                
                if(p.node.left!=null) q.add(new Pair(p.node.left, p.vertical-1, p.level+1));
                if(p.node.right!=null) q.add(new Pair(p.node.right, p.vertical+1, p.level+1));
            }
        }
        
        for(TreeMap<Integer, ArrayList<Integer>> vertical : res.values())
        {
            List<Integer> current = new ArrayList<>();
            for(ArrayList<Integer> nodes : vertical.values())
            {
                for(int n : nodes) current.add(n);
            }
            ans.add(current);
        }
        return ans;
    }
}