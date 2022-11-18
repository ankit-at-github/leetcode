class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++) memo[i][j] = -1;
        }
        return totalPaths(0, 0, m, n, memo, obstacleGrid);
    }
    public int totalPaths(int x, int y, int m, int n, int[][] memo, int[][] grid)
    {
        if(x == m-1 && y == n-1)
        {
            return 1;
        }
        
        if(memo[x][y] != -1) return memo[x][y];
        
        int count = 0;
        //down
        if(isValid(x+1, y, m, n, grid))
        {
            count += totalPaths(x+1, y, m, n, memo, grid);
        }
        //right
        if(isValid(x, y+1, m, n, grid))
        {
            count+= totalPaths(x, y+1, m, n, memo, grid);
        }
        return memo[x][y] = count;
    }
    public boolean isValid(int x, int y, int m, int n, int[][] grid)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1) return false;
        return true;
    }
}