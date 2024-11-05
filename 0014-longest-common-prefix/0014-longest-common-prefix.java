class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        int len = Integer.MAX_VALUE;
        int mini = strs[0].length();
        for(int i=1; i<strs.length; i++){
            mini = Math.min(mini, strs[i].length());
            int j = 0;
            while(j < mini && strs[0].charAt(j) == strs[i].charAt(j)){
                j++;
            }
            len = Math.min(len, j);
        }
        if(len == Integer.MAX_VALUE) return "";
        return strs[0].substring(0, len);
    }
}