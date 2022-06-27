class Solution {
    public int minPartitions(String n) {
        int mini = 0;
        for(int i=0; i<n.length(); i++) mini = Math.max(mini, n.charAt(i)-'0');
        
        return mini;
    }
}