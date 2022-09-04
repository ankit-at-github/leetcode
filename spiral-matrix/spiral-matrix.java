class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int right = n-1;
        int bottom = m-1;
        int left = 0;
        int count = 0;
        while(count < m*n)
        {
            //top
            for(int i=top; i<=right && count<m*n; i++)
            {
                ans.add(matrix[top][i]);
                count++;
            }
            top++;
            //right
            for(int i=top; i<=bottom && count<m*n; i++)
            {
                ans.add(matrix[i][right]);
                count++;
            }
            right--;
            //bottom
            for(int i=right; i>=left && count<m*n; i--)
            {
                ans.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            //left
            for(int i=bottom; i>=top && count<m*n; i--)
            {
                ans.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return ans;
    }
}