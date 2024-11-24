class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        //1. Find Row
        int i = 0;
        while(i < m){
            if(target <= matrix[i][n-1]) break;
            i++;
        }
        int low = 0, high = n-1;
        while(i < m && low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[i][mid] == target) return true;
            
            if(matrix[i][mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
    
}