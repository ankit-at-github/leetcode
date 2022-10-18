class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        for(int j=0; j<n; j++) dp[0][j] = matrix[0][j];
        
        for(int i=1; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int diagonal1 = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                int diagonal2 = Integer.MAX_VALUE;
                
                if(j-1 >= 0) diagonal1 = matrix[i][j] + dp[i-1][j-1];
                
                down = matrix[i][j] + dp[i-1][j];
                
                if(j+1 < n) diagonal2 = matrix[i][j] + dp[i-1][j+1];
                
                dp[i][j] = Math.min(diagonal1, Math.min(down, diagonal2));
            }
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int j=0; j<n; j++)
        {
            mini = Math.min(mini, dp[m-1][j]);
        }
        
        return mini;
    }
//     public int minSum(int x, int y, int m, int n, int[][] matrix, int[][] memo)
//     {    
//         if(y < 0 || y >= n) return 10000000;
        
//         if(x == m-1) return matrix[x][y];
        
//         if(memo[x][y] != -1) return memo[x][y];
        
//         int min = Integer.MAX_VALUE;
        
//         //diagonal1
//         int diagonal1 = matrix[x][y] + minSum(x+1, y-1, m, n, matrix, memo);
            
//         //down
//         int down = matrix[x][y] + minSum(x+1, y, m, n, matrix, memo);
            
//         //diagonal2
//         int diagonal2 = matrix[x][y] + minSum(x+1, y+1, m, n, matrix, memo);
            
//         min = Math.min(diagonal1, Math.min(down, diagonal2));
        
//         return memo[x][y] = min;
//     }
}