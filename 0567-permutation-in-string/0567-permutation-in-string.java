class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            freq[c - 'a']++;
        }
        int left = 0, right = 0;
        while(right < s2.length()){
            char r = s2.charAt(right);
            freq[r - 'a']--;
            while(freq[r - 'a'] < 0){
                char l = s2.charAt(left);
                freq[l - 'a']++;
                left++;
            }
            if(right - left + 1 == s1.length()) return true;
            
            right++;
        }
        return false;
    }
}