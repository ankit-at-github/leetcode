class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        
        boolean[][] visited = new boolean[m][n];
        int maxi = Integer.MAX_VALUE;
        while(!pq.isEmpty())
        {
            int x = pq.peek()[0];
            int y = pq.peek()[1];
            int score = pq.poll()[2];
            
            maxi = Math.min(maxi, score);
            
            if(x == m-1 && y == n-1) return maxi;
            
            visited[x][y] = true;
            
            //UP
            if(valid(x-1, y, m, n, visited))
            {
                pq.add(new int[]{x-1, y, grid[x-1][y]});
            }
            //DOWN
            if(valid(x+1, y, m, n, visited))
            {
                pq.add(new int[]{x+1, y, grid[x+1][y]});
            }
            //LEFT
            if(valid(x, y-1, m, n, visited))
            {
                pq.add(new int[]{x, y-1, grid[x][y-1]});
            }
            //RIGHT
            if(valid(x, y+1, m, n, visited))
            {
                pq.add(new int[]{x, y+1, grid[x][y+1]});
            }
        }
        
        return -1;
    }
    public boolean valid(int x, int y, int m, int n, boolean[][] visited)
    {
        if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) return false;
        return true;
    }
}