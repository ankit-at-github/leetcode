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

    TreeNode root;
    List<Integer> inOrder;
    int prev,curr,nxt;
    public BSTIterator(TreeNode root) {
        inOrder = new ArrayList<>();
        inorder(root, inOrder);
        prev = -2;
        curr = -1;
        nxt = 0;
    }
    
    public boolean hasNext() {
        if(nxt < inOrder.size()) return true;
        else return false;
    }
    
    public int next() {
        prev = curr;
        curr = nxt;
        nxt++;
        
        return inOrder.get(curr);
    }
    
    public boolean hasPrev() {
        if(prev >= 0) return true;
        else return false;
    }
    
    public int prev() {
        nxt = curr;
        curr = prev;
        prev--;
        return inOrder.get(curr);
    }
    public void inorder(TreeNode root, List<Integer> inOrder)
    {
        if(root==null) return;
        inorder(root.left, inOrder);
        inOrder.add(root.val);
        inorder(root.right, inOrder);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */