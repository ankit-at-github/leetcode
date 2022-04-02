class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        if(mat.length==0 ||(m*n != r*c)) return mat;
        
        int[][] reshape = new int[r][c];
        int row = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                reshape[row/c][row%c] = mat[i][j];
                row++;
            }
        }
        return reshape;
    }
}