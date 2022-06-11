class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxi = 0;
        HashMap<Character, Integer> map =new HashMap<>();
        int j = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                j=Math.max(map.get(s.charAt(i)),j);
            }
            maxi = Math.max(maxi, i-j+1);
            map.put(s.charAt(i), i+1);
        }
        return maxi;
    }
}