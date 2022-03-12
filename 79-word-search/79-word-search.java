class Solution {
    public boolean present(char[][] board, int x, int y, String word, int index, boolean[][] visited)
    {
        if(index == word.length()) return true;
        
        if(x<0 || x>=board.length || y<0 || y>=board[0].length || visited[x][y]) return false;
        
        if(board[x][y] != word.charAt(index)) return false;
        
        visited[x][y] = true;
        
        if(present(board, x, y+1, word, index+1, visited)||
            present(board, x+1, y, word, index+1, visited)||
            present(board, x, y-1, word, index+1, visited)||
            present(board, x-1, y, word, index+1, visited)) return true;
        
        visited[x][y] = false;
        
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                if(board[i][j] == word.charAt(0) && present(board, i, j, word, 0, visited)) return true;
            }
        }
        
        return false;
    }
}