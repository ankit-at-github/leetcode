class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(char ch : t.toCharArray()) map[ch]++;
        
        int count = t.length();
        int mini = Integer.MAX_VALUE, start = 0, end = 0, minStart = 0;
        while(end < s.length())
        {
            if(map[s.charAt(end)] > 0) count--;
            map[s.charAt(end)]--;
            end++;
            
            while(count == 0)
            {
                if(mini > end-start+1)
                {
                    mini = end-start+1;
                    minStart = start;
                }
                
                //invalidcase
                map[s.charAt(start)]++;
                if(map[s.charAt(start)] > 0) count++;
                
                start++;
            }
        }
        return mini==Integer.MAX_VALUE?"":s.substring(minStart, minStart+mini-1);
    }
}