class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length()==0) return t.charAt(0);
        
        int[] freq = new int[26];
        int i=0, j=0;
        while(i < s.length() || j < t.length())
        {
            if(i < s.length()) freq[s.charAt(i++)-'a']++;
            if(j < t.length()) freq[t.charAt(j++)-'a']--;
        }
        
        for(int k=0; k<26; k++) if(freq[k] == -1) return (char)(k+'a');
        
        return ' ';
        
    }
}