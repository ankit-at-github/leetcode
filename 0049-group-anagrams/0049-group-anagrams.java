class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> anagram = new HashMap<>();
        for(String str : strs){
            int[] freq = new int[26];
            for(char c : str.toCharArray()){
                freq[c-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int i=0; i<26; i++){
                key.append(freq[i]).append("#");
            }
            if(!anagram.containsKey(key.toString())) anagram.put(key.toString(), new ArrayList());
            anagram.get(key.toString()).add(str);
        }
        for(List<String> grouped : anagram.values()){
            ans.add(grouped);
        }
        return ans;
    }
}