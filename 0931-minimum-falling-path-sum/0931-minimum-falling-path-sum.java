class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++) memo[i][j] = -1;
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int j=0; j<n; j++)
        {
            mini = Math.min(mini, minSum(0, j, m, n, matrix, memo));
        }
        return mini;
    }
    public int minSum(int x, int y, int m, int n, int[][] matrix, int[][] memo)
    {    
        if(y < 0 || y >= n) return 10000000;
        
        if(x == m-1) return matrix[x][y];
        
        if(memo[x][y] != -1) return memo[x][y];
        
        int min = Integer.MAX_VALUE;
        
        //diagonal1
        int diagonal1 = matrix[x][y] + minSum(x+1, y-1, m, n, matrix, memo);
            
        //down
        int down = matrix[x][y] + minSum(x+1, y, m, n, matrix, memo);
            
        //diagonal2
        int diagonal2 = matrix[x][y] + minSum(x+1, y+1, m, n, matrix, memo);
            
        min = Math.min(diagonal1, Math.min(down, diagonal2));
        
        return memo[x][y] = min;
    }
}