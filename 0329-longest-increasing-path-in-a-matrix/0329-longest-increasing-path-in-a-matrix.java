class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++)
        {
            Arrays.fill(memo[i], -1);
        }
        
        int maxi = 0;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int path = dfs(i, j, m, n, matrix, memo);
                maxi = Math.max(maxi, path);
            }
        }
        return maxi+1;
    }
    public int dfs(int x, int y, int m, int n, int[][] matrix, int[][] memo)
    {
        int l=0, r=0, u=0, d=0;
        
        if(memo[x][y] != -1) return memo[x][y];
        
        //left
        if(validPath(x, y-1, m, n) && matrix[x][y] < matrix[x][y-1])
        {
            l = 1 + dfs(x, y-1, m, n, matrix, memo);
        }
        
        //right
        if(validPath(x, y+1, m, n) && matrix[x][y] < matrix[x][y+1])
        {
            r = 1 + dfs(x, y+1, m, n, matrix, memo);
        }
        
        //up
        if(validPath(x-1, y, m, n) && matrix[x][y] < matrix[x-1][y])
        {
            u = 1 + dfs(x-1, y, m, n, matrix, memo);
        }
        
        //down
        if(validPath(x+1, y, m, n) && matrix[x][y] < matrix[x+1][y])
        {
            d = 1 + dfs(x+1, y, m, n, matrix, memo);
        }
        
        return memo[x][y] = Math.max(l, Math.max(r, Math.max(u, d)));
    }
    public boolean validPath(int x, int y, int m, int n)
    {
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        return true;
    }   
}