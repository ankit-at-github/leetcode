class Solution {
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) break;
            i++;
            j--;
        }
        if(i>=j) return true;
        
        return checkPalindrome(s, i+1, j) || checkPalindrome(s, i, j-1);
        
    }
    public boolean checkPalindrome(String s, int i, int j)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}