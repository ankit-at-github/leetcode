class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int left = 0, right = 0;
        int maxi = 0;
        
        while(right < s.length())
        {
            while(st.contains(s.charAt(right)))
            {
                st.remove(s.charAt(left));
                left++;
            }
            st.add(s.charAt(right));
            maxi = Math.max(maxi, right-left+1);
            right++;
        }
        return maxi;
    }
}