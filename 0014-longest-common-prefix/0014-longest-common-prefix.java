class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        for(int index=0; index<strs[0].length(); index++){
            for(int j=1; j<strs.length; j++){
                if(index == strs[j].length() || strs[0].charAt(index) != strs[j].charAt(index)) return strs[0].substring(0, index);
            }
        }
        return strs[0];
    }
}