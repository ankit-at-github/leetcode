class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> st = new HashSet<>();
        String[] word = s.split(" ");
        
        if(word.length != pattern.length()) return false;
        
        for(int i=0; i<pattern.length(); i++)
        {
            if(map.containsKey(pattern.charAt(i)))
            {
                if(!word[i].equals(map.get(pattern.charAt(i)))) return false;
            }
            else
            {
                if(st.contains(word[i])) return false;
                map.put(pattern.charAt(i), word[i]);
                st.add(word[i]);
            }
        }
        return true;
    }
}