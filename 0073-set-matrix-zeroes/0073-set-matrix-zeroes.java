class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstCol = false;
        for(int i=0; i<m; i++){
            //first col has zero, only checking once
            if(matrix[i][0] == 0) firstCol = true;
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        
        //firstRow
        if(matrix[0][0] == 0){
            for(int j=1; j<n; j++) matrix[0][j] = 0;
        }
        //firstCol
        if(firstCol){
            for(int i=0; i<m; i++) matrix[i][0] = 0;
        }
    }
}