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
        List<Integer> ans = new ArrayList<>();
        
        getRight(root, 0, ans);
        
        return ans;
    }
    public void getRight(TreeNode root, int level, List<Integer> ans){
        if(root == null) return;
        
        if(ans.size() == level) ans.add(root.val);
        
        getRight(root.right, level+1, ans);
        getRight(root.left, level+1, ans);
    }
}