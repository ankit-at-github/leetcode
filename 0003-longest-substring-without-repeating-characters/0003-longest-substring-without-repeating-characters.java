class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxi = 0;
        while(right < s.length()){
            
            while(!set.isEmpty() && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            
            maxi = Math.max(maxi, right - left + 1);
            
            set.add(s.charAt(right));
            
            right++;
        }
        return maxi;
    }
}