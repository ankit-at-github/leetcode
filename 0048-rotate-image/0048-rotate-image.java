class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i < j){
                    swap(matrix, i, j);
                }
            }
        }
        reverse(matrix);
    }
    public void swap(int[][] matrix, int a , int b){
        int temp = matrix[a][b];
        matrix[a][b] = matrix[b][a];
        matrix[b][a] = temp;
    }
    public void reverse(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            int left = 0, right = n-1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}