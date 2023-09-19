class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty())
        {
            int[] values = q.poll();
            int x = values[0];
            int y = values[1];
            int d = values[2];
            
            ans[x][y] = d;
    
            if(validPath(x-1, y, m, n, visited))
            {
                visited[x-1][y] = true;
                if(mat[x-1][y] == 1) q.add(new int[]{x-1, y, d+1});
                else q.add(new int[]{x-1, y, d});
            }
            if(validPath(x+1, y, m, n, visited))
            {
                visited[x+1][y] = true;
                if(mat[x+1][y] == 1) q.add(new int[]{x+1, y, d+1});
                else q.add(new int[]{x+1, y, d});
            }
            if(validPath(x, y-1, m, n, visited))
            {
                visited[x][y-1] = true;
                if(mat[x][y-1] == 1) q.add(new int[]{x, y-1, d+1});
                else q.add(new int[]{x, y-1, d});
            }
            if(validPath(x, y+1, m, n, visited))
            {
                visited[x][y+1] = true;
                if(mat[x][y+1] == 1) q.add(new int[]{x, y+1, d+1});
                else q.add(new int[]{x, y+1, d});
            }
        }
        return ans;
    }
    public boolean validPath(int x, int y, int m, int n, boolean[][] visited)
    {
        if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] == true) return false;
        return true;
    }
}