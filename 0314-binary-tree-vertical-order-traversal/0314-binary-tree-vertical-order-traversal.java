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
        
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        int minAxis = Integer.MAX_VALUE;
        int maxAxis = Integer.MIN_VALUE;
        if(root == null) return ans;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                Pair p = q.poll();
                TreeNode node = p.node;
                int axis = p.axis;
                
                minAxis = Math.min(minAxis, axis);
                maxAxis = Math.max(maxAxis, axis);
                
                if(!hmap.containsKey(axis)) hmap.put(axis, new ArrayList());
                
                hmap.get(axis).add(node.val);
                
                if(node.left != null) q.add(new Pair(axis-1, node.left));
                if(node.right != null) q.add(new Pair(axis+1, node.right));
            }
        }
        
        for(int i=minAxis; i<=maxAxis; i++){
            ans.add(hmap.get(i));
        }
        
       return ans;
    }
}