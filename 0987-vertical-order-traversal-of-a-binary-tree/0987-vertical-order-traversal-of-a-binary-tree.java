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
    int axis;
    int level;
    Tuple(TreeNode node, int axis, int level)
    {
        this.node = node;
        this.axis = axis;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tmap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                Tuple t = q.poll();
                TreeNode current = t.node;
                int axis = t.axis;
                int level = t.level;
                
                if(!tmap.containsKey(axis)) tmap.put(axis, new TreeMap<Integer, PriorityQueue<Integer>>());
                if(!tmap.get(axis).containsKey(level)) tmap.get(axis).put(level, new PriorityQueue<Integer>());
                
                tmap.get(axis).get(level).add(current.val);
                
                if(current.left!=null) q.add(new Tuple(current.left, axis-1, level+1));
                if(current.right!=null) q.add(new Tuple(current.right, axis+1, level+1));
            }
        }
        
        for(TreeMap<Integer, PriorityQueue<Integer>> map : tmap.values()){
            List<Integer> current = new ArrayList<>();
            for(PriorityQueue<Integer> pq : map.values()){
                while(!pq.isEmpty()){
                    current.add(pq.poll());
                }
            }
            ans.add(current);
        }
        return ans;
    }
}