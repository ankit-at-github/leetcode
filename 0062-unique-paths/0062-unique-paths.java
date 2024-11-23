class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(memo[i], - 1);
        return dfs(memo, m-1, n-1, m, n);
    }
    public int dfs(int[][] memo, int x, int y, int m, int n){
        
        if(x < 0 || y < 0 || x >= m || y >= n) return 0;
        
        if(memo[x][y] != -1) return memo[x][y];
            
        if(x == 0 && y == 0) return 1;
        
        int up = dfs(memo, x-1, y, m, n);
        int left = dfs(memo, x, y-1, m, n);
        
        return memo[x][y] = up + left;
    }
}