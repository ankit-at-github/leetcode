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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new ArrayList<>();
        
        getRight(root, right, 0);
        
        return right;
    }
    public void getRight(TreeNode root, List<Integer> right, int level)
    {
        if(root == null) return;
        
        if(right.size() == level) right.add(root.val);
        
        getRight(root.right, right, level+1);
        getRight(root.left, right, level+1);
    }
}