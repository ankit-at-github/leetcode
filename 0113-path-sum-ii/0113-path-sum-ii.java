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
        getPathValues(root, targetSum, new ArrayList(), ans);
        return ans;
    }
    public void getPathValues(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> ans){
        if(root == null) return;
        
        if(root.left == null && root.right == null && targetSum-root.val == 0){
            current.add(root.val);
            ans.add(new ArrayList(current));
            current.remove(current.size()-1);
        }
        
        current.add(root.val);
        getPathValues(root.left, targetSum-root.val, current, ans);
        getPathValues(root.right, targetSum-root.val, current, ans);
        current.remove(current.size()-1);
    }
}