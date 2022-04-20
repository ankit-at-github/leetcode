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
class BSTIterator {
    
    List<Integer> list;
    int current;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        current = -1;
        inorder(list, root);
    }
    
    public int next() {
        current++;
        return list.get(current);
    }
    
    public boolean hasNext() {
        if(current < list.size()-1) return true;
        else return false;
    }
    
    public void inorder(List<Integer> list, TreeNode root)
    {
        if(root == null) return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */