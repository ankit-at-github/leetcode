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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        if(root == null) return path;
        
        StringBuilder sb = new StringBuilder();
        getPathToLeaf(root, path, sb);
        
        return path;
    }
    public void getPathToLeaf(TreeNode root, List<String> path, StringBuilder sb)
    {
        if(root == null) return;
        
        int length = sb.length();
        
        if(root.left == null && root.right == null)
        {
            sb.append(root.val);
            path.add(sb.toString());
            sb.delete(length, sb.length());
            return;
        }
        
        sb.append(root.val+"->");
        
        getPathToLeaf(root.left, path, sb);
        getPathToLeaf(root.right, path, sb);
        
        sb.delete(length, sb.length());
    }
}