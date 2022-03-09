class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Map<String, Integer> map = new HashMap<>();
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<wordsDict.length; i++)
        {
            if(wordsDict[i].equals(word1))
            {
                if(map.containsKey(word2))
                    min = Math.min(min, Math.abs(i-map.get(word2)));
                map.put(word1,i);
            }
            else if(wordsDict[i].equals(word2))
            {
                if(map.containsKey(word1))
                    min = Math.min(min, Math.abs(i-map.get(word1)));
                map.put(word2,i);
            }
            
        }
        
        return min;
    }
}