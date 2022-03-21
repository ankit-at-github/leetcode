class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        
        int numberofIslands = 0;
        
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    numberofIslands+=dfs(grid, i, j);
                }
            }
        }
        return numberofIslands;
    }
    public int dfs(char[][] grid, int i, int j)
    {
        //boundary check
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0') return 0;
        
        grid[i][j] = '0';
        
        //left, right, top, bottom
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        
        return 1;
    }
}