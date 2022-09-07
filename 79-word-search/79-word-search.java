class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    visited = new boolean[m][n];
                    if(dfs(i, j, m, n, 0, word, board, visited)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int x, int y, int m, int n, int index, String word, char[][] board, boolean[][] visited)
    {
        if(index == word.length()) return true;
        
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || board[x][y] != word.charAt(index)) return false;
        
        visited[x][y] = true;
        
        if(dfs(x, y+1, m, n, index+1, word, board, visited) || 
           dfs(x+1, y, m, n, index+1, word, board, visited) || 
           dfs(x, y-1, m, n, index+1, word, board, visited) || 
           dfs(x-1, y, m, n, index+1, word, board, visited)) return true;
        
        visited[x][y] = false;
        
        return false;
    }
}