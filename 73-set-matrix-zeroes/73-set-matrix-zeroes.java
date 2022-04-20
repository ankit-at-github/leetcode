class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col = false;
        for(int i=0; i<matrix.length; i++)
        {
            if(matrix[i][0] == 0)
            {
                col = true;
            }
            for(int j=1; j<matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<matrix.length; i++)
        {
            for(int j=1; j<matrix[i].length; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        
        //marking first row if it is zero.
        if(matrix[0][0] == 0)
        {
            for(int i=0; i<matrix[0].length; i++) matrix[0][i] = 0;
        }
        
        //marking first column if col is true which means first column should be marked 0.
        if(col)
        {
            for(int i=0; i<matrix.length; i++) matrix[i][0] = 0;
        }
    }
}