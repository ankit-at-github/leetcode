class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int x, int y, char[][] grid)
    {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return;
        
        grid[x][y] = '0';
        
        dfs(x-1,y,grid);
        dfs(x+1,y,grid);
        dfs(x,y-1,grid);
        dfs(x,y+1,grid);
    }
}