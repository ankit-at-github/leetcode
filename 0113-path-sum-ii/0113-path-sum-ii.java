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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        getPathSum(root, targetSum, new ArrayList(), ans);
        return ans;
    }
    public void getPathSum(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> ans){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                current.add(root.val);
                ans.add(new ArrayList(current));
                current.remove(current.size()-1);
            }
            return;
        }
        
        current.add(root.val);
        getPathSum(root.left, targetSum-root.val, current, ans);
        getPathSum(root.right, targetSum-root.val, current, ans);
        current.remove(current.size()-1);
    }
}