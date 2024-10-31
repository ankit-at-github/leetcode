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
    int axis;
    TreeNode node;
    Pair(int _axis, TreeNode _node){
        axis = _axis;
        node = _node;
    }
}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        if(root == null) return ans;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                Pair p = q.poll();
                TreeNode node = p.node;
                int axis = p.axis;
                
                if(!tmap.containsKey(axis)) tmap.put(axis, new ArrayList());
                
                tmap.get(axis).add(node.val);
                
                if(node.left != null) q.add(new Pair(axis-1, node.left));
                if(node.right != null) q.add(new Pair(axis+1, node.right));
            }
        }
        
        for(List<Integer> l : tmap.values()){
            ans.add(l);
        }
        
       return ans;
    }
}