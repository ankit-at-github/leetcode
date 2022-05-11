class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        for(int i=0; i<n; i++) dp[i][0] = 1;
        for(int i=0; i<5; i++) dp[0][i] = 1;
        
        return countdP(dp, n, 5);
    }
    public int countdP(int[][] dp, int row, int col)
    {
        for(int i=1; i<row; i++)
        {
            for(int j=1; j<col; j++)
            {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        
        int count = 0;
        for(int i=0; i<5; i++) count+=dp[row-1][i];
        return count;
    }
}