class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] str = new char[256];
        int left = 0, right = 0;
        int maxi = 0;
        while(right < s.length())
        {
            str[s.charAt(right)]++;
            
            while(str[s.charAt(right)] > 1)
            {
                str[s.charAt(left)]--;
                left++;
            }
            maxi = Math.max(maxi, right-left+1);
            right++;
        }
        return maxi;
    }
}