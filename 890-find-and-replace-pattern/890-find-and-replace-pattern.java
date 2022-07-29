class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        for(String word : words)
        {
            boolean flag = true;
            Map<Character, Character> map = new HashMap<>();
            for(int i=0; i<word.length(); i++)
            {
                if(map.containsKey(word.charAt(i)))
                {
                    if(!map.get(word.charAt(i)).equals(pattern.charAt(i)))
                    {
                        flag = false;
                        break;
                    }
                }
                else
                {
                    if(map.containsValue(pattern.charAt(i)))
                    {
                        flag = false;
                        break;
                    }
                    map.put(word.charAt(i), pattern.charAt(i));
                }
            }
            if(flag) ans.add(word);
        }
        return ans;
    }
}