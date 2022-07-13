class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        //Storing all rotten oranges place
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                if(grid[i][j] == 1) freshOranges++;
            }
        }
        
        if(freshOranges == 0) return 0;
        
        int time = -1;
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                int x = q.peek()[0];
                int y = q.poll()[1];
                
                //Up
                if(isSafe(grid, x-1, y, m, n))
                {
                    grid[x-1][y] = 2;
                    q.add(new int[]{x-1, y});
                }
                //left
                if(isSafe(grid, x, y-1, m, n))
                {
                    grid[x][y-1] = 2;
                    q.add(new int[]{x, y-1});
                }
                //right
                if(isSafe(grid, x, y+1, m, n))
                {
                    grid[x][y+1] = 2;
                    q.add(new int[]{x, y+1});
                }
                //down
                if(isSafe(grid, x+1, y, m, n))
                {
                    grid[x+1][y] = 2;
                    q.add(new int[]{x+1, y});
                }
                
            }
            time++;
        }
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1) return -1;
            }
        }
        
        return time;
    }
    public boolean isSafe(int[][] grid, int x, int y, int m, int n)
    {
        if(x < 0 || x >=m || y < 0 || y >= n || grid[x][y] == 0 || grid[x][y] == 2) return false;
        return true;
    }
}