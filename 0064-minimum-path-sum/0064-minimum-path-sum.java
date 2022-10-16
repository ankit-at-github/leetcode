class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] memo = new int[m][n];
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++) memo[i][j] = -1;
        }
        
        return totalSum(0, 0, m, n, grid, memo);
    }
    public int totalSum(int x, int y, int m, int n, int[][] grid, int[][] memo)
    {
        if(x == m-1 && y == n-1) return grid[x][y];
        
        if(x < 0 || y < 0 || x >= m || y >= n) return 1000000000;
        
        if(memo[x][y] != -1) return memo[x][y];
        
        //down
        int down = grid[x][y] + totalSum(x+1, y, m, n, grid, memo);
        
        //right
        int right = grid[x][y] + totalSum(x, y+1, m, n, grid, memo);
        
        return memo[x][y] = Math.min(down, right);
    }
}