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
    int num;
    int level;
    Tuple(TreeNode _node, int _num, int _level){
        node = _node;
        num = _num;
        level = _level;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 1, 0));
        int prevLevel = 0, prevNum = 1;
        int maxi = 0;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode currentNode = t.node;
            int currentNum = t.num;
            int currentLevel = t.level;
            if(prevLevel < currentLevel){
                prevLevel = currentLevel;
                prevNum = currentNum;
            }
            maxi = Math.max(maxi, currentNum - prevNum + 1);
            if(currentNode.left != null) q.add(new Tuple(currentNode.left, 2 * currentNum, currentLevel + 1));
            if(currentNode.right != null) q.add(new Tuple(currentNode.right, 2 * currentNum + 1, currentLevel + 1));
        }
        return maxi;
    }
}