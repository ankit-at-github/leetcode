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
        //Travelling in all direction
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, +1, 0, -1};
        while(!q.isEmpty())
        {
            int[] values = q.poll();
            int x = values[0];
            int y = values[1];
            int d = values[2];
            
            ans[x][y] = d;
            
            for(int i=0; i<4; i++)
            {
                int nRow = x + delRow[i];
                int nCol = y + delCol[i];
                
                if(nRow < 0 || nCol < 0 || nRow >= m || nCol >= n || visited[nRow][nCol] == true) continue;
                
                visited[nRow][nCol] = true;
                q.add(new int[]{nRow, nCol, d+1});
            }
        }
        return ans;
    }
}