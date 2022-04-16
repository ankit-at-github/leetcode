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
        List<List<Integer>> output = new ArrayList<>();
        if(root==null) return output;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0; i<size; i++)
            {
                Node present = q.poll();
                curr.add(present.val);
                for(Node n : present.children) q.add(n);
            }
            output.add(curr);
        }
        return output;
    }
}