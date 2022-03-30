class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int searchRow = 0;
        int column = matrix[0].length-1;
        for(int i=0; i<matrix.length; i++)
        {
            if(target <= matrix[i][column])
            {
                searchRow = i;
                break;
            }
        }
        
        //if(matrix[searchRow][matrix.length-1] == target) return true;
        int start = 0, end = matrix[0].length-1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            
            if(matrix[searchRow][mid] == target) return true;
            else
            {
                if(target > matrix[searchRow][mid]) start = mid+1;
                else end = mid-1;
            }
        }
        return false;
    }
}