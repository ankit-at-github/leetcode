class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++)
        {
            //checking the first cell of each row to mark first column
            if(matrix[i][0] == 0) isCol = true;
            
            for(int j=1; j<n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        //marking first row.
        if(matrix[0][0] == 0) for(int j=0; j<n; j++) matrix[0][j] = 0;
        //marking first column.
        if(isCol) for(int i=0; i<m; i++) matrix[i][0] = 0;
    }
}