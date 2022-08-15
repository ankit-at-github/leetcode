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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            List<Integer> present = new ArrayList<>();
            for(int i=q.size(); i>0; i--)
            {
                Node current = q.poll();
                present.add(current.val);
                for(Node x : current.children) q.add(x);
            }
            ans.add(present);
        }
        
        return ans;
    }
}