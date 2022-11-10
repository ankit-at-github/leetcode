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

class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        int level = 0;
        
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                Node current = q.poll();
                for(Node child : current.children) q.add(child);
            }
            level++;
        }
        
        return level;
    }
}