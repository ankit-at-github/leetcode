class Solution {
    public int maxDepth(String s) {
        int open = 0;
        int maxi = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == ')')
            {
                maxi = Math.max(maxi, open);
                open--;
            }
            if(s.charAt(i) == '(') open++;
        }
        return maxi;
    }
}