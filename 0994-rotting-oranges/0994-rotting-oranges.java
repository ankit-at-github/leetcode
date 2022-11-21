class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int fresh_oranges = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1) fresh_oranges++;
                if(grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        
        if(fresh_oranges == 0) return 0;
        
        int time = -1;
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                int[] coordinate = q.poll();
                int x = coordinate[0];
                int y = coordinate[1];
                
                //up
                if(validCell(x-1, y, grid))
                {
                    fresh_oranges--;
                    grid[x-1][y] = 2;
                    q.add(new int[]{x-1, y});
                }
                //down
                if(validCell(x+1, y, grid))
                {
                    fresh_oranges--;
                    grid[x+1][y] = 2;
                    q.add(new int[]{x+1, y});
                }
                //left
                if(validCell(x, y-1, grid))
                {
                    fresh_oranges--;
                    grid[x][y-1] = 2;
                    q.add(new int[]{x, y-1});
                }
                //right
                if(validCell(x, y+1, grid))
                {
                    fresh_oranges--;
                    grid[x][y+1] = 2;
                    q.add(new int[]{x, y+1});
                }
            }
            time++;
        }
        return fresh_oranges == 0?time:-1;
    }
    public boolean validCell(int x, int y, int[][] grid)
    {
        if(x < 0 || x >= grid.length || y < 0 || y>=grid[0].length || grid[x][y]!=1) return false;
        return true;
    }
}