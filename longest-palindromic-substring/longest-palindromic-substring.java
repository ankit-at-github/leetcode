class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int m = s.length();
        int n = sb.length();
        
        int[][] dp = new int[m+1][n+1];
        return LPS(s, sb.reverse().toString(), m, n, dp);
    }
    public String LPS(String a, String b, int m, int n, int[][] dp)
    {
        int maxi = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j] > maxi)
                    {
                        int start = i - dp[i][j];
                        String forward = a.substring(start, i);
                        StringBuilder backward = new StringBuilder(forward);
                        backward.reverse();
                        if(forward.equals(backward.toString()))
                        {
                            ans.delete(0, ans.length());
                            ans.append(forward);
                            maxi = dp[i][j];
                        }
                    }
                }
                else dp[i][j] = 0;
            }
        }
        return ans.toString();
    }
}