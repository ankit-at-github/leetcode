class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        
        Set<String> cache = new HashSet<>();
        
        //We need to create dict as searching is unique.
        //Set - Avoid Duplicates
        
        Set<String> dict = new HashSet<>();
        
        int mini = Integer.MAX_VALUE;
        for(String word : words)
        {
            mini = Math.min(mini, word.length());
            dict.add(word);
        }
        
        for(String word : words)
        {
            if(canForm(word, dict, mini, cache)) result.add(word);
        }
        return result;
    }
    boolean canForm(String word, Set<String> dict, int mini, Set<String> cache)
    {
        if(cache.contains(word)) return true;
        
        for(int i=mini; i<=word.length()-mini; i++)
        {
            String left = word.substring(0, i);
            String right = word.substring(i);
            
            if(dict.contains(left))
            {
                if(dict.contains(right) || canForm(right, dict, mini, cache))
                {
                    cache.add(word);
                    return true;
                }
            }
        }
        return false;
    }
}