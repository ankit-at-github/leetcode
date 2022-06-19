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
        Map<Integer, Integer> map = new HashMap<>();
        
        getRight(root, map, 0);
        
        List<Integer> right = new ArrayList<>();
        
        for(int x : map.values()) right.add(x);
        
        return right;
    }
    public void getRight(TreeNode root, Map<Integer, Integer> map, int level)
    {
        if(root == null) return;
        
        if(!map.containsKey(level)) map.put(level, root.val);
        
        getRight(root.right, map, level+1);
        getRight(root.left, map, level+1);
    }
}