class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        return bfsSPBM(grid, grid.length);
    }
    public int bfsSPBM(int[][] grid, int n)
    {
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        int mini = -1;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0, 0, 1});
        
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                int x = q.peek()[0];
                int y = q.peek()[1];
                int cost = q.poll()[2];
                
                //grid[x][y] = 1;
                
                if(x == n-1 && y == n-1)
                {
                    if(mini!=-1) mini = Math.min(mini, cost);
                    else mini = cost;
                }
                
                //1
                if(isValid(x-1, y-1, grid, n))
                {
                    grid[x-1][y-1] = 1;
                    q.add(new int[]{x-1, y-1, cost+1});
                }
                //2
                if(isValid(x-1, y, grid, n))
                {
                    grid[x-1][y] = 1;
                    q.add(new int[]{x-1, y, cost+1});
                }
                //3
                if(isValid(x-1, y+1, grid, n))
                {
                    grid[x-1][y+1] = 1;
                    q.add(new int[]{x-1, y+1, cost+1});
                }
                //4
                if(isValid(x, y-1, grid, n))
                {
                    grid[x][y-1] = 1;
                    q.add(new int[]{x, y-1, cost+1});
                }
                //5
                if(isValid(x, y+1, grid, n))
                {
                    grid[x][y+1] = 1;
                    q.add(new int[]{x, y+1, cost+1});
                }
                //6
                if(isValid(x+1, y-1, grid, n))
                {
                    grid[x+1][y-1] = 1;
                    q.add(new int[]{x+1, y-1, cost+1});
                }
                //7
                if(isValid(x+1, y, grid, n))
                {
                    grid[x+1][y] = 1;
                    q.add(new int[]{x+1, y, cost+1});
                }
                //8
                if(isValid(x+1, y+1, grid, n))
                {
                    grid[x+1][y+1] = 1;
                    q.add(new int[]{x+1, y+1, cost+1});
                }
            }
        }
        
        return mini;
    }
    public boolean isValid(int x, int y, int[][] grid, int n)
    {
        if(x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1) return false;
        return true;
    }
}