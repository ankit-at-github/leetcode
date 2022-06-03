class NumMatrix {

    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(j == 0) dp[i][j] = matrix[i][j];
                else
                {
                    dp[i][j] = matrix[i][j] + dp[i][j-1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
       if (row2 >= dp.length || col2 >= dp[0].length || row1 < 0 || col1 < 0) return -1;
        
		int sum = 0;
        
		for (int i = row1; i <= row2; i++) 
        {
			sum = sum + (dp[i][col2] - (col1 > 0 ? dp[i][col1 - 1] : 0));
		}
		return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */