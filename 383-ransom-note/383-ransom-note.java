class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ran = new int[26];
        for(char c : ransomNote.toCharArray()) ran[c-'a']++;
        for(char c : magazine.toCharArray()) if(ran[c-'a'] > 0) ran[c-'a']--;
        
        for(int x : ran) if(x!=0) return false;
        return true;
    }
}