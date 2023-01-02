class Solution {
    public boolean detectCapitalUse(String word) {
        int upper = 0;
        for(char c : word.toCharArray()) if(65 <= c && c <= 91) upper++;
        
        if(upper == word.length() || upper == 0) return true;
        
        if(upper == 1 && Character.isUpperCase(word.charAt(0))) return true;
        
        return false;
    }
}