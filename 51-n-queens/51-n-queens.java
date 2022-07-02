class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                chessBoard[i][j] = '.';
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        solve(0, chessBoard, ans, n);
        
        return ans;
    }
    public boolean isSafe(int row, int col, char[][] chessBoard, int n)
    {
        int rowCopy = row;
        int colCopy = col;
        
        //left-up diagonal
        while(rowCopy >=0 && colCopy >=0)
        {
            if(chessBoard[rowCopy][colCopy] == 'Q') return false;
            rowCopy--;
            colCopy--;
        }
        
        //left
        rowCopy = row;
        colCopy = col;
        while(colCopy >= 0)
        {
            if(chessBoard[rowCopy][colCopy] == 'Q') return false;
            colCopy--;
        }
        
        //left-down diagonal
        rowCopy = row;
        colCopy = col;
        while(rowCopy < n && colCopy >=0)
        {
            if(chessBoard[rowCopy][colCopy] == 'Q') return false;
            rowCopy++;
            colCopy--;
        }
        return true;
    }
    public void solve(int col, char[][] chessBoard, List<List<String>> ans, int n)
    {
        if(col == n)
        {
            List<String> res = new ArrayList<>();
            for(int i=0; i<n; i++)
            {
                String s = new String(chessBoard[i]);
                res.add(s);
            }
            ans.add(res);
            return;
        }
        for(int row=0; row<n; row++)
        {
            if(isSafe(row, col, chessBoard, n))
            {
                chessBoard[row][col] = 'Q';
                solve(col+1, chessBoard, ans, n);
                chessBoard[row][col] = '.';
            }
        }
    }
}