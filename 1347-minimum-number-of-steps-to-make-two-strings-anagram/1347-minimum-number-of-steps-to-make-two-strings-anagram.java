class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        int count = 0;
        for(int x : freq) if(x>0) count+=x;
        return count;
    }
}