class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) freq[s.charAt(i)-'a']++;
        
        Arrays.sort(freq);
        
        //The expectation of next frequency would be less than the previous frequency seen.
        //Re-adjust the frequency if current frequency is less than expected frequency.
        int exp = freq[25]-1;
        int deleteCount = 0;
        for(int i=24; i>=0; i--)
        {
            //before this all elements are zero so break;
            if(freq[i] == 0) break;
            
            if(freq[i] > exp) deleteCount+= freq[i] - exp;
            else exp = freq[i];
            
            if(exp > 0) exp--; //Lowest expectation can be zero, not negative.
            
        }
        return deleteCount;
    }
}