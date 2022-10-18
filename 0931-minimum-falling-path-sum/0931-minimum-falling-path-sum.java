class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        for(int j=0; j<n; j++) dp[m-1][j] = matrix[m-1][j];
        
        for(int i=m-2; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                int diagonal1 = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                int diagonal2 = Integer.MAX_VALUE;
                
                if(j-1 >= 0) diagonal1 = matrix[i][j] + dp[i+1][j-1];
                
                down = matrix[i][j] + dp[i+1][j];
                
                if(j+1 < n) diagonal2 = matrix[i][j] + dp[i+1][j+1];
                
                dp[i][j] = Math.min(diagonal1, Math.min(down, diagonal2));
            }
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int j=0; j<n; j++)
        {
            mini = Math.min(mini, dp[0][j]);
        }
        
        return mini;
    }
}