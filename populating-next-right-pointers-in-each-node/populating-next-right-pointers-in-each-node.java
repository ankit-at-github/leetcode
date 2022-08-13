/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        bfs(root);
        return root;
    }
    public void bfs(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            for(int i = q.size(); i > 0; i--)
            {
                Node node = q.poll();
                
                if(i == 1) node.next = null;
                else node.next = q.peek();
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
    }
}