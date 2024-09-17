class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(memo[i], -1);
        return solve(0, 0, m, n, memo);
    }
    public int solve(int x, int y, int m, int n, int[][] memo){
        // 1. Base Case
        
        //not my path
        if(x < 0 || y < 0 || x >= m || y >= n) return 0;
        
        if(x == m-1 && y == n-1){
            return 1;
        }
        
        if(memo[x][y] != -1) return memo[x][y];
        
        // 2. Exploring ways
        //right
        int right = solve(x, y+1, m, n, memo);
        //down
        int down = solve(x+1, y, m, n, memo);
        
        return memo[x][y] = right + down;
    }
}