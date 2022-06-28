class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) freq[s.charAt(i)-'a']++;
        
        Set<Integer> set = new HashSet<>();
        int deletion = 0;
        for(int i=0; i<26; i++)
        {
            if(set.contains(freq[i]))
            {
                while(freq[i] > 0 && set.contains(freq[i]))
                {
                    freq[i]--;
                    deletion++;
                }
            }
            set.add(freq[i]);
        }
        
        return deletion;
    }
}