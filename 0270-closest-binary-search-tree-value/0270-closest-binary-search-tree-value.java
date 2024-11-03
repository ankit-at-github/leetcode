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
    public int closestValue(TreeNode root, double target) {
        List<Integer> sortedList = new ArrayList<>();
        inorder(root, sortedList);
        int low = 0, high = sortedList.size()-1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(sortedList.get(mid) == target) return sortedList.get(mid);
            
            if(sortedList.get(mid) < target) low = mid+1;
            else high = mid-1;
        }
        
        if(low >= sortedList.size()) return sortedList.get(sortedList.size()-1);
        else if(low == 0) return sortedList.get(0);
        else{
            return Math.abs(target - sortedList.get(low)) < Math.abs(target - sortedList.get(low - 1)) ? sortedList.get(low) : sortedList.get(low-1);
        }
    }
    public void inorder(TreeNode root, List<Integer> sortedList){
        if(root == null) return;
        
        inorder(root.left, sortedList);
        sortedList.add(root.val);
        inorder(root.right, sortedList);
    }
}