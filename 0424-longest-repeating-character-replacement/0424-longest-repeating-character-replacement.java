class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxi = 0, left = 0, right = 0;
        int mostFreqCharacter = 0;
        while(right < s.length()){
            freq[s.charAt(right) - 'A']++;
            
            mostFreqCharacter = Math.max(mostFreqCharacter, freq[s.charAt(right) - 'A']);
            
            int windowSize = right - left + 1;
            int replacemnetCharacterCount = windowSize - mostFreqCharacter;
            
            if(replacemnetCharacterCount > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxi = Math.max(maxi, right - left + 1);
            right++;
        }
        return maxi;
    }
}