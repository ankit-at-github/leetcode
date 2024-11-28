class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, m, n, board, 0, word)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int x, int y, int m, int n, char[][] board, int index, String word){
        if(index >= word.length()) return true;
        
        if(x < 0 || y < 0 || x >= m || y >= n || board[x][y] != word.charAt(index)) return false;
        
        board[x][y] = '#';
        
        boolean right = dfs(x, y+1, m, n, board, index+1, word);
        boolean down = dfs(x+1, y, m, n, board, index+1, word);
        boolean left = dfs(x, y-1, m, n, board, index+1, word);
        boolean top = dfs(x-1, y, m, n, board, index+1, word);
        
        board[x][y] = word.charAt(index);
        
        return (right || down || left || top);
    }
}