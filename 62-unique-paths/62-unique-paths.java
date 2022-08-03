class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return dfs(0, 0, m, n, dp);
    }
    public int dfs(int x, int y, int m, int n, int[][] dp)
    {
        //Not a valid path
        if(x < 0 || y < 0|| x >= m || y >= n) return 0;
        
        //Destination
        if(x == m-1 && y == n-1) return 1;
        
        //Already visited path
        if(dp[x][y] > 0) return dp[x][y];
        
        //Storing number of path from each cell
        return dp[x][y] = dfs(x, y+1, m, n, dp) + dfs(x+1, y, m, n, dp);
    }
}