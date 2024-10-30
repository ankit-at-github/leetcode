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
        int total = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                Pair p = q.poll();
                TreeNode currentNode = p.node;
                int prevSum = p.sum;
                int currentSum = prevSum * 10 + currentNode.val;
                
                if(currentNode.left == null && currentNode.right == null){
                    total+=currentSum;
                }
                
                if(currentNode.left != null) q.add(new Pair(currentNode.left, currentSum));
                if(currentNode.right != null) q.add(new Pair(currentNode.right, currentSum));
            }
        }
        return total;
    }
}
class Pair{
    TreeNode node;
    int sum;
    Pair(TreeNode _node, int _sum){
        node = _node;
        sum = _sum;
    }
}