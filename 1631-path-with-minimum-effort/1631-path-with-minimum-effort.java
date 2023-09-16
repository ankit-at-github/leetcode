class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int effort = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty())
        {
            int[] values = pq.poll();
            int x = values[0];
            int y = values[1];
            int dist = values[2];
            
            effort = Math.max(effort, dist);
            
            if(x==m-1 && y==n-1) return effort;
            
            visited[x][y] = true;
            //Left
            if(validPath(x, y-1, m, n, visited))
            {
                pq.add(new int[]{x,y-1,Math.abs(heights[x][y] - heights[x][y-1])});
            }
            //Right
             if(validPath(x, y+1, m, n, visited))
            {
                pq.add(new int[]{x,y+1,Math.abs(heights[x][y] - heights[x][y+1])});
            }
            //Top
             if(validPath(x-1, y, m, n, visited))
            {
                pq.add(new int[]{x-1,y,Math.abs(heights[x][y] - heights[x-1][y])});
            }
            //Down
             if(validPath(x+1, y, m, n, visited))
            {
                pq.add(new int[]{x+1,y,Math.abs(heights[x][y] - heights[x+1][y])});
            }
        }
        return effort;
    }
    public boolean validPath(int x, int y, int m, int n, boolean[][] visited)
    {
        if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] == true) return false;
        return true;
    }
}