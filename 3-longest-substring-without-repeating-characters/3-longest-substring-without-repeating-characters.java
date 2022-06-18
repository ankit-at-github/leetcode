class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxiLength = 0;
        int left = 0;
        
        for(int right=0; right<s.length(); right++)
        {
            if(map.containsKey(s.charAt(right)))
            {
                left = Math.max(map.get(s.charAt(right))+1, left);
            }
            maxiLength = Math.max(maxiLength, right-left+1);
            map.put(s.charAt(right), right);
        }
        return maxiLength;
    }
}