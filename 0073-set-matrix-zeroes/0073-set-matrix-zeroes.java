class Solution {
    public void setZeroes(int[][] matrix) {
        //Not touching corners of matrix
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        //Row
        for(int r :rows)
        {
            for(int j=0; j<n; j++) matrix[r][j] = 0;
        }
        
        //Cols
        for(int c :cols)
        {
            for(int i=0; i<m; i++) matrix[i][c] = 0;
        }
    }
}