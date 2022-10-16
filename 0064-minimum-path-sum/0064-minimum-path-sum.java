class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else
                {
                    int right = 100000000, down = 100000000;
                    
                    if(j > 0) right = grid[i][j] + dp[i][j-1];
                    if(i > 0) down = grid[i][j] + dp[i-1][j];
                    
                    dp[i][j] = Math.min(right, down);
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}