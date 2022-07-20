class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        //Stroring the frequency of word in words string of array
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0)+1);
        
        //Converting given string to character array to compare with each word present in array of strings(words)
        char[] sArray = s.toCharArray();
        
        int ans = 0;
        for(String word : map.keySet())
        {
            //Converting word to character array
            char[] wordArray = word.toCharArray();
            int i=0, j=0;
            while(i < sArray.length && j < wordArray.length)
            {
                if(sArray[i] == wordArray[j]) j++;
                i++;
            }
            if(j == wordArray.length) ans+=map.get(word);
        }
        return ans;
    }
}