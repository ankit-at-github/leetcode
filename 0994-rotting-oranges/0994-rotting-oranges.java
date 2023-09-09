class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1) freshOranges++;
                if(grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        if(freshOranges == 0) return 0;
        int minutes = -1;
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                int x = q.peek()[0];
                int y = q.poll()[1];
                
                if(valid(x+1, y, m, n, grid))
                {
                    grid[x+1][y] = 2;
                    freshOranges--;
                    q.add(new int[]{x+1, y});
                }
                if(valid(x, y+1, m, n, grid))
                {
                    grid[x][y+1] = 2;
                    freshOranges--;
                    q.add(new int[]{x, y+1});
                }
                if(valid(x-1, y, m, n, grid))
                {
                    grid[x-1][y] = 2;
                    freshOranges--;
                    q.add(new int[]{x-1, y});
                }
                if(valid(x, y-1, m, n, grid))
                {
                    grid[x][y-1] = 2;
                    freshOranges--;
                    q.add(new int[]{x, y-1});
                }
            }
            minutes++;
        }
        if(freshOranges!=0) return -1;
        return minutes;
    }
    public boolean valid(int x, int y, int m, int n, int[][] grid)
    {
        if(x<0 || y<0 || x>=m || y>=n || grid[x][y]!=1) return false;
        return true;
    }
}