class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(memo[i], -1);
        
        return minSum(m-1, n-1, grid, memo);
    }
    public int minSum(int m, int n, int[][] grid, int[][] memo)
    {
        if(m < 0 || n < 0) return 1000000;
        
        //base case
        if(m == 0 && n == 0) return grid[m][n];
        
        if(memo[m][n] != -1) return memo[m][n];
        
        int up = grid[m][n] + minSum(m-1, n, grid, memo);
        int left = grid[m][n] + minSum(m, n-1, grid, memo);
        
        return memo[m][n] = Math.min(up, left);
    }
}