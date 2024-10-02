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
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                TreeNode current = q.poll();
                if(current == null){
                    sb.append("# ");
                    continue;
                }
                else sb.append(current.val+" ");
                q.add(current.left);
                q.add(current.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] input = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1; i<input.length; i++){
            TreeNode rt = q.poll();
            if(!input[i].equals("#")){
                TreeNode current = new TreeNode(Integer.parseInt(input[i]));
                rt.left = current;
                q.add(current);
            }
            i++;
            if(!input[i].equals("#")){
                TreeNode current = new TreeNode(Integer.parseInt(input[i]));
                rt.right = current;
                q.add(current);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));