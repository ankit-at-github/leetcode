class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(wordSearch(board, i, j, m, n, 0, word)) return true;
                }
            }
        }
        return false;
    }
    public boolean wordSearch(char[][] board, int x, int y, int m, int n, int index, String word){
        if(x < 0 || y < 0 || x >=m || y>= n || board[x][y] != word.charAt(index)) return false;
        
        if(index == word.length()-1) return true;
        
        board[x][y] = '#';
        
        boolean right = wordSearch(board, x, y+1, m, n, index+1, word);
        boolean down = wordSearch(board, x+1, y, m, n, index+1, word);
        boolean left = wordSearch(board, x, y-1, m, n, index+1, word);
        boolean up = wordSearch(board, x-1, y, m, n, index+1, word);
        
        board[x][y] = word.charAt(index);
        
        return (right||down||left||up);
    }
}