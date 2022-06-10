class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] hash = new boolean[500];
        
        Arrays.fill(hash,false);
        
        int l=0, r = 0;
        
        int maxCount = 0, counter = 0;
        
        while(r<s.length()){
            
                if(!(hash[Integer.valueOf(s.charAt(r))]))
                {
                    hash[Integer.valueOf(s.charAt(r))] = true;
                    r++;
                    counter++;
                }
                else
                {
                    hash[Integer.valueOf(s.charAt(l))] = false;
                    l++;
                    counter--;
                }
            
            maxCount = Math.max(maxCount,counter);
        }
        
        return maxCount;
    }
}