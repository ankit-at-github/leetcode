class Solution {
    public String minWindow(String s, String t) {
        //storing frequency of each character present in string t
        int[] map = new int[128];
        for(char c : t.toCharArray()) map[c]++;
        
        int start = 0, end = 0, minWindow = Integer.MAX_VALUE, minStart = 0;
        
        int counter = t.length();
        while(end < s.length())
        {
            //if a character is found in s which is present in t, decrement the counter
            if(map[s.charAt(end)] > 0) counter--;
            map[s.charAt(end)]--;
            end++;
            
            //if counter becomes 0, t is found in s, get the window size and increment start.
            while(counter == 0)
            {
                if(minWindow > end-start+1)
                {
                    minWindow = end-start+1;
                    minStart = start;
                }
                
                map[s.charAt(start)]++;
                if(map[s.charAt(start)] > 0) counter++;
                
                start++;
            }
        }
        
        return minWindow == Integer.MAX_VALUE?"":s.substring(minStart, minStart+minWindow-1);
    }
}