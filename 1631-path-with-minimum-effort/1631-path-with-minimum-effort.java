class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(new int[]{0, 0, 0});
        
        boolean[][] visited = new boolean[m][n];
        while(!pq.isEmpty())
        {
            int x = pq.peek()[0];
            int y = pq.peek()[1];
            int diff = pq.poll()[2];
            
            if(x == m-1 && y == n-1) return diff;
            
            visited[x][y] = true;
            
            //UP
            if(valid(x-1, y, m, n, visited))
            {
                int maxdiff = Math.max(diff, Math.abs(heights[x][y] - heights[x-1][y]));
                pq.add(new int[]{x-1, y, maxdiff});
            }
            //DOWN
            if(valid(x+1, y, m, n, visited))
            {
                int maxdiff = Math.max(diff, Math.abs(heights[x][y] - heights[x+1][y]));
                pq.add(new int[]{x+1, y, maxdiff});
            }
            //LEFT
            if(valid(x, y-1, m, n, visited))
            {
                int maxdiff = Math.max(diff, Math.abs(heights[x][y] - heights[x][y-1]));
                pq.add(new int[]{x, y-1, maxdiff});
            }
            //RIGHT
            if(valid(x, y+1, m, n, visited))
            {
                int maxdiff = Math.max(diff, Math.abs(heights[x][y] - heights[x][y+1]));
                pq.add(new int[]{x, y+1, maxdiff});
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