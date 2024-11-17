class Solution {
    public boolean isValidSudoku(char[][] board) {
        //We just need to check if sudoku is valid or not.
        for(int i=0; i<9; i++){
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                //to get the current box
                int boxRow = 3*(i/3) + j/3;
                int boxCol = 3*(i%3) + j%3;
                if(board[boxRow][boxCol] != '.' && !box.add(board[boxRow][boxCol])) return false;
            }
        }
        return true;
    }
}