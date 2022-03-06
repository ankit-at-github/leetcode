class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) freq[s.charAt(i) - 'a']++;
        
        int max = 0, letter = 0;
        for(int i=0; i<freq.length; i++)
        {
            if(freq[i] > max)
            {
                max = freq[i];
                letter = i;
            }
        }
        
        if(max > (s.length()+1)/2) return "";
        
        char[] res = new char[s.length()];
        int index = 0;
        
        while(freq[letter] > 0)
        {
            res[index] = (char) (letter + 'a');
            index+=2;
            freq[letter]--;
        }
        
        for(int i=0; i<freq.length; i++)
        {
            while(freq[i] > 0)
            {
                if(index >= res.length)
                {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index+=2;
                freq[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}