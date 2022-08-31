class Solution {
    boolean pacific = false;
    boolean atlantic = false;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                boolean[][] visited = new boolean[m][n];
                
                dfs(i, j, m, n, heights, visited);
                
                if(pacific && atlantic) ans.add(Arrays.asList(i,j));
                
                pacific = false;
                atlantic = false;
            }
        }
        return ans;
    }
    public void dfs(int x, int y, int m, int n, int[][] heights, boolean[][] visited)
    {   
        visited[x][y] = true;
        
        //North
        if(valid(x-1, y, m, n, visited) && heights[x][y] >= heights[x-1][y])
        {
            dfs(x-1, y, m, n, heights, visited);
        }
        //East
        if(valid(x, y+1, m, n, visited) && heights[x][y] >= heights[x][y+1])
        {
            dfs(x, y+1, m, n, heights, visited);
        }
        //South
        if(valid(x+1, y, m, n, visited) && heights[x][y] >= heights[x+1][y])
        {
            dfs(x+1, y, m, n, heights, visited);
        }
        //West
        if(valid(x, y-1, m, n, visited) && heights[x][y] >= heights[x][y-1])
        {
            dfs(x, y-1, m, n, heights, visited);
        }
    }
    public boolean valid(int x, int y, int m, int n, boolean[][] visited)
    {   
        if(x < 0 || y < 0)
        {
            pacific = true;
            return false;
        }
        
        if(x >= m || y >= n)
        {
            atlantic = true;
            return false;
        }
        if(visited[x][y]) return false;
        return true;
    }
}