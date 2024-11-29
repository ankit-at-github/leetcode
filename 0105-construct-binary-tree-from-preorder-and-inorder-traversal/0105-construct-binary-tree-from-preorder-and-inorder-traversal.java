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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return constructTree(0, preorder.length-1, preorder, 0, inorder.length-1, inorder, inMap);
    }
    public TreeNode constructTree(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder, Map<Integer, Integer> inMap){
        if(inStart > inEnd || preStart > preEnd) return null;
        
        TreeNode current = new TreeNode(preorder[preStart]);
        int index = inMap.get(current.val);
        int leftElements = index - inStart;
        
        current.left = constructTree(preStart+1, preStart+leftElements, preorder, inStart, index-1, inorder, inMap);
        current.right = constructTree(preStart+leftElements+1, preEnd, preorder, index+1, inEnd, inorder, inMap);
        
        return current;
    }
}