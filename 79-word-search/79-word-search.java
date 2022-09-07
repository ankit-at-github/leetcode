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
                    if(dfs(m, n, i, j, word, 0, board, visited)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int m, int n, int x, int y, String word, int index, char[][] board, boolean[][] visited)
    {
        if(index == word.length()) return true;
        
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || board[x][y] != word.charAt(index)) return false;
        
        visited[x][y] = true;
        
        boolean result = 
            dfs(m, n, x, y+1, word, index+1, board, visited) || 
            dfs(m, n, x+1, y, word, index+1, board, visited) || 
            dfs(m, n, x, y-1, word, index+1, board, visited) || 
            dfs(m, n, x-1, y, word, index+1, board, visited);
        
        visited[x][y] = false;
        
        return result;
    }
}