class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        
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
            if(canForm(word, dict, mini)) result.add(word);
        }
        return result;
    }
    boolean canForm(String word, Set<String> dict, int mini)
    {
        for(int i=mini; i<=word.length()-mini; i++)
        {
            String left = word.substring(0, i);
            String right = word.substring(i);
            
            if(dict.contains(left))
            {
                if(dict.contains(right) || canForm(right, dict, mini)) return true;
            }
        }
        return false;
    }
}