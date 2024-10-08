/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if(p == null || q == null) return null;
        Node root = p;
        while(root.parent != null) root = root.parent;
        return LCA(root, p, q);
    }
    public Node LCA(Node root, Node p, Node q){
        if(root == null || root.val == p.val || root.val == q.val) return root;
        Node left = LCA(root.left, p, q);
        Node right = LCA(root.right, p, q);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}