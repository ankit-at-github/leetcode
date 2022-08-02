class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        while(row >= 0)
        {
            if(target > matrix[row][col]) break;
            row--;
        }
        row++;
        if(row >= matrix.length) return false;
        return binarySearch(matrix, row, col, target);
    }
    public boolean binarySearch(int[][] matrix, int row, int col, int target)
    {
        int left = 0, right = col;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            
            if(matrix[row][mid] == target) return true;
            
            if(target > matrix[row][mid]) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}