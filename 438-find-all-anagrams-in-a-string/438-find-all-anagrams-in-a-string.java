class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        //Storing frequency of characters in P
        int[] pfreq = new int[26];
        for(int i=0; i<p.length(); i++) pfreq[p.charAt(i) - 'a']++;
        
        Map<Character, Integer> sfreq = new HashMap<>();
        int left = 0, right = 0;
        while(right < s.length())
        {
            sfreq.put(s.charAt(right), sfreq.getOrDefault(s.charAt(right), 0)+1);
            
            if((right - left +1) == p.length())
            {
                int i = left;
                //checking all character frequency is same or not in the window
                while(i <= right && pfreq[s.charAt(i)-'a'] == sfreq.get(s.charAt(i))) i++;
                if(i == right+1) ans.add(left);
                
                //reducing the left character count by 1 as window will now increase by one.
                sfreq.put(s.charAt(left), sfreq.get(s.charAt(left))-1);
                left++;
            }
            
            right++;
        }
        
        return ans;
    }
}