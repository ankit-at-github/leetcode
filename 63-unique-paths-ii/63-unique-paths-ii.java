class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++)
        {
            if(obstacleGrid[i][0] != 1) dp[i][0] = 1;
            else break;
        }
        for(int i=0; i<n; i++)
        {
            if(obstacleGrid[0][i] != 1) dp[0][i] = 1;
            else break;
        }
        
        return solve(dp, m, n, obstacleGrid);
    }
    public int solve(int[][] dp, int m, int n, int[][] obstacleGrid)
    {
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(obstacleGrid[i][j] != 1)
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                else
                    dp[i][j] = 0;
            }
        }
        
        return dp[m-1][n-1];
    }
}