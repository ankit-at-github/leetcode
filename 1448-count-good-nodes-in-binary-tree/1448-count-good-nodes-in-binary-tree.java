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
        q.add(new Pair(root, root.val));
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                Pair p = q.poll();
                TreeNode currentNode = p.node;
                int prevMax = p.prev;
                
                if(currentNode.val >= prevMax) count++;
                
                prevMax = Math.max(prevMax, currentNode.val);
                
                if(currentNode.left != null) q.add(new Pair(currentNode.left, prevMax));
                if(currentNode.right != null) q.add(new Pair(currentNode.right, prevMax));
            }
        }
        return count;
    }
}
class Pair{
    TreeNode node;
    int prev;
    Pair(TreeNode _node, int _prev){
        node = _node;
        prev = _prev;
    }
}