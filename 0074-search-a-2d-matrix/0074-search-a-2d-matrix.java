class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n - 1;
        while(low <= high){
            int index = low + (high - low) / 2;
            int row = index / n;
            int col = index % n;
            if(matrix[row][col] == target) return true;
            
            if(matrix[row][col] < target){
                low = index+1;
            }
            else{
                high = index-1;
            }
        }
        return false;
    }
    
    
}