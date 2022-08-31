class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> st = new HashSet<>();
        int left = 0, right = 0;
        int maxi = Integer.MIN_VALUE;
        while(right < s.length())
        {
            while(!st.isEmpty() && st.contains(s.charAt(right))) st.remove(s.charAt(left++));
            maxi = Math.max(maxi, right-left+1);
            st.add(s.charAt(right));
            map.put(s.charAt(right), right);
            right++;
        }
        return maxi == Integer.MIN_VALUE ? 0:maxi;
    }
}