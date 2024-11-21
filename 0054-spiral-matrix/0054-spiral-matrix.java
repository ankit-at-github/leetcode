class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int top = 0, bottom = m - 1;
        int left = 0, right = n-1;
        while(ans.size() < m*n){
            
            //Traverse Right
            for(int j = left; j <= right; j++) ans.add(matrix[top][j]);
            top++;
            
            //Traverse Down
            for(int i = top; i <= bottom; i++) ans.add(matrix[i][right]);
            right--;
            
            if(top <= bottom){
                //Traverse Left
                for(int j = right; j >= left; j--) ans.add(matrix[bottom][j]);
            }
            bottom--;
            
            if(left <= right){
                //Traverse Up
                for(int i = bottom; i >= top; i--) ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}