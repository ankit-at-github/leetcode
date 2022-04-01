class Solution {
    public void rotate(int[][] matrix) {
        //Question is tough when said without using extra memory
        int n = matrix.length;
        
        //Transpose of matrix - inplace only possible when matrix is of size nxn as the size might differ
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //Reflect from start column till mid
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n/2; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}