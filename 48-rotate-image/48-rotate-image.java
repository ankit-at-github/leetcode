class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix, n);
        reverse(matrix, n);
    }
    public void swap(int[][] matrix, int i, int j)
    {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    public void transpose(int[][] matrix, int n)
    {
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                swap(matrix, i, j);
            }
        }
    }
    public void reverse(int[][] matrix, int n)
    {
        int start = 0, end = matrix[0].length-1;
        while(start <= end)
        {
            for(int i=0; i<n; i++)
            {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
            }
            start++;
            end--;
        }
    }
}