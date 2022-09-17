/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(root.val)+" ");
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                TreeNode current = q.poll();
                if(current.left!=null)
                {
                    sb.append(Integer.toString(current.left.val)+" ");
                    q.add(current.left);
                }
                else sb.append("# ");
                if(current.right!=null)
                {
                    sb.append(Integer.toString(current.right.val)+" ");
                    q.add(current.right);
                }
                else sb.append("# ");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        
        String[] values = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        for(int i=1; i<values.length; i++)
        {
            TreeNode current = q.poll();
            if(!values[i].equals("#"))
            {
                int val = Integer.parseInt(values[i]);
                TreeNode left = new TreeNode(val);
                current.left = left;
                q.add(left);
            }
            if(!values[++i].equals("#"))
            {
                int val = Integer.parseInt(values[i]);
                TreeNode right = new TreeNode(val);
                current.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;