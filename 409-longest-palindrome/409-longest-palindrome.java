class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0)+1);
        }
        
        int count = 0;
        boolean oddValue = false;
        for(int freq : frequency.values())
        {
            if(freq%2 == 0) count+=freq;
            else
            {
                count+=freq-1;
                oddValue = true;
            }
        }
        
        if(oddValue) count++;
        
        return count;
        
    }
}