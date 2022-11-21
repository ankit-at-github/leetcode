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
    public int sumNumbers(TreeNode root) {
        List<String> ans = new ArrayList<>();
        preorder(root, ans, new StringBuilder());
        int sum = 0;
        for(String n : ans) sum+=Integer.parseInt(n);
        return sum;
    }
    public void preorder(TreeNode root, List<String> ans, StringBuilder num)
    {
        if(root == null) return;
        
        if(root.left == null && root.right == null)
        {
            num.append(Integer.toString(root.val));
            ans.add(num.toString());
            num.deleteCharAt(num.length()-1);
        }
        
        num.append(Integer.toString(root.val));
        preorder(root.left, ans, num);
        preorder(root.right, ans, num);
        num.deleteCharAt(num.length()-1);
    }
}