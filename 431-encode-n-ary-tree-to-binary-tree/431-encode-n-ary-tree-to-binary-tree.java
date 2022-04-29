/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        
        TreeNode node = new TreeNode(root.val);
        if(root.children == null || root.children.isEmpty()) return node;
        node.left = encode(root.children.get(0));
        TreeNode nodeLeft = node.left;
        for(int i=1;i<root.children.size();i++) {
            nodeLeft.right = encode(root.children.get(i));
            nodeLeft = nodeLeft.right;
        }
        return node;
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) return null;
        Node node = new Node(root.val,new ArrayList<>());    
        if(root.left == null && root.right == null) return node;
        if(root.left != null) node.children.add(decode(root.left));
        
        TreeNode rootLeft = root.left;
        while(rootLeft != null && rootLeft.right != null) {
            TreeNode rootLeftRight = rootLeft.right;
            root.left.right = null;
            node.children.add(decode(rootLeftRight));
            rootLeft = rootLeftRight;
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));