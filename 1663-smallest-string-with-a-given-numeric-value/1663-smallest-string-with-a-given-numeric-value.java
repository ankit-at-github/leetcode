class Solution {
    public String getSmallestString(int n, int k) {
        int[] ascii = new int[26];
        for(int i=0; i<26; i++) ascii[i] = i;
        
        char[] charArray = new char[n];
        for(int i=0; i<n; i++)
        {
            charArray[i] = 'a';
            k--;
        }
        
        k++;
        if(k==0) return String.valueOf(charArray);
        int lastIndex = charArray.length-1;
        while(k!=0)
        {
            if(k<=26)
            {
                charArray[lastIndex] = (char)(ascii[k-1]+'a');
                k=0;
            }
            else
            {
                charArray[lastIndex] = 'z';
                k-=25;
            }
            lastIndex--;
        }
        
        return String.valueOf(charArray);
    }
}