class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //Applying binary search on value. Minvalue is first element of matrix and Maxvalue is last element of matrix, due given sorted property of matrix.
        //1. Apply binary search on value
        //2. Search for count of minimum elements <= mid
        
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n-1][n-1];
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            int count = findSmall(matrix, mid);
            
            if(count >= k){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int findSmall(int[][] matrix, int target){
        int n = matrix.length;
        int row = n-1, col = 0;
        int count = 0;
        while(row >= 0 && col < n){
            if(matrix[row][col] > target){
                row--;
            }else{
                //elements of this column are all greater, check next column
                count += row+1;
                col++;
            }
        }
        return count;
    }
}