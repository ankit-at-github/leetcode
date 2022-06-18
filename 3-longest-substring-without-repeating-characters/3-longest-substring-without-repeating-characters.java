class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            count = 0;
            for(int j=i; j<s.length(); j++)
            {
                if(set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
                count++;
            }
            maxLength = Math.max(maxLength, count);
            set.clear();
        }
        return maxLength;
    }
}