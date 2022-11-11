class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(int i=0; i<t.length(); i++) map[t.charAt(i)]++;
        
        int counter = t.length();
        int start = 0, end = 0, minWindow = Integer.MAX_VALUE, minStart = 0;
        
        while(end < s.length())
        {
            if(map[s.charAt(end)] > 0) counter--;
            map[s.charAt(end)]--;
            end++;
            
            while(counter == 0)
            {
                if(end-start < minWindow)
                {
                    minWindow = end-start+1;
                    minStart = start;
                }
                
                //making the case invalid
                map[s.charAt(start)]++;
                if(map[s.charAt(start)] > 0) counter++;
                    
                start++;
            }
        }
        return minWindow == Integer.MAX_VALUE?"":s.substring(minStart, minStart+minWindow-1);
    }
}