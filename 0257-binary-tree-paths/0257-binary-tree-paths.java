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
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        getPath(root, new StringBuilder(""), ans);
        return ans;
    }
    public void getPath(TreeNode root, StringBuilder interimResult, List<String> ans){
        if(root == null) return;
        int length = interimResult.length();
        if(root.left == null && root.right == null){
            interimResult.append(root.val);
            ans.add(interimResult.toString());
            interimResult.delete(length, interimResult.length());
        }
        
        interimResult.append(root.val).append("->");
        getPath(root.left, interimResult, ans);
        getPath(root.right, interimResult, ans);
        interimResult.delete(length, interimResult.length());
    }
}