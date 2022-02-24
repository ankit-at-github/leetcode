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
    public boolean isLeaf(TreeNode node)
    {
        if(node.left==null && node.right==null) return true;
        else return false;
    }
    public void addLeafNodes(TreeNode root, List<Integer> ans)
    {
        if(root==null) return;
        
        if(isLeaf(root)) ans.add(root.val);
        addLeafNodes(root.left, ans);
        addLeafNodes(root.right, ans);
        
    }
    public void addRightboundary(TreeNode root, List<Integer> ans)
    {
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr!=null)
        {
            if(!isLeaf(curr)) temp.add(curr.val);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
        
        for(int i=temp.size()-1; i>=0; i--) ans.add(temp.get(i));
    }
    public void addLeftboundary(TreeNode root, List<Integer> ans)
    {
        TreeNode curr = root.left;
        while(curr!=null)
        {
            if(!isLeaf(curr)) ans.add(curr.val);
            if(curr.left!=null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if(root==null) return ans;
        
        ans.add(root.val);
        
        if(isLeaf(root)) return ans;
        
        addLeftboundary(root,ans);
        addLeafNodes(root,ans);
        addRightboundary(root,ans);
        
        return ans;
        
    }
}