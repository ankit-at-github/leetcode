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
class Tuple{
    TreeNode node;
    int vertical;
    int level;
    Tuple(TreeNode _node, int _vertical, int _level)
    {
        node = _node;
        vertical = _vertical;
        level = _level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tmap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                Tuple t = q.poll();
                
                if(!tmap.containsKey(t.vertical)) tmap.put(t.vertical, new TreeMap<>());
                if(!tmap.get(t.vertical).containsKey(t.level)) tmap.get(t.vertical).put(t.level, new PriorityQueue<>());
                
                tmap.get(t.vertical).get(t.level).add(t.node.val);
                
                if(t.node.left!=null) q.add(new Tuple(t.node.left, t.vertical-1, t.level+1));
                if(t.node.right!=null) q.add(new Tuple(t.node.right, t.vertical+1, t.level+1));
            }
        }
        
        for(TreeMap<Integer, PriorityQueue<Integer>> ds : tmap.values())
        {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ds.values())
            {
                while(!nodes.isEmpty())
                {
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        
        return ans;
    }
}