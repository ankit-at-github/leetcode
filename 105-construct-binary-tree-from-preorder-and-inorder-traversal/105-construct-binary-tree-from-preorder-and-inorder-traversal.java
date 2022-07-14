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
    public TreeNode buildBT(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> hash)
    {
        if(preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int rootIndex = hash.get(root.val);
        int numsLeft = rootIndex - inStart;
        
        root.left = buildBT(preorder, preStart+1, preStart + numsLeft, inorder, inStart, rootIndex - 1, hash);
        root.right = buildBT(preorder, preStart + numsLeft + 1, preEnd, inorder, rootIndex + 1, inEnd, hash);
        
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<inorder.length; i++) hash.put(inorder[i], i);
        
        return buildBT(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, hash);
    }
}