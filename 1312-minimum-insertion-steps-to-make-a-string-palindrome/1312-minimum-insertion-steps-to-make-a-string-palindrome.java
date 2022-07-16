class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        int m = s.length();
        int n = sb.length();
        int[][] dp = new int[m+1][n+1];
        int lps = LPS(s, sb.reverse().toString(), m, n, dp);
        return (s.length()-lps);
    }
    public int LPS(String a, String b, int m, int n, int[][] dp)
    {
        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}