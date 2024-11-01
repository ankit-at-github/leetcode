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
    public int sumNumbers(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int total = 0;
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                Pair p = q.poll();
                TreeNode node = p.node;
                int prevVal = p.prevVal;
                
                int currentVal = prevVal * 10 + node.val;
                
                if(node.left == null && node.right == null){
                    total+=currentVal;
                }
                
                
                if(node.left != null) q.add(new Pair(node.left, currentVal));
                if(node.right != null) q.add(new Pair(node.right, currentVal));
                
            }
        }
        return total;
    }
}
class Pair{
    TreeNode node;
    int prevVal;
    Pair(TreeNode _node, int _prevVal){
        node = _node;
        prevVal = _prevVal;
    }
}