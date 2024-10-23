class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            while(freq[c-'a'] > 0){
                sb.append(c);
                freq[c-'a']--;
            }
        }
        for(int i=0; i<26; i++){
            while(freq[i] > 0){
                char c = (char) (i+97);
                sb.append(c);
                freq[i]--;
            }
        }
        return sb.toString();
    }
}