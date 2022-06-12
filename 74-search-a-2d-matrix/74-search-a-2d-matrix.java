class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        for(; row<matrix.length; row++)
        {
            if(target <= matrix[row][matrix[0].length-1]) break;
        }
        if(row >= matrix.length) return false;
        int low = 0, high = matrix[row].length-1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(matrix[row][mid] == target) return true;
            if(target > matrix[row][mid]) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}