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
    public List<Integer> preorder(Node root) {
        List<Integer> nTraversal = new ArrayList<>();
        if(root==null) return nTraversal;
        Stack<Node> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty())
        {
            Node curr = st.pop();
            nTraversal.add(curr.val);
            
            List<Node> child = curr.children;
            for(int i=child.size()-1; i>=0; i--)
            {
                st.add(child.get(i));
            }
        }
        return nTraversal;
    }
}