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
        
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                TreeNode currentNode = q.poll();
                
                if(i == 1)
                ans.add(currentNode.val);
                
                if(currentNode.left != null) q.add(currentNode.left);
                if(currentNode.right != null) q.add(currentNode.right);
            }
        }
        return ans;
    }
}