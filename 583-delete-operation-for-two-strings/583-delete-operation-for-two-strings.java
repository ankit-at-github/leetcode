class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++) dp[i][0] = 0;
        for(int j=0; j<n+1; j++) dp[0][j] = 0;
        
        int lcs = LCS(dp, m, n, word1, word2);
        
        int delete = (m-lcs) + (n-lcs);
        return delete;
    }
    public int LCS(int[][] dp, int m, int n, String w1, String w2)
    {
        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(w1.charAt(i-1) == w2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
}