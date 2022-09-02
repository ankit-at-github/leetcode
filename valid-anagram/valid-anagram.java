class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(char i : s.toCharArray()) freq[i-'a']++;
        for(char i : t.toCharArray()) freq[i-'a']--;
        for(int x : freq) if(x!=0) return false;
        return true;
    }
}