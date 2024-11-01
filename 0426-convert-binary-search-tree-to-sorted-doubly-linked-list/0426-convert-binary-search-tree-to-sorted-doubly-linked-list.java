/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        //In place, we need track of first and last element
        convertBST(root);
        
        first.left = last;
        last.right = first;
        return first;
    }
    public Node convertBST(Node root){
        if(root != null){
            convertBST(root.left);
            if(last != null){
                last.right = root;
                root.left = last;
            }else{
                first = root;
            }
            last = root;
            convertBST(root.right);
        }
        return last;
    }
}