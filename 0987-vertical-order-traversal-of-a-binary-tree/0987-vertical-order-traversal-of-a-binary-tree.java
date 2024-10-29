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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tmap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 1));
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                Tuple t = q.poll();
                TreeNode current = t.node;
                int axis = t.axis;
                int level = t.level;
                
                if(!tmap.containsKey(axis)) tmap.put(axis, new TreeMap());
                if(!tmap.get(axis).containsKey(level)) tmap.get(axis).put(level, new PriorityQueue());
                
                tmap.get(axis).get(level).add(current.val);
                
                if(current.left != null) q.add(new Tuple(current.left, axis-1, level+1));
                if(current.right != null) q.add(new Tuple(current.right, axis+1, level+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> map : tmap.values()){
            List<Integer> current = new ArrayList<>();
            for(PriorityQueue<Integer> pq : map.values()){
                while(!pq.isEmpty()) current.add(pq.poll());
            }
            ans.add(current);
        }
        return ans;
    }
}
class Tuple{
    TreeNode node;
    int axis;
    int level;
    
    Tuple(TreeNode _node, int _axis, int _level){
        node = _node;
        axis = _axis;
        level = _level;
    }
}