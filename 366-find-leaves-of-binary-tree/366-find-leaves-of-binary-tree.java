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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        preorder(root, map);
        for(List l : map.values()) ans.add(l);
        return ans;
    }
    public void preorder(TreeNode root, Map<Integer, ArrayList<Integer>> map)
    {
        if(root==null) return;
        int level = getHeight(root);
        if(map.containsKey(level)) map.get(level).add(root.val);
        else
        {
            map.put(level, new ArrayList<>());
            map.get(level).add(root.val);
        }
        preorder(root.left, map);
        preorder(root.right, map);
    }
    public int getHeight(TreeNode root)
    {
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}