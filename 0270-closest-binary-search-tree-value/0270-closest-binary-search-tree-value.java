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
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        while(root != null){
            
            if(Math.abs(root.val - target) < Math.abs(result - target)){
                result = root.val;
            }
            else if(Math.abs(root.val - target) == Math.abs(result - target)){
                result = Math.min(result, root.val);
            }
            
            root = target < root.val ? root.left : root.right;
        }
        return result;
    }
}