class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs)
        {
            int[] freq = new int[26];
            for(char c : s.toCharArray()) freq[c-'a']++;
            
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<26; i++)
            {
                sb.append('#');
                sb.append(freq[i]);
            }
            
            String key = sb.toString();
            
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            
            map.get(key).add(s);
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(List<String> l : map.values()) ans.add(l);
        
        return ans;
    }
}