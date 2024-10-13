class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, m, n, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int x, int y, int m, int n, char[][] grid){
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0') return;
        
        grid[x][y] = '0';
        
        dfs(x, y+1, m, n, grid);
        dfs(x+1, y, m, n, grid);
        dfs(x, y-1, m, n, grid);
        dfs(x-1, y, m, n, grid);
    }
}