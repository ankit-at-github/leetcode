class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else
                {
                    if(i == 0 && j == 0) dp[i][j] = 1;
                    else
                    {
                        int right = 0, down = 0;
                        if(i > 0) down = dp[i-1][j];
                        if(j > 0) right = dp[i][j-1];
                        
                        dp[i][j] = down + right;
                    }
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}