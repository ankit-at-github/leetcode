class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        
        for(String s : strs)
        {
            char[] chrArray = s.toCharArray();
            Arrays.sort(chrArray);
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<chrArray.length; i++)
            {
                sb.append(chrArray[i]-'a');
                sb.append('#');
            }
            
            String key = sb.toString();
            
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        
        return new ArrayList(map.values());
    }
}