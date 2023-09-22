class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int left = 0;
        for(int i=0; i<t.length(); i++)
        {
            if(left < s.length() && s.charAt(left) == t.charAt(i)) left++;
        }
        if(left!=s.length()) return false;
        return true;
    }
}