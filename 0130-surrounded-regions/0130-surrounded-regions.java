class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //traverse first & last row
        for(int j=0; j<n; j++)
        {
            //first row
            if(!visited[0][j] && board[0][j] == 'O')
            {
                dfs(0, j, visited, board);
            }
            //last row
            if(!visited[m-1][j] && board[m-1][j] == 'O')
            {
                dfs(m-1, j, visited, board);
            }
        }
        //traverse first and last column
        for(int i=0; i<m; i++)
        {
            //first column
            if(!visited[i][0] && board[i][0] == 'O')
            {
                dfs(i, 0, visited, board);
            }
            //last row
            if(!visited[i][n-1] && board[i][n-1] == 'O')
            {
                dfs(i, n-1, visited, board);
            }
        }
        //Updating matrix
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(!visited[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void dfs(int x, int y, boolean[][] visited, char[][] board)
    {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || 
           visited[x][y] == true || board[x][y] == 'X') return;
        
        visited[x][y] = true;
        //check for top, bottom, left, right
        dfs(x-1, y, visited, board);
        dfs(x+1, y, visited, board);
        dfs(x, y-1, visited, board);
        dfs(x, y+1, visited, board);
    }
}