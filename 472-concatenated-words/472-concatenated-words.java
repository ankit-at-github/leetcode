class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        
        //We need to create dict as searching is unique.
        //Set - Avoid Duplicates
        
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        
        for(String word : words)
        {
            if(canForm(word, dict)) result.add(word);
        }
        return result;
    }
    boolean canForm(String word, Set<String> dict)
    {
        for(int i=0; i<word.length(); i++)
        {
            String left = word.substring(0, i);
            String right = word.substring(i);
            
            if(dict.contains(left))
            {
                if(dict.contains(right) || canForm(right, dict)) return true;
            }
        }
        return false;
    }
}