class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int s = 1;
        while(s <= n*n)
        {
            //top
            for(int i=left; i<=right; i++)
            {
                mat[left][i] = s++;
            }
            top++;
            
            //right
            for(int i=top; i<=bottom; i++)
            {
                mat[i][bottom] = s++;
            }
            right--;
            
            //bottom
            for(int i=right; i>=left; i--)
            {
                mat[bottom][i] = s++;
            }
            bottom--;
            
            //left
            for(int i = bottom; i>=top; i--)
            {
                mat[i][left] = s++;;
            }
            left++;
        }
        return mat;
    }
}