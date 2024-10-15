class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        int maxi = 0;
        int left = 0;
        for(int i=0; i<s.length(); i++){
            
            if(lastSeenIndex.containsKey(s.charAt(i))){
                left = Math.max(left, lastSeenIndex.get(s.charAt(i)));
            }
            maxi = Math.max(maxi, i - left + 1);
            lastSeenIndex.put(s.charAt(i), i+1);
        }
        return maxi;
    }
}