class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        
        //Top and Last Row
        for(int j=0; j<n; j++)
        {
            dfs(0, j, m, n, Integer.MIN_VALUE, pacific, heights);
            dfs(m-1, j, m, n, Integer.MIN_VALUE, atlantic, heights);
        }
        //First and Last Column
        for(int i=0; i<m; i++)
        {
            dfs(i, 0, m, n, Integer.MIN_VALUE, pacific, heights);
            dfs(i, n-1, m, n, Integer.MIN_VALUE, atlantic, heights);
        }
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1)
                    ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }
    public void dfs(int x, int y, int m, int n, int prev, int[][] ocean, int[][] heights)
    {
        if(x < 0 || y < 0 || x >= m || y >= n || heights[x][y] < prev || ocean[x][y] == 1) return;
        
        ocean[x][y] = 1;
        
        dfs(x-1, y, m, n, heights[x][y], ocean, heights);
        dfs(x+1, y, m, n, heights[x][y], ocean, heights);
        dfs(x, y-1, m, n, heights[x][y], ocean, heights);
        dfs(x, y+1, m, n, heights[x][y], ocean, heights);
    }
}