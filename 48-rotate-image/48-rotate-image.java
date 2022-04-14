class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    public void transpose(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i=0; i<row; i++)
        {
            for(int j=i; j<col; j++)
            {
                swap(matrix, i, j);
            }
        }
    }
    public void reverse(int[][] matrix)
    {
        for(int i=0; i<matrix.length; i++)
        {
            int start = 0;
            int end = matrix[i].length-1;
            while(start < end)
            {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
    public void swap(int[][] matrix, int i, int j)
    {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}