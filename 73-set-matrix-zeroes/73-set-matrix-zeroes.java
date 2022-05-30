class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstCol = false;
        
        for(int i=0; i<matrix.length; i++)
        {
            if(matrix[i][0] == 0) firstCol = true;
            for(int j=1; j<matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //checking first element of all rows and all cols from 1st row.
        for(int i=1; i<matrix.length; i++)
        {
            for(int j=1; j<matrix[0].length; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        
        //checking for firstCell
        if(matrix[0][0] == 0)
        {
            for(int j=0; j<matrix[0].length; j++) matrix[0][j] = 0;
        }
        
        //checking for first column
        if(firstCol)
        {
            for(int i=0; i<matrix.length; i++) matrix[i][0] = 0;
        }
    }
}