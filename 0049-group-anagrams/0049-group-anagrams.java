class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs)
        {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            
            String sb = new String(charArray);
            
            if(!map.containsKey(sb))
            {
                map.put(sb, new ArrayList<String>());
            }
            
            map.get(sb).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        
        for(List<String> l : map.values()) ans.add(l);
        
        return ans;
    }
}