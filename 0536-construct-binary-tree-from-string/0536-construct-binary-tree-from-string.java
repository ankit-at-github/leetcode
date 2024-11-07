/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if(s.length() == 0) return null;
        
        Stack<TreeNode> st = new Stack<>();
        int i = 0;
        int sign = 1;
        while(i < s.length()){
            
            if(s.charAt(i) == '('){
                i++;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
                i++;
            }
            else if(s.charAt(i) == ')'){
                st.pop();
                i++;
            }
            else{
                int num = 0;
                while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
                num*=sign;
                sign = 1;
                TreeNode current = new TreeNode(num);
                if(!st.isEmpty()){
                    TreeNode parent = st.peek();
                    if(parent.left == null) parent.left = current;
                    else parent.right = current;
                }
                st.push(current);
            }
        }
        return st.peek();
    }
}