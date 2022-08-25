class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mag = new int[26];
        for(char c : magazine.toCharArray()) mag[c-'a']++;
        for(char c : ransomNote.toCharArray())
        {
            if(mag[c-'a'] > 0) mag[c-'a']--;
            else return false;
        }
        return true;
    }
}