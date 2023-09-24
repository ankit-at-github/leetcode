class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        int maxi = -1;
        for(String word : words)
        {
            int currentMax = 0;
            for(int i=0; i<word.length(); i++)
            {
                String prev = word.substring(0, i) + word.substring(i+1);
                //update the longest chain for current word
                currentMax = Math.max(currentMax, map.getOrDefault(prev, 0) +1);
            }
            map.put(word, currentMax);
            maxi = Math.max(maxi, currentMax);
        }
        
        return maxi;
    }
}