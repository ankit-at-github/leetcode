class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++) memo[i][j] = -1;
        }
        return minimumSum(0, 0, triangle, memo);
    }
    public int minimumSum(int row, int index, List<List<Integer>> triangle, int[][] memo)
    {
        if(row >= triangle.size()) return 0;
        
        if(memo[row][index] != -1) return memo[row][index];
        
        int min = Integer.MAX_VALUE;
        
        int noStep = triangle.get(row).get(index) + minimumSum(row+1, index, triangle, memo);
        
        int oneStep = triangle.get(row).get(index) + minimumSum(row+1, index+1, triangle, memo);
        
        min = Math.min(noStep, oneStep);
        
        return memo[row][index] = min;
    }
}