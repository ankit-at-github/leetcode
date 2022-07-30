class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCount = new int[26];
        int[] temp = new int[26];
        for(String w2 : words2)
        {
            temp = getCount(w2);
            for(int i=0; i<26; i++) maxCount[i] = Math.max(maxCount[i], temp[i]);
        }
        
        List<String> ans = new ArrayList<>();
        for(String word : words1)
        {
            temp = getCount(word);
            boolean add = true;
            for(int i=0; i<26; i++)
            {
                if(maxCount[i] > 0)
                {
                    if(maxCount[i] > temp[i])
                    {
                        add = false;
                        break;
                    }
                }
            }
            if(add) ans.add(word);
        }
        return ans;
    }
    public int[] getCount(String w)
    {
        int[] map = new int[26];
        for(char c : w.toCharArray()) map[c-'a']++;
        return map;
    }
}