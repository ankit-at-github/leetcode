class Solution {
    public String LPS(String s, String sb, int m, int n, int[][]dp)
    {
        int result = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(s.charAt(i-1) == sb.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j]  > result)
                    {
                        int start = i-dp[i][j];
                        String forward = s.substring(start, i);
                        StringBuilder backward = new StringBuilder(forward);
                        backward.reverse();
                        if(forward.equals(backward.toString()))
                        {
                            ans.delete(0, ans.length());
                            ans.append(forward);
                            result = dp[i][j];
                        }
                        
                    }
                }
                else dp[i][j] = 0;
            }
        }
       return ans.toString();
    }
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        int m = s.length();
        int n = sb.length();
        
        int[][] dp = new int[m+1][n+1];
        
        return LPS(s, sb.reverse().toString(), m, n, dp);
    }
}