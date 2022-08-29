class Solution {
    public String largestPalindromic(String num) {
        //start+mid+reverse(start)
        int[] freq = new int[10];
        for(char c : num.toCharArray()) freq[c-'0']++;
        
        StringBuilder sb = new StringBuilder();
        int mid = Integer.MIN_VALUE;
        for(int i=9; i>=0; i--)
        {
            if(freq[i] > 0)
            {
                if(freq[i]%2 !=0) mid = Math.max(mid, i);
                int pair = freq[i]/2;
                
                while(pair-- > 0)
                {
                    if(i==0 && sb.length()==0) continue;
                    sb.append(i);
                }
            }
        }
        String ans = sb.toString();
        if(mid != Integer.MIN_VALUE) ans = ans+mid;
        ans = ans+sb.reverse().toString();
        return ans.length()==0?"0":ans;
        
    }
}