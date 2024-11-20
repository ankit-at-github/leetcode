class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String str : strs){
            int[] freq = new int[26];
            for(char c : str.toCharArray()){
                freq[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++) sb.append(freq[i]).append("#");
            String key = sb.toString();
            if(!anagrams.containsKey(key)) anagrams.put(key, new ArrayList());
            anagrams.get(key).add(str);
            
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> anagram : anagrams.values()){
            ans.add(anagram);
        }
        return ans;
    }
}