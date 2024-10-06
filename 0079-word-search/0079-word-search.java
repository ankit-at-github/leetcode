class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(wordSearch(board, i, j, m, n, 0, word, new boolean[m][n])) return true;
                }
            }
        }
        return false;
    }
    public boolean wordSearch(char[][] board, int x, int y, int m, int n, int index, String word, boolean[][] visited){
        if(index >= word.length()) return true;
        
        if(x < 0 || y < 0 || x >=m || y>= n || visited[x][y] || board[x][y] != word.charAt(index)) return false;
        
        visited[x][y] = true;
        
        boolean right = wordSearch(board, x, y+1, m, n, index+1, word, visited);
        boolean down = wordSearch(board, x+1, y, m, n, index+1, word, visited);
        boolean left = wordSearch(board, x, y-1, m, n, index+1, word, visited);
        boolean up = wordSearch(board, x-1, y, m, n, index+1, word, visited);
        
        visited[x][y] = false;
        
        return (right||down||left||up);
    }
}