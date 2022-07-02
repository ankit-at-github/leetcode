class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board)
    {   
        for(int row=0; row<9; row++)
        {
            for(int col=0; col<9; col++)
            {
                if(board[row][col] == '.')
                {
                    for(char c='1'; c<='9'; c++)
                    {
                        if(possible(board, row, col, c))
                        {
                            board[row][col] = c;
                            
                            if(solve(board)) return true;
                            
                            else board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean possible(char[][] board, int row, int col, char c)
    {
        for(int i=0; i<9; i++)
        {
            //1.checking row
            if(board[i][col] == c) return false;
            
            //2.checking column
            if(board[row][i] == c) return false;
            
            //3.each box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        
        return true;
    }
}