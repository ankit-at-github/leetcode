class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(dfs(i, j, board, visited, 0, word)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int x, int y, char[][] board, boolean[][] visited, int index, String word)
    {
        if(index >= word.length()) return true;
        
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] ||
           board[x][y] != word.charAt(index)) return false;
        
        visited[x][y] = true;
        
        if(dfs(x, y+1, board, visited, index+1, word) ||
           dfs(x+1, y, board, visited, index+1, word) ||
           dfs(x-1, y, board, visited, index+1, word) ||
           dfs(x, y-1, board, visited, index+1, word)) return true;
        
        visited[x][y] = false;
        
        return false;
    }
}