class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length-1;
        for(int i=0; i<matrix.length; i++){
            if(target <= matrix[i][col]) return binarySearch(matrix, target, i);
        }
        return false;
    }
    public boolean binarySearch(int[][] matrix, int target, int row){
        int low = 0, high = matrix[0].length;
        while(low < high){
            int mid = low + (high-low) / 2;
            if(matrix[row][mid] == target) return true;
            else{
                if(matrix[row][mid] > target){
                    high = mid;
                }
                else
                    low = mid+1;
            }
        }
        return false;
    }
}