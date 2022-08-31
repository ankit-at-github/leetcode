class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxi = 0;
        while(right < s.length())
        {
            if(map.containsKey(s.charAt(right)))
            {
                left = Math.max(left, map.get(s.charAt(right))+1);
            }
            maxi = Math.max(maxi, right-left+1);
            map.put(s.charAt(right), right);
            right++;
        }
        return maxi;
    }
}